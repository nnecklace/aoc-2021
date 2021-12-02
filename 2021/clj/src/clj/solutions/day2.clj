(ns clj.solutions.day2
  (:require [clojure.string :as str]))

(defn task-1
  [commands]
  (->> commands
       (reduce (fn [acc item]
                 (case (first item)
                   "forward" (update acc :horizontal + (second item))
                   "down" (update acc :vertical + (second item))
                   "up" (update acc :vertical - (second item))))
               {:horizontal 0 :vertical 0})
       vals
       (apply *)))

(defn task-2
  [commands]
  (->> commands
       (reduce
        (fn [acc item]
          (case (first item)
            "up" (update acc :aim - (second item))
            "down" (update acc :aim + (second item))
            "forward" (-> acc (update :horizontal + (second item)) (update :vertical + (* (second item) (:aim acc))))))
        {:horizontal 0 :vertical 0 :aim 0})))

(defn solve
  [input]
  (let [numbers (as-> input $ (str/split $ #"\n") (map #(str/split % #" ") $) (map #(vector (first %) (Integer/parseInt (second %))) $))]
    (println (task-1 numbers))))

