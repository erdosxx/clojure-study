
(+ 1 2)

(odd? 2)

(number? 1)

(number? 1)

(number? +)

(fn? +)

(fn? 1)

(+ 1 (- 4 2))


(fn [n] (+ n n))

((fn [n] (+ n n)) 2)
(+ 1 2)

(fn [n] (assign n (+ 1 n)) (+ n n))

(def twice (fn [n] (+ n n)))
(twice 2)

(def two 2)
(twice two)

(def twice (fn [n] (- n n)))
(twice 10)


;; Darn! (This, by the way, is a Clojure comment.)
(def twice (fn [n] (+ n n)))
(twice 10)

'(1 2)
(quote (1 2))
(list 1 2 3 4)
(first '(1 2 3 4))
(rest '(1 2 3 4))
(nth '(1 2 3 4) 2)

(def second (fn [list] (nth list 1)))
(second '(1 2 3 4))

(nth '() 1)
(if (nil? 1) (prn "nil") (prn "not nil"))
(count '(1 2 3))
(== 1 1)
(nth '(1 2) 1)

(def third (fn [list] (nth list 2)))
(third '(1 2 3 4))

(def third-2 (fn [list] (first (rest (rest list)))))
(third-2 '(1 2 3 4))

[1 2 3 4]

(vector 1 2 3 4)

(sequential? [1 2 3])
(sequential? '(1 2 3))
(rest [1 2 3])
(list? (rest [1 2 3]))
(seq? (rest [1 2 3]))
(vector? (rest [1 2 3]))

(= [2 3] '(2 3))
(= [2 3] (rest [1 2 3]))

(sequential? '(1 2 3))
(sequential? [1 2 3])
(sequential? (rest [1 2 3]))

(seq? '(1 2 3))
(seq? [1 2 3])
(seq? (rest [1 2 3]))

(list? '(1 2 3))
(list? [1 2 3])
(list? (rest [1 2 3]))

(vector? '(1 2 3))
(vector? [1 2 3])
(vector? (rest [1 2 3]))

(coll? '(1 2 3))
(coll? [1 2 3])
(coll? (rest [1 2 3]))

[(+ 1 1) (- 1 1)]
[inc dec]
'[inc dec]
['my 'number (+ 1 3)]

(if (odd? 3) (prn "Odd!") (prn "Even!"))

((fn [& args] args) 1 2 3 4)

[1 4 9 16]
(+ 1 4 9 16)
(apply + [1 4 9 16])
(apply + '(1 4 9 16))

(cons "the first element" [1 2 3])
(my-apply + [1 2 3])

(filter odd? [1 2 3 4])
(first (filter odd? [1 2 3 4]))


(map inc [0 1 2 3])
(map * [0 1 2 3] [100 200 300 400])


;; Exercise 1.3

(def make-list (fn [& args] args))
(make-list 1 2 3 4)
(def squares (fn [lst] (map * lst lst)))
(def addsquares-list (fn [lst] (my-apply + (squares lst))))
(def addsquares (fn [& args] (my-apply + (addsquares-list (make-list args)))))
(my-apply + (vector (1 2 3 4)))
(squares [1 2 3 4])
(my-apply + (squares [1 2 3 4]))
(addsqures-list [1 2 3 4])
(vector (make-list 1 2 3 4))
(addsqures 1 2 3 4)
