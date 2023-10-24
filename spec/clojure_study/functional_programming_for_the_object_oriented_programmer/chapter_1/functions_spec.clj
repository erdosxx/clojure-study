(ns clojure-study.core-spec
  (:require
    [clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-1.functions :refer :all]
    [speclj.core :refer :all]))


(describe "my-second"
          (it "for empty list return nil"
              (should-be-nil (my-second '())))

          (it "for empty vector return nil"
              (should-be-nil (my-second [])))

          (it "for one element list return nil"
              (should-be-nil (my-second '(1))))

          (it "for one element vector return nil"
              (should-be-nil (my-second [1])))

          (it "for two elements list return 2nd"
              (should= 2 (my-second '(1 2))))

          (it "for two elements vector return 2nd"
              (should= 2 (my-second [1 2])))

          (it "for three elements list return 2nd"
              (should= 2 (my-second '(1 2 3))))

          (it "for three elements vector return 2nd"
              (should= 2 (my-second [1 2 3])))

          (it "for 10 elements list return 2nd"
              (should= 2 (my-second
                           (eval (cons range '(1 11))))))

          (it "for 10 elements list return 2nd"
              (should= 2 (my-second
                           (vec (range 1 11))))))


(describe "my-third"
          (it "for empty list return nil"
              (should-be-nil (my-third '())))

          (it "for empty vector return nil"
              (should-be-nil (my-third [])))

          (it "for one element list return nil"
              (should-be-nil (my-third '(1))))

          (it "for one element vector return nil"
              (should-be-nil (my-third [1])))

          (it "for two elements list return 2nd"
              (should-be-nil (my-third '(1 2))))

          (it "for two elements vector return 2nd"
              (should-be-nil (my-third [1 2])))

          (it "for three elements list return 2nd"
              (should= 3 (my-third '(1 2 3))))

          (it "for three elements vector return 2nd"
              (should= 3 (my-third [1 2 3])))

          (it "for 10 elements list return 2nd"
              (should= 3 (my-third
                           (eval (cons range '(1 11))))))

          (it "for 10 elements list return 2nd"
              (should= 3 (my-third
                           (vec (range 1 11))))))


(describe "my-third-2"
          (it "for empty list return nil"
              (should-be-nil (my-third-2 '())))

          (it "for empty vector return nil"
              (should-be-nil (my-third-2 [])))

          (it "for one element list return nil"
              (should-be-nil (my-third-2 '(1))))

          (it "for one element vector return nil"
              (should-be-nil (my-third-2 [1])))

          (it "for two elements list return 2nd"
              (should-be-nil (my-third-2 '(1 2))))

          (it "for two elements vector return 2nd"
              (should-be-nil (my-third-2 [1 2])))

          (it "for three elements list return 2nd"
              (should= 3 (my-third-2 '(1 2 3))))

          (it "for three elements vector return 2nd"
              (should= 3 (my-third-2 [1 2 3])))

          (it "for 10 elements list return 2nd"
              (should= 3 (my-third-2
                           (eval (cons range '(1 11))))))

          (it "for 10 elements list return 2nd"
              (should= 3 (my-third-2
                           (vec (range 1 11))))))


(describe "my-apply"

          (it "applies + to a sequence of arguments"
              (should= 6 (my-apply + [1 2 3])))

          (it "applies * to a sequence of arguments"
              (should= 6 (my-apply * [1 2 3])))

          (it "applies / to a sequence of arguments"
              (should= 1/6 (my-apply / [1 2 3]))))


(run-specs)
