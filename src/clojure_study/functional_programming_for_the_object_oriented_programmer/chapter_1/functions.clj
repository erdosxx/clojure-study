(ns clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-1.functions)


(def my-second
  (fn [list]
    (if (< (count list) 2) nil
        (nth list 1))))


(def my-apply
  (fn [function sequence]
    (eval
      (cons function sequence))))
