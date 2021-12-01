(ns clj.solutions.day1
  (:require [clojure.string :as str]))

(defn- task-1
  [numbers]
  (->> numbers
       (partition 2 1)
       (filter #(apply < %))
       count))

(defn task-2
  [numbers]
  (->> numbers
       (partition 3 1)
       (map #(reduce + %))
       (partition 2 1)
       (filter #(apply < %))
       count))

(defn solve
  [input]
  (let [numbers (as-> input $ (str/split $ #"\n") (map #(Integer/parseInt %) $))]
    (println (task-1 numbers))))