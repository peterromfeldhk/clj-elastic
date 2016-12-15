(ns clj-elastic.main
  (:import
    (org.elasticsearch.client.transport TransportClient)
    (org.elasticsearch.transport.client PreBuiltTransportClient)
    (org.elasticsearch.common.settings Settings)
    (org.elasticsearch.common.transport InetSocketTransportAddress)
    (java.net InetSocketAddress)))

(defn index [{:keys [elastic] :as sys} index type data]
  (-> (:client elastic)
      (.prepareIndex index type)
      (.setSource data)
      (.get)))
