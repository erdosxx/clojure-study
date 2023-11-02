(ns clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-3.exercise)

{:a 1, "b" 2}
{:a 1 "b" 2}

(hash-map :a 1 :b 2)
(apply hash-map [:a 1 :b 2])

(get {:a 1 :b 2} :a)

(get {} :x)

(:a {:a 1 :b 2})


(defn do-something-to-map
  [function]
  (function {:a "a value" :b "b value"}))


(do-something-to-map :a)
(do-something-to-map count)

({:a 1 :b 2} :a)
(["zero" "one"] 0)

(assoc {:a 1 :b 2} :c 3)
(assoc {:a 1 :b 2} :c 3 :d 4 :e 5)
(merge {:a 1 :b 2} {:c 3 :d 4} {:e 5})
(dissoc {:a 1 :b 2 :c 3} :b :c)

(assoc {:a 1} :a 2222)
(merge {:a 1 :b 2 :c 3} {:a 111 :b 222 :d 4} {:b "two"})


(def Point
  (fn [x y] {:x x :y y}))


(:x (Point 1 2))


(def x
  (fn [this] (get this :x)))


(x (Point 1 2))


(def x-2
  (fn [this] (:x this)))


(x-2 (Point 1 2))

(def x-3 :x)

(x-3 (Point 1 2))


(def Point-2
  (fn [x y]
    {:x x :y y :__class_symbol__ 'Point-2}))


(def class-of :__class_symbol__)

(class-of (Point-2 1 2))


(def shift
  (fn [this xinc yinc]
    (Point-2 (+ (:x this) xinc) (+ (:y this) yinc))))


(shift (Point-2 1 200) -1 -200)

