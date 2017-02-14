package cn.maxlu.es;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.elasticsearch.search.SearchHit;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Search {
    public static void main(String[] args) throws UnknownHostException {
        Watch watch = new Watch();
        Client client = getTransportClient();
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("jug").setTypes("talk");
        searchRequestBuilder.setFrom(0).setSize(20);
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.matchPhrasePrefixQuery("name", "java"));
        searchRequestBuilder.setQuery(queryBuilder);
//        searchRequestBuilder.setPostFilter();
        SearchResponse searchResponse = searchRequestBuilder.execute().actionGet();

        System.out.println("----start----");
        long total = searchResponse.getHits().getTotalHits();
        System.out.println("total=" + total);
        for (SearchHit hit : searchResponse.getHits()) {
            System.out.println(hit.getSource().get("name").toString());
        }
        System.out.println("----end----");
        System.out.println("elapsedTime = " + watch.elapsedTime() + " ns");
    }

    private static Client getTransportClient() throws UnknownHostException {
        Settings settings = Settings.settingsBuilder().put("cluster.name", "elasticsearch").build();
        return TransportClient.builder().settings(settings).build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
    }

    private static Client getNodeClient() {
        Node node = NodeBuilder.nodeBuilder().node();
        return node.client();
    }

    private static class Watch {
        private long start;

        public Watch() {
            this.start = System.nanoTime();
        }
        public long elapsedTime() {
            long end = System.nanoTime();
            return end - this.start;
        }
    }
}
