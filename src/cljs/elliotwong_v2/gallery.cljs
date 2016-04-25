(ns elliotwong-v2.gallery)

(defn gallery-link [image thumb title]
  [:div {:class "col-md-2 col-sm-3 col-xs-6"}
   [:a {:href image
        :rel "lightbox[gallery]"
        :title title}
    [:img {:src thumb :class "img-thumbnail"}]]])

(defn component-gallery []
  [:div {:class "row"}
   [:div {:class "gallery col-md-12" :id "links" :data-use-bootstrap-modal "false"}
    (gallery-link "/images/gallery/pic_0001.jpg" "/images/gallery/pic_0001_thumb.jpg" "Desert From Above (SOLD) 36x48")
    (gallery-link "/images/gallery/pic_0002.jpg" "/images/gallery/pic_0002_thumb.jpg" "Mountains in Mist 30x40")
    (gallery-link "/images/gallery/pic_0003.jpg" "/images/gallery/pic_0003_thumb.jpg" "Sunset at El Cap 24x24")
    (gallery-link "/images/gallery/pic_0004.jpg" "/images/gallery/pic_0004_thumb.jpg" "Plume 36x24")
    (gallery-link "/images/gallery/pic_0005.jpg" "/images/gallery/pic_0005_thumb.jpg" "Forest at Dawn (SOLD) 36x48")
    (gallery-link "/images/gallery/pic_0006.jpg" "/images/gallery/pic_0006_thumb.jpg" "The Spire, Eagle Nebula 40x30")
    (gallery-link "/images/gallery/pic_0007.jpg" "/images/gallery/pic_0007_thumb.jpg" "Sunset on Fields 36x48")
    (gallery-link "/images/gallery/pic_0008.jpg" "/images/gallery/pic_0008_thumb.jpg" "Swan Nebula 24x30")
    (gallery-link "/images/gallery/pic_0009.jpg" "/images/gallery/pic_0009_thumb.jpg" "Alaskan Bay 36x48")
    (gallery-link "/images/gallery/pic_0010.jpg" "/images/gallery/pic_0010_thumb.jpg" "Pillars of Creation, Eagle Nebula 48x36")
    (gallery-link "/images/gallery/pic_0011.jpg" "/images/gallery/pic_0011_thumb.jpg" "Reflection Nebula 28x30")
    (gallery-link "/images/gallery/pic_0012.jpg" "/images/gallery/pic_0012_thumb.jpg" "Boise River 46x60")
    (gallery-link "/images/gallery/P1000640.jpg" "/images/gallery/P1000640_thumb.jpg" "")
    (gallery-link "/images/gallery/P1000642.jpg" "/images/gallery/P1000642_thumb.jpg" "")
    (gallery-link "/images/gallery/P1000644.jpg" "/images/gallery/P1000644_thumb.jpg" "")]])
