(ns clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-5.exercise
  (:require
    [clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-5.functions :refer :all]))


(* (+ 1 2) (+ 1 2) 5)

((fn [name] (* name name 5)) (+ 1 2))

(let [name (+ 1 2)] (* name name 5))

(+ 1 (let [one 1] (* one one)) 3)

(let [one 1 two 2] (+ one two))

(let [little-map {:a 1} bigger-map (assoc little-map :b 2)] bigger-map)

(def starting-map {:a 1})
(def bigger-map (assoc starting-map :b 2))
bigger-map
(assoc bigger-map :a 33)

(def point (make Point 1 2))


(def Point
  {:__own_symbol__ 'Point
   :__instance_methods__ {:origin
                          (fn [this] (make Point 0 0))

                          :class
                          (fn [this]
                            (eval (:__class_symbol__ this)))

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


(send-to point :origin)
