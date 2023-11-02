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


(defn add-squares
  "Add squares for input params"
  [& args]
  (if (nil? args) nil
      (reduce + (map * args args))))


(defn factorial
  "return factorial of n"
  [num]
  (if (or (= num 0) (= num 1)) 1 (reduce * (range 1 (+ 1 num)))))


(defn prefix-of?
  "check prefix of second list are same as first list"
  [prefix list]
  (if (> (count prefix) (count list)) false
      (every? true? (map = prefix list))))


(defn tails
  "Returns a sequence of successively smaller subsequences of the argument"
  [list]
  (if (= list '()) '(())
      (map drop (range (+ (count list) 1)) (repeat (+ (count list) 1) list))))


(defn puzzle
  "Exercise 8"
  [list]
  (list list))
