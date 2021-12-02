(ns clj.core
  (:gen-class)
  (:require [clj.solutions.day2 :refer [solve]]))

(def input (atom ""))

(defn read-input
  []
  (doseq [ln (line-seq (java.io.BufferedReader. *in*))]
    (swap! input str (str ln "\n")))
  @input)

(defn -main
  [& args]
  (let [input (read-input)]
    (solve input)))