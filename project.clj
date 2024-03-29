(defproject
  clj-elastic
  "0.1.0-SNAPSHOT"
  :dependencies
  [[org.clojure/clojure "1.8.0"]

   [org.danielsz/system "0.3.1"]

   [org.apache.logging.log4j/log4j-core "2.7"]
   [org.apache.logging.log4j/log4j-api "2.7"]

   [org.elasticsearch.client/transport "5.1.1"]

   ]
  :resource-paths ["resources"]
  :source-paths ["src" "test"])
