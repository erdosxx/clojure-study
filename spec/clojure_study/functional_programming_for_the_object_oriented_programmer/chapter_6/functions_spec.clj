(ns clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-6.functions-spec
  (:require
    [clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-6.functions :as ch6]
    [speclj.core :as sp]))


(sp/describe "Exercise 1: factorial with first pattern"
             (sp/it "factorial of 0"
                    (sp/should= 1 (ch6/factorial 0)))

             (sp/it "factorial of 1"
                    (sp/should= 1 (ch6/factorial 1)))

             (sp/it "factorial of 2"
                    (sp/should= 2 (ch6/factorial 2)))

             (sp/it "factorial of 3"
                    (sp/should= 6 (ch6/factorial 3)))

             (sp/it "factorial of 5"
                    (sp/should= 120 (ch6/factorial 5))))


(sp/describe "Exercise 2: factorial-helper with second pattern"
             (sp/it "factorial of 0"
                    (sp/should= 1 (ch6/factorial-helper 0 1)))

             (sp/it "factorial of 1"
                    (sp/should= 1 (ch6/factorial-helper 1 1)))

             (sp/it "factorial of 2"
                    (sp/should= 2 (ch6/factorial-helper 2 1)))

             (sp/it "factorial of 3"
                    (sp/should= 6 (ch6/factorial-helper 3 1)))

             (sp/it "factorial of 5"
                    (sp/should= 120 (ch6/factorial-helper 5 1))))


(sp/describe "Exercise 2: factorial-2 with factorial-helper"
             (sp/it "factorial of 0"
                    (sp/should= 1 (ch6/factorial-2 0)))

             (sp/it "factorial of 1"
                    (sp/should= 1 (ch6/factorial-2 1)))

             (sp/it "factorial of 2"
                    (sp/should= 2 (ch6/factorial-2 2)))

             (sp/it "factorial of 3"
                    (sp/should= 6 (ch6/factorial-2 3)))

             (sp/it "factorial of 5"
                    (sp/should= 120 (ch6/factorial-2 5))))


(sp/describe "Exercise 3: sum-reduce"
             (sp/it "for empty list return 0"
                    (sp/should= 0 (ch6/sum-reduce [] 0)))
             (sp/it "for one element list return that"
                    (sp/should= 1 (ch6/sum-reduce [1] 0)))
             (sp/it "for two elements list return sum of them"
                    (sp/should= 3 (ch6/sum-reduce [1 2] 0)))
             (sp/it "for three elements list return sum of them"
                    (sp/should= 6 (ch6/sum-reduce [1 2 3] 0)))
             (sp/it "for four elements list return sum of them"
                    (sp/should= 10 (ch6/sum-reduce [1 2 3 4] 0))))


(sp/describe "Exercise 4: product-reduce"
             (sp/it "for empty list return 1"
                    (sp/should= 1 (ch6/product-reduce [] 1)))
             (sp/it "for one element list return that"
                    (sp/should= 1 (ch6/product-reduce [1] 1)))
             (sp/it "for two elements list return product of them"
                    (sp/should= 2 (ch6/product-reduce [1 2] 1)))
             (sp/it "for three elements list return product of them"
                    (sp/should= 6 (ch6/product-reduce [1 2 3] 1)))
             (sp/it "for four elements list return product of them"
                    (sp/should= 24 (ch6/product-reduce [1 2 3 4] 1))))


(sp/describe "Exercise 5: recursive helper"
             (sp/it "list to map with 0 mapping"
                    (sp/should= {:a 0 :b 0 :c 0}
                                (ch6/recursive-helper ch6/add-map-zero [:a :b :c] {})))
             (sp/it "list to map with position mapping"
                    (sp/should= {:a 0 :b 1 :c 2}
                                (ch6/recursive-helper ch6/add-map-position [:a :b :c] {}))))


;; (reduce (fn [so-far val] (assoc so-far val 0)) {} [:a :b :c])
;; (reduce (fn [so-far val] (assoc so-far val (count so-far))) {} [:a :b :c])

(sp/describe "send-to with updated apply-message-to"
             (sp/it "send to class-name"
                    (sp/should= 'Point (ch6/send-to (ch6/make ch6/Point 1 2) :class-name)))
             (sp/it "send to shift"
                    (sp/should= {:y 6 :x 4 :__class_symbol__ 'Point} (ch6/send-to (ch6/make ch6/Point 1 2) :shift 3 4))))


(sp/run-specs)
