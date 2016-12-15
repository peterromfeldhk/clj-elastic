(ns clj-elastic.main
  (:import
    (org.elasticsearch.client.transport TransportClient)
    (org.elasticsearch.common.transport InetSocketTransportAddress)
    (org.elasticsearch.transport.client PreBuiltTransportClient)
    (org.elasticsearch.common.settings Settings)))

(comment
  "So far trials (also without type hinting):"

  (def ^TransportClient client
    (-> (Settings/builder)
        (.put "cluster.name" "elasticsearch_pair")
        (.build)
        (PreBuiltTransportClient.)))

  (def ^TransportClient client
    (let [^Settings s (-> (Settings/builder)
                          (.put "cluster.name" "elasticsearch_pair")
                          (.build))]
      (PreBuiltTransportClient. s)))

  (def ^TransportClient client
    (let [^Settings s (doto (Settings/builder)
                        (.put "cluster.name" "elasticsearch_pair")
                        (.build))]
      (PreBuiltTransportClient. s)))

  (def ^TransportClient client
    (let [^Settings s (.build (doto (Settings/builder)
                                (.put "cluster.name" "elasticsearch_pair")))]
      (PreBuiltTransportClient. s)))

  (def ^TransportClient client
    (let [s (.build (doto (Settings/builder)
                      (.put "cluster.name" "elasticsearch_pair")))]
      (PreBuiltTransportClient. s)))

  (def ^TransportClient client
    (let [s (doto (Settings/builder)
              (.put "cluster.name" "elasticsearch_pair")
              (.build))]
      (PreBuiltTransportClient. s)))

  (def ^TransportClient client
    (let [s (-> (Settings/builder)
                (.put "cluster.name" "elasticsearch_pair")
                (.build))]
      (PreBuiltTransportClient. s)))
  )
