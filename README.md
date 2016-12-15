# clj-elastic

Documentation is here:
https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/transport-client.html

and Javadocs here:
https://www.javadoc.io/doc/org.elasticsearch/elasticsearch/5.1.1

On OSX you can easily install elasticsearch with `brew`
```bash
brew install elasticsearch
brew services start elasticsearch
```

by default the clustername will be `elasticsearch_<username>`

you can also install kibana and check it out at `http://localhost:5601`

```bash
brew install kibana
brew services start kibana
```

For testing you can open a repl and index your first tweet :)
```clojure
(require '[clj-elastic.main :as main]
         '[clj-elastic.sys :as sys])
(import 'java.util.Date)

(def test-sys (com.stuartsierra.component/start (sys/test-sys)))
(main/index test-sys "twitter" "tweet"
            {"user"     "kimchy"
             "postDate" (Date.)
             "message"  "trying out Elasticsearch again :)"})
(com.stuartsierra.component/stop test-sys)
```
