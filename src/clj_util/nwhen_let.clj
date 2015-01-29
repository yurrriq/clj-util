(ns clj-util.nwhen-let
  (:require [clojure.algo.monads :refer [domonad maybe-m with-monad]]))

(defmacro nwhen-let
  "Similar to when-let, but allows multiple bindings."
  [bindings & body] `(domonad maybe-m ~bindings (do ~@body)))

#_(nwhen-let [x 1, y 2, z 3]
    (println "We did it."))

;; is roughly equivalent to

#_(when-let [x 1]
    (when-let [y 2]
      (when-let [z 3]
        (println "We did it."))))

