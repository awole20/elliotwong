(ns elliotwong-v2.core
  (:require [reagent.core :as reagent :refer [atom]]
            [bidi.bidi :as bidi]
            [pushy.core :as pushy]
            [elliotwong-v2.gallery :as gallery]
            [elliotwong-v2.about :as about]
            [elliotwong-v2.contact :as contact]))

(enable-console-print!)

(defonce old-history (atom {:history false}))

(when-let [old-history (:history @old-history)]
  (print (str "stopping old history... " old-history))
  (pushy/stop! old-history))

(def app-routes [
                 "/" {(bidi/alts "" "index.html") :gallery
                      "about" :about
                      "contact" :contact
                      true :not-found}])

(def app-state (atom {:text "Hello Chestnut!"
                      :gallery-link (bidi/path-for app-routes :gallery)
                      :about-link (bidi/path-for app-routes :about)
                      :contact-link (bidi/path-for app-routes :contact)}))

(def match-route (partial bidi/match-route app-routes))

(defn component-links [gallery-link about-link contact-link]
  [:ul {:id "nav" :class "nav"}
    [:li
     [:a {:href gallery-link} "Home"]]
    [:li
     [:a {:href about-link} "About"]]
   [:li
     [:a {:href contact-link} "Contact"]]])

(defn component-not-found []
  [:div
   [:h1 "Not Found"]
   [:div "Page not found"]])

(defn component-main []
  [:div {:class "container-fluid"}
   [:nav {:class "navbar navbar-default navbar-fixed-top"}
    [:div {:class "container-fluid"}
     [:div {:class "navbar-header"}
      [:button {:type "button"
                :class "navbar-toggle collapsed"
                :data-toggle "collapse"
                :data-target "#navigate"
                :aria-expanded "false"}
       [:span {:class "icon-bar"}]
       [:span {:class "icon-bar"}]
       [:span {:class "icon-bar"}]]
      [:a {:class "navbar-brand" :href "/"} "Elliot Wong"]]
     [:div {:class "collapse navbar-collapse" :id "navigate"}
      [:ul {:class "nav navbar-nav navbar-right" :id "navigate"}
       [:li [:a {:href (:gallery-link @app-state)} "Gallery"]]
       [:li [:a {:href (:about-link @app-state)} "About"]]
       [:li [:a {:href (:contact-link @app-state)} "Contact"]]]]]]
   [:div {:class "content"}
    [component-links
     (:gallery-link @app-state)
     (:about-link @app-state)
     (:contact-link @app-state)]
    [:div {:class "main"}
     [(:view @app-state)]]]
   [:div {:class "footer"}
    [:p {:dangerouslySetInnerHTML {:__html (str "&copy; " (.getFullYear (js/Date.)) " Elliot Wong")}}]]])

(defn render-app []
  (reagent/render-component [component-main]
                            (.getElementById js/document "app")))

(defmulti dispatch (fn [{:keys [handler] :as match}] handler))

(defmethod dispatch :gallery [_]
  (swap! app-state assoc :view gallery/component-gallery))

(defmethod dispatch :about [_]
  (swap! app-state assoc :view about/component-about))

(defmethod dispatch :contact [_]
  (swap! app-state assoc :view contact/component-contact))

(defmethod dispatch :not-found [_]
  (swap! app-state assoc :text "not found. Check out this 404 thingy.")
  (swap! app-state assoc :view component-not-found))

(defmethod dispatch :default [_]
  (dispatch {:handler :not-found}))

(defn set-page! [match]
  (swap! app-state assoc :page match)
  (dispatch match))

(def history
  (pushy/pushy set-page! match-route))

(pushy/start! history)
(swap! old-history assoc :history history)

(render-app)
