(ns elliotwong-v2.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [elliotwong-v2.core-test]))

(enable-console-print!)

(doo-tests 'elliotwong-v2.core-test)
