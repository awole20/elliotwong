(ns elliotwong-v2.splash)
(defn gallery-carousel [link]
  [:div {:id "gallery-carousel" :class "carousel slide" :data-ride "carousel"}
   [:a {:href link}
    [:div {:class "carousel-inner container" :role "listbox"}
     [:div {:class "item active"}
      [:img {:style {"margin" "auto"} :src "/images/gallery/pic_0001.jpg" :alt "alt"}]]
     [:div {:class "item"}
      [:img {:style {"margin" "auto"} :src "/images/gallery/pic_0002.jpg" :alt "alt"}]]]]
   [:a {:class "left carousel-control" :href "#gallery-carousel" :role "button" :data-slide "prev"}
    [:span {:class "glyphicon glyphicon-chevron-left" :aria-hidden "true"}]
    [:span {:class "sr-only"} "Previous"]]
   [:a {:class "right carousel-control" :href "#gallery-carousel" :role "button" :data-slide "next"}
    [:span {:class "glyphicon glyphicon-chevron-right" :aria-hidden "true"}]
    [:span {:class "sr-only"} "Next"]]])
(defn component-splash [link]
  (gallery-carousel link))
