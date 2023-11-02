(ns clojure-study.core-spec
  (:require
    [clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-3.functions :refer :all]
    [speclj.core :refer :all]))


(describe "Add two Points"
          (it "Add case 1"
              (should= {:x 1 :y 2 :__class_symbol__ 'Point} (add (Point 0 0) (Point 1 2))))
          (it "Add case 2"
              (should= {:x 2 :y 4 :__class_symbol__ 'Point} (add (Point 1 1) (Point 1 3)))))


(describe "Add two Points by shift"
          (it "Add case 1"
              (should= {:x 1 :y 2 :__class_symbol__ 'Point} (add-2 (Point 0 0) (Point 1 2))))
          (it "Add case 2"
              (should= {:x 2 :y 4 :__class_symbol__ 'Point} (add-2 (Point 1 1) (Point 1 3)))))


(describe "make constructor"
          (it "make Point"
              (should= (Point 0 1) (make Point 0 1)))
          (it "make Point"
              (should= (Point 3 5) (make Point 3 5))))


(describe "make Triangle"
          (it "make Triangple"
              (should= (Triangle (Point 1 2) (Point 1 3) (Point 3 1))
                       (make Triangle (make Point 1 2) (make Point 1 3)
                             (make Point 3 1)))))


(describe "equal-triangle?"
          (it "compare two idential objects"
              (should= true (equal-triangle? right-triangle right-triangle)))
          (it "compare two not idential, but contents are equal"
              (should= true (equal-triangle? right-triangle equal-right-triangle)))
          (it "compare two different objects"
              (should= false (equal-triangle? right-triangle different-triangle)))
          (it "compare three objects"
              (should= false (equal-triangle? right-triangle equal-right-triangle different-triangle))))


(describe "valid-triangle?"
          (it "for all different points"
              (should= true (valid-triangle? (Point 0 0) (Point 0 1) (Point 1 0))))
          (it "Case 1: for two duplicated points"
              (should= false (valid-triangle? (Point 0 0) (Point 0 0) (Point 1 0))))
          (it "Case 2: for two duplicated points"
              (should= false (valid-triangle? (Point 1 0) (Point 0 0) (Point 0 0))))
          (it "Case 3: for two duplicated points"
              (should= false (valid-triangle? (Point 0 0) (Point 1 0) (Point 0 0))))
          (it "for three same points"
              (should= false (valid-triangle? (Point 0 0) (Point 0 0) (Point 0 0))))

          (it "for four points with three different"
              (should= false (valid-triangle? (Point 0 0) (Point 0 0) (Point 0 1) (Point 1 1)))))


(run-specs)
