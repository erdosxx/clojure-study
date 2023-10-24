(ns clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-1.functions)


(defn my-second
  "Ex1: Get second element ffrom list or vector"
  [list]
  (if (< (count list) 2) nil
      (nth list 1)))


(defn my-third
  "Ex2: Get third element from list or vector"
  [list]
  (if (< (count list) 3) nil
      (nth list 2)))


(defn my-third-2
  "Ex2: Get third element from list or vector"
  [list]
  (if (< (count list) 3) nil
      (first (rest (rest list)))))


(def my-apply
  (fn [function sequence]
    (eval
      (cons function sequence))))
