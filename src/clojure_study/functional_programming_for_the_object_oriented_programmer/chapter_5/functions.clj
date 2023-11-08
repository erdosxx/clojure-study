(ns clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-5.functions)


(def apply-message-to
  (fn [class instance message args]
    (let [method (message
                   (:__instance_methods__ class))]
      (if (nil? method) (message instance)
          (apply method instance args)))))


(def make
  (fn [class & args]
    (let [seeded {:__class_symbol__ (:__own_symbol__ class)}]
      (apply-message-to class seeded :add-instance-values args))))


(def Point
  {:__own_symbol__ 'Point
   :__instance_methods__ {:class
                          (fn [this]
                            (binding [*ns* (find-ns 'clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-5.functions)] (eval (:__class_symbol__ this))))

                          :class-name
                          (fn [this]
                            (:__class_symbol__ this))

                          :add-instance-values
                          (fn [this x y]
                            (assoc this :x x :y y))

                          :shift
                          (fn [this xinc yinc]
                            (make Point (+ (:x this) xinc)
                                  (+ (:y this) yinc)))}})


(def send-to
  (fn [instance message & args]
    (let [class (binding [*ns* (find-ns 'clojure-study.functional-programming-for-the-object-oriented-programmer.chapter-5.functions)] (eval (:__class_symbol__ instance)))]
      (apply-message-to class instance message args))))


(def send-to-Point
  (fn [instance message & args]
    (apply-message-to Point instance message args)))


(def Holder
  {:__own_symbol__ 'Holder
   :__instance_methods__
   {:add-instance-values (fn [this held]
                           (assoc this :held held))}})
