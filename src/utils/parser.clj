(ns utils.parser
  (require [clojure.java.io :as io]
           [clojure.string :as str]))


(defn parse-log-file [file]
  (with-open [rdr (io/reader file)]
    (->> rdr
         line-seq
         doall
         (partition 2)
         (map #(map str/trim %))
         flatten
         (apply sorted-map))))

