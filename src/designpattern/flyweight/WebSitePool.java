package designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class WebSitePool {
    Map<String, WebSite> map = new HashMap<>();

    public WebSite getWebSite(String type) {
        WebSite webSite = map.get(type);
        if(webSite == null) {
            webSite = new ConcreteWebSite(type);
            map.put(type, webSite);
        }
        return webSite;
    }

    public int size() {
        return map.size();
    }
}
