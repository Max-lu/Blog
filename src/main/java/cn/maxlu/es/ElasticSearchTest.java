package cn.maxlu.es;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by max.lu on 2016/2/24.
 */
public class ElasticSearchTest {

    private static JestClient client;

    static {
        client = getClient();
    }

    public static JestClient getClient() {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig.Builder("http://localhost:9200").multiThreaded(true).build());
        return factory.getObject();
    }

    public static void createIndex() throws IOException {
        boolean indexExists = client.execute(new IndicesExists.Builder("jug").build()).isSucceeded();
        if (indexExists) {
            client.execute(new DeleteIndex.Builder("jug").build());
        }
        client.execute(new CreateIndex.Builder("jug").build());
    }

    public static void query() throws IOException {
        String query = "{\n"
                + "    \"query\":{\n"
                + "        \"filtered\":{\n"
                + "            \"query\":{\n"
                + "                \"query_string\":{\n"
                + "                    \"query\":\"java\"\n"
                + "                }\n"
                + "            }\n"
                + "        }\n"
                + "    }\n"
                + "}";
        Search.Builder searchBuilder = new Search.Builder(query).addIndex("jug").addType("talk");
        SearchResult result = client.execute(searchBuilder.build());
    }

    public static void createIndex2() throws IOException {
        Bulk.Builder bulkIndexBuilder = new Bulk.Builder();
        List<Talk> talks = new ArrayList<Talk>();
        for (int i = 0; i < 10; i++) {
            Talk talk = new Talk();
            talk.setId(i);
            talk.setName("java " + i);
            talks.add(talk);
        }
        for (Talk talk : talks) {
            bulkIndexBuilder.addAction(new Index.Builder(talk).index("jug").type("talk").build());
        }
        client.execute(bulkIndexBuilder.build());
    }

    public static void query2() throws IOException {
        String query = "{\n"
                + "  \"query\": {\n"
                + "    \"match\": {\n"
                + "      \"name\": \"java 1\"\n"
                + "    }\n"
                + "  }\n"
                + "}";
        Search.Builder searchBuilder = new Search.Builder(query).addIndex("jug").addType("talk");
        SearchResult result = client.execute(searchBuilder.build());
        List<SearchResult.Hit<Talk, Void>> hits = result.getHits(Talk.class);
        for (SearchResult.Hit<Talk, Void> hit : hits) {
            Talk talk = hit.source;
            System.out.println(talk.getName());
        }
    }

    public static void main(String[] args) throws IOException {
        createIndex2();
        query2();
        System.out.println("success");
    }

    public static void query3() throws IOException {
        String query = "{\n"
                + "    \"query\" : {\n"
                + "        \"match\" : {\n"
                + "            \"last_name\" : \"Smith\"\n"
                + "        }\n"
                + "    }\n"
                + "}";
        Search.Builder searchBuilder = new Search.Builder(query).addIndex("megacorp").addType("employee");
        SearchResult result = client.execute(searchBuilder.build());
        List<SearchResult.Hit<Employee, Void>> hits = result.getHits(Employee.class);
        for (SearchResult.Hit<Employee, Void> hit : hits) {
            Employee employee = hit.source;
            System.out.println(employee.getFirst_name());
        }
    }

    public static void query4() {
//        IndexQuery query = new IndexQueryBuilder().withIndexName("talks").withId("/tmp").withObject(talk).build();
//        String id = esTemplate.index(query);
//        GetQuery getQuery = new GetQuery();
//        getQuery.setId(id);
//        Talk queriedObject = esTemplate.queryForObject(getQuery, Talk.class);
    }
}
