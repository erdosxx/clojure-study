(ns clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-4.functions-spec
  (:require
    [clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-3.functions :refer [make]]
    [clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-4.functions :refer [Point send-to]]
    [speclj.core :refer [describe should= it run-specs]]))


(def point (make Point 1 2))
(def point-2 (make Point 2 4))


(describe "send-to"
          (it "use shift and check x"
              (should= -1 (:x (send-to point :shift -2 -3))))
          (it "use shift and check y"
              (should= -1 (:y (send-to point :shift -2 -3)))))


(describe "get"
          (it "get :x"
              (should= 1 (send-to point :x)))
          (it "get :y"
              (should= 2 (send-to point :y))))


(describe "add"
          (it "Add two points and check :x"
              (should= 3 (:x (send-to point :add point-2))))
          (it "Add two points and check :y"
              (should= 6 (:y (send-to point :add point-2)))))


(run-specs)
