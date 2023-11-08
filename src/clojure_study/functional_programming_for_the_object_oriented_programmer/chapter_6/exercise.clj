(ns clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-6.exercise)

(filter some? (map #(if (= %1 %2) :pos) [0 0 0 0] [0 1 1 0]))
(second [1 2 3 4])
(partition 2 (interleave [1 2 3 4] [1 2 3 4]))

(filter identity (map #(= %1 %2) [0 0 0 0] [0 1 1 0]))
(contains? (set [1 2 2 3]) 3)


(defn count-of
  [value values]
  (count (filter #(= value %) values)))


(defn over-count
  [code guess]
  (let [code-values (set code)]
    (reduce + (filter pos?
                      (map #(- (count-of % guess) (count-of % code)) code-values)))))


(over-count [1 2 3 4] [1 1 1 1])


(defn over-count-2
  [code guess]
  (let [code-values (set code)]
    (->>
      (map #(- (count-of % guess) (count-of % code)) code-values)
      (filter pos?)
      (reduce +))))


(over-count-2 [1 2 3 4] [1 1 1 1])

(->> 1 pos?)
(pos? 1)
(macroexpand '(->> 1 pos?))


(defn guess-to-number
  [guess]
  (reduce #(+ (*  6 %1) %2) guess))


(guess-to-number [1 0 0 0])


(defn number-to-guess
  [n]
  ;; [(rem (quot n 216) 6) (rem (quot n 36) 6) (rem (quot n 6) 6) (rem n  6)]
  (loop [guess (list)
         num n]
    (if (= 4 (count guess))
      guess
      (recur (cons (rem num 6) guess) (quot num 6)))))


(number-to-guess 6)
(number-to-guess 216)
(number-to-guess 259)


(for [x ['a 'b 'c'] y [1 2 3]]
  [x y])


(every? identity [false false])


(defn sum-reduce
  [integers]
  (loop [[first & rest] integers accumulator 0]
    (if (nil? first) accumulator
        (recur rest (+ accumulator first)))))


(sum-reduce (range 1 10000000))
