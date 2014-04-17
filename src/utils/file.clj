(ns utils.file
  (require [clojure.java.io :as io]
           [clojure.string :as str]
           [clojure.set :as s]))


(defn diff
  [left right]
  (with-open [rdr-l (io/reader left)
              rdr-r (io/reader right)]
    (let [set-l (set (for [line-l (line-seq rdr-l)] (str/trim line-l))) 
          set-r (set (for [line-r (line-seq rdr-r)] (str/trim line-r)))]
     (s/difference set-l set-r))))


(defn read-to-set [file]
  (with-open [rdr (io/reader file)]
    (set (for [line (line-seq rdr)] (str/trim line)))))
