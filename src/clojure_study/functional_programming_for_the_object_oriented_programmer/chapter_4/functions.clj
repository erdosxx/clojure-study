(ns clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-4.functions
  (:require
    [clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-3.functions :as ch3]))


(def send-to
  (fn [instance message & args]
    (let [method (message (:__methods__ instance))]
      (if (nil? args)
        (apply method instance [])
        (apply method instance args)))))


(def Point
  (fn [x y]
    {;; initializing instance variables
     :x x,
     :y y

     ;; Metadata
     :__class_symbol__ 'Point
     :__methods__ {:class :__class_symbol__

                   :x
                   (fn [this]
                     (:x this))
                   :y
                   (fn [this]
                     (:y this))
                   :shift
                   (fn [this xinc yinc]
                     (ch3/make Point (+ (send-to this :x) xinc)
                               (+ (send-to this :y) yinc)))
                   :get
                   (fn [this attr]
                     (attr this))
                   :add
                   (fn [this other]
                     (send-to this :shift (send-to other :x) (send-to other :y)))}}))
