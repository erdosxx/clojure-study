(ns clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-6.functions)


(def class-from-instance
  (fn [instance]
    (assert (map? instance))
    (binding [*ns* (find-ns 'clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-6.functions)] (eval (:__class_symbol__ instance)))))


(def Anything
  {:__own_symbol__ 'Anything
   :__instance_methods__
   {;; default constructor
    :add-instance-values identity

    ;; these two methods have been pulled up from Point.
    :class-name :__class_symbol__
    :class (fn [this] (class-from-instance this))}})


(def class-instance-methods
  (fn [class-symbol]
    (:__instance_methods__ (binding [*ns* (find-ns 'clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-6.functions)] (eval class-symbol)))))


(def class-symbol-above
  (fn [class-symbol]
    (:__superclass_symbol__ (binding [*ns* (find-ns 'clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-6.functions)] (eval class-symbol)))))


(def lineage-1
  (fn [class-symbol so-far]
    (if (nil? class-symbol)
      so-far
      (lineage-1 (class-symbol-above class-symbol)
                 (cons class-symbol so-far)))))


(def lineage
  (fn [class-symbol]
    (lineage-1 class-symbol [])))


(def method-cache
  (fn [class]
    (let [class-symbol (:__own_symbol__ class)
          method-maps (map class-instance-methods
                           (lineage class-symbol))]
      (apply merge method-maps))))


(def apply-message-to
  (fn [class instance message args]
    (let [method (message
                   (method-cache class))]
      (if (nil? method) (message instance)
          (apply method instance args)))))


(def make
  (fn [class & args]
    (let [seeded {:__class_symbol__ (:__own_symbol__ class)}]
      (apply-message-to class seeded :add-instance-values args))))


(def send-to
  (fn [instance message & args]
    (let [class (binding [*ns* (find-ns 'clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-6.functions)] (eval (:__class_symbol__ instance)))]
      (apply-message-to class instance message args))))


(def Point
  {:__own_symbol__ 'Point
   :__superclass_symbol__ 'Anything
   :__instance_methods__ {:class
                          (fn [this]
                            (binding [*ns* (find-ns 'clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-6.functions)] (eval (:__class_symbol__ this))))

                          :class-name
                          (fn [this]
                            (:__class_symbol__ this))

                          :add-instance-values
                          (fn [this x y]
                            (assoc this :x x :y y))

                          :shift
                          (fn [this xinc yinc]
                            (make Point (+ (:x this) xinc)
                                  (+ (:y this) yinc)))}})


(def factorial
  (fn [n]
    (if (= n 0) 1
        (* n (factorial (dec n))))))


(def factorial-helper
  (fn [something so-far]
    (if (<= something 1) so-far
        (factorial-helper (dec something) (* something so-far)))))


(def factorial-2
  (fn [n]
    (factorial-helper n 1)))


(def recursive-helper
  (fn [operator something so-far]
    (if (empty? something) so-far
        (recursive-helper operator (rest something) (operator (first something) so-far)))))


(def sum-reduce
  (fn [something so-far]
    (recursive-helper + something so-far)))


(def product-reduce
  (fn [something so-far]
    (recursive-helper * something so-far)))


(def add-map-zero
  (fn [key dict]
    (assoc dict key 0)))


(def add-map-position
  (fn [key dict]
    (assoc dict key (count dict))))
