(defproject clojure-study "0.1.0-SNAPSHOT"
  :description "Clojure Study with code and tests"
  :url "http://evoagile.com"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :main ^:skip-aot clojure-study.core
  :plugins [[cider/cider-nrepl "0.40.0"] [speclj "3.4.3"]]
  :test-paths ["spec"]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :dev {:dependencies [[speclj "3.4.3"]]}})
