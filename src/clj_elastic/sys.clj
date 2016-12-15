(ns clj-elastic.sys
  (:require [com.stuartsierra.component :as component])
  (:import (org.elasticsearch.client.transport TransportClient)
           (org.elasticsearch.transport.client PreBuiltTransportClient)
           (org.elasticsearch.common.settings Settings)
           (org.elasticsearch.common.transport InetSocketTransportAddress)
           (java.net InetSocketAddress)))

(defn inet-addr [host port]
  (InetSocketTransportAddress. (InetSocketAddress. host port)))

(defrecord Elasticsearch [addresses settings client]
  component/Lifecycle
  (start [component]
    (let [builder (.. (Settings/builder)
                      (put ^java.util.Map settings)
                      (build))
          client (-> (PreBuiltTransportClient. builder [])
                     (.addTransportAddresses (into-array addresses)))]
      (assoc component :client client)))
  (stop [component]
    (when client
      (.close ^TransportClient client))
    (assoc component :client nil)))

(defn new-elasticsearch-db
  ([addresses]
   (new-elasticsearch-db addresses {}))
  ([addresses settings]
   (map->Elasticsearch {:addresses (for [[^String host ^int port] addresses]
                                     (inet-addr host port))
                        :settings  settings})))

(defn test-sys []
  (component/system-map
    ; We have this :meta just so we can debug systems easier
    ; DO NOT depend on it with actual functionality
    :meta "test system"
    :elastic (new-elasticsearch-db
               [["localhost" 9300] ["localhost" 9301]]
               {"cluster.name" "elasticsearch_pair"})))
