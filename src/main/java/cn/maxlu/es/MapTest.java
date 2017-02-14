package cn.maxlu.es;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by max.lu on 2016/2/25.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Talk> map = new HashMap<String, Talk>();
        Talk talk = new Talk();
        talk.setId(1);
        map.put("first", talk);
        talk.setName("max");
        System.out.println(map.get("first").getName());

        Map<String, String> map1 = new HashMap<String, String>();
        String a = null;
        map1.put("first", a);
        a = "max";
        System.out.println(map1.get("first"));
    }
}
