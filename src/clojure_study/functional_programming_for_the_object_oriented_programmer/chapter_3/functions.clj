(ns clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-3.functions)

(def point {:x 1, :y 2, :__class_symbol__ 'Point})


(def Point
  (fn [x y]
    {:x x,
     :y y
     :__class_symbol__ 'Point}))


(def x :x)
(def y :y)
(def class-of :__class_symbol__)


(def shift
  (fn [this xinc yinc]
    (Point (+ (x this) xinc)
           (+ (y this) yinc))))


(defn add
  "Add two Points"
  [p1 p2]
  (Point (+ (:x p1) (:x p2)) (+ (:y p1) (:y p2))))


(defn add-2
  "Add two Points by shift"
  [p1 p2]
  (shift p1 (:x p2) (:y p2)))


(defn make
  "make constructor"
  [& args]
  (apply (first args) (rest args)))


(def Triangle
  (fn [point1 point2 point3]
    {:point1 point1, :point2 point2, :point3 point3
     :__class_symbol__ 'Triangle}))


(def right-triangle
  (Triangle (Point 0 0)
            (Point 0 1)
            (Point 1 0)))


(def equal-right-triangle
  (Triangle (Point 0 0)
            (Point 0 1)
            (Point 1 0)))


(def different-triangle
  (Triangle (Point 0 0)
            (Point 0 10)
            (Point 10 0)))


(defn equal-triangle?
  "Check equality of the triangles"
  [& args]
  (apply = args))


(defn valid-triangle?
  "check duplicate between points"
  [& args]
  (and (= (count args) 3)
       (= (count (distinct args)) 3)))
