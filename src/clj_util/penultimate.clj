(ns clj-util.penultimate)

(defn penultimate
  "Lazily and recursively gets the second to last item in a given collection."
  [coll]
  (if (seq (rest (rest coll)))
    (recur (rest coll))
    (first coll)))
