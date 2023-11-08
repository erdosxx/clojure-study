(ns-name *ns*)
(map inc [1 2])
'(map inc [1 2])
(def great-books ["East of Eden" "The Glass Bead Game"])
great-books
(ns-interns *ns*)
(get (ns-interns *ns*) 'great-books)
(ns-map *ns*)
(deref #'great-books)
(deref #'clojure-study.core/great-books)
(def great-books ["The Power of Bees" "Journey to Upstairs"])
great-books

(create-ns 'cheese.taxonmy)
(ns-name (create-ns 'cheese.taxonmy))
(in-ns 'cheese.analysis)

(in-ns 'cheese.taxonomy)
(def cheddars ["mild" "medium" "strong" "sharp" "extra sharp"])
(in-ns 'cheese.analysis)


;; cheddars
cheese.taxonomy/cheddars
clojure.string/join

(in-ns 'cheese.taxonomy)
(def cheddars ["mild" "medium" "strong" "sharp" "extra sharp"])
(def bries ["Wisconsin" "Somerset" "Brie de Meaux" "Brie de Melun"])
(in-ns 'cheese.analysis)
(clojure.core/refer 'cheese.taxonomy)


;; bries
;; cheddars
(clojure.core/get (clojure.core/ns-map clojure.core/*ns*) 'bries)
(clojure.core/get (clojure.core/ns-map clojure.core/*ns*) 'cheddars)
(clojure.core/refer 'cheese.taxonomy :only ['bries])


;; bries
;; cheddars
