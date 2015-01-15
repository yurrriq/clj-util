(ns clj-util.get-some)

(defn get-some
  "Loops through a given list of keys and returns the first matching,
  non-nil value in a given map, otherwise nil."
  [m & ks]
  (loop [ks ks]
    (when-not (empty? ks)
      (or (get m (first ks))
          (recur (rest ks))))))
