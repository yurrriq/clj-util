(ns clj-util.threading-condp)

(defmacro condp->
  "Takes an expression and a set of predicate/form pairs. Threads expr (via ->)
  through each form for which the corresponding predicate is true of expr.
  Note that, unlike cond branching, condp-> threading does not short circuit
  after the first true test expression.
  
  [Source](http://grokbase.com/t/gg/clojure/142cscbzry/cond-variant)"
  [expr & clauses]
  (assert (even? (count clauses)))
  (let [g (gensym)
        pstep (fn [[pred step]] `(if (~pred ~g) (-> ~g ~step) ~g))]
    `(let [~g ~expr
           ~@(interleave (repeat g) (map pstep (partition 2 clauses)))]
       ~g)))
