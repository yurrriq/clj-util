(ns clj-util.thrush)

(defn thrush
  "Takes the first argument and applies the remaining arguments to it
  as functions from left to right."
  {:author "Chris Houser"
   :see-also [["http://blog.fogus.me/2010/09/28/thrush-in-clojure-redux"
               "Thrush in Clojure – Redux"]]}
  [& args] (reduce #(%2 %1) args))
