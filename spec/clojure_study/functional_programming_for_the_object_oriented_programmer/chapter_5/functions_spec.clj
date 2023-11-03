(ns clojure-study.core-spec
  (:require
    [clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-5.functions :refer :all]
    [speclj.core :refer :all]))


(def a-point (make Point 1 2))


(describe "make"
          (it "make point"
              (should= a-point  (make Point 1 2))))


(describe "apply-message-to"
          (it "use shift and check x"
              (should= {:__class_symbol__ 'Point :x 2 :y 5} (apply-message-to Point a-point :shift [1 3]))))


(describe "send-to"
          (it "add-instance-values"
              (should= {:__class_symbol__ 'Point :x -1 :y -1} (send-to a-point :shift -2 -3))))


(describe ":class-name and :class"
          (it ":class-name"
              (should= 'Point (send-to a-point :class-name)))

          (it ":class"
              (should= 'Point (:__own_symbol__ (send-to a-point :class)))))


(describe "Holder instance"
          (it "make holder"
              (should= {:__class_symbol__ 'Holder ':held "stuff"} (make Holder "stuff"))))


(describe "Exercise 4: default accessor"
          (it "default accessor for Hold"
              (should= "stuff" (send-to (make Holder "stuff") :held)))
          (it "default :x accessor for Point"
              (should= 1 (send-to a-point :x)))

          (it "default :y accessor for Point"
              (should= 2 (send-to a-point :y))))


(describe "Exercise 5: some unknown message"
          (it "some unknown message for a-point"
              (should= nil (send-to a-point :unknown-message))))


(run-specs)
