(ns clojure-study.core-spec
  (:require
    [clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-1.functions :refer :all]
    [clojure.pprint :as pp]
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


(describe "add-squares"
          (it "for nil return nil"
              (should= nil (add-squares)))

          (it "for one element return square of it"
              (should= 4 (add-squares 2)))

          (it "for one element return square of it"
              (should= 4 (add-squares 2 0)))

          (it "for two elements return square sum of them"
              (should= 5 (add-squares 2 1)))

          (it "for three elements return square sum of them"
              (should= 14 (add-squares 3 2 1))))


(describe "factorial"
          (it "factorial for 0"
              (should= 1 (factorial 0)))

          (it "factorial for 1"
              (should= 1 (factorial 1)))

          (it "factorial for 2"
              (should= 2 (factorial 2)))

          (it "factorial for 3"
              (should= 6 (factorial 3))))


(take 2 (range 10))
(filter odd? [1 2 3 4])
(distinct '(5 2 1 3 2 3 5))
(concat '(1 2 3) [3 5 6])
(repeat 10 1)
(interleave [1 2 3] [4 5 6])
(drop 1 [1 2 3 4 5 6])
(drop-last 7 [1 2 3 4 5 6])
(flatten [1 2 3 [4 5 6]])
(partition 3 3 [1 2] [1 2 3 4 5 6 7])
(every? odd? [1 3 4 7])
(remove odd? [1 3 4 7])
(count [1 3 4 7])
(not false)
(inc 1)
(dec 2)
(empty? [])
(empty? ())
(nth [1 2 3 4] 2)
(last [1 2 3 4])
(reverse [1 2 3 4])
(print "Hello World")
(println "Hello World")
(prn "Hello World" "Hello World")
(pp/pprint "Hello World")


(describe "prefix-of?"
          (it "for same lists return true"
              (should= true (prefix-of? '(1) '(1))))
          (it "for disfferent lists return false"
              (should= false (prefix-of? '(1) '(2))))
          (it "for same lists return true"
              (should= true (prefix-of? '(1 2) '(1 2))))
          (it "for different lists return false"
              (should= false (prefix-of? '(1 2) '(2 2))))
          (it "for shorter prefix with macthcing list return true"
              (should= true (prefix-of? '(1) '(1 2))))
          (it "for shorter prefix with macthcing list return true"
              (should= true (prefix-of? '(1 2) '(1 2 3))))
          (it "for shorter prefix with unmacthcing list return false"
              (should= false (prefix-of? '(2) '(1 2))))
          (it "for shorter prefix with unmacthcing list return false"
              (should= false (prefix-of? '(1 2) '(1 3 2))))
          (it "for longer prefix with list return false"
              (should= false (prefix-of? '(1 2) '(1))))
          (it "for longer prefix with list return false"
              (should= false (prefix-of? '(1 2 3) '(2 3))))
          (it "for vector prefix with matching vector list return true"
              (should= true (prefix-of? [1 2] [1 2 3 4])))
          (it "for list prefix with unmatching vector list return false"
              (should= false (prefix-of? '(2 3) [1 2 3 4])))
          (it "for list prefix with matching vector list return true"
              (should= true (prefix-of? '(1 2) [1 2 3 4]))))


(concat '((1 2)) '((3 4)))
(map drop '(0 1 2) '((1 2) (1 2)  (1 2)))
(range (+ (count '(0 1)) 1))
(repeat 3 '(1 2))
(map + '(1 2) '(3 4))


(describe "tails"
          (it "for empty list return empty list"
              (should= '(()) (tails '())))
          (it "for 1 element list return same and empty list"
              (should= '((1) ()) (tails '(1))))
          (it "for 2 elements list return all subsequeces"
              (should= '((1 2) (2) ()) (tails '(1 2))))
          (it "for 3 elements list return all subsequeces"
              (should= '((1 2 3) (2 3) (3) ()) (tails '(1 2 3))))
          (it "for 4 elements list return all subsequeces"
              (should= '((1 2 3 4) (2 3 4) (3 4) (4) ()) (tails '(1 2 3 4)))))


(describe "puzzle"
          (it "Throw exception"
              (should-throw ClassCastException (puzzle '(1 2 3 4 5 6)))))


(run-specs)
