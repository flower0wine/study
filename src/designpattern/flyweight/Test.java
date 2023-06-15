package designpattern.flyweight;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Test {
    public static void main(String[] args) {
        WebSitePool webSitePool = new WebSitePool();
        webSitePool.getWebSite("新闻").use(new User("李清照"));
        webSitePool.getWebSite("新闻").use(new User("赵明诚"));
        webSitePool.getWebSite("博客").use(new User("王勃"));
        System.out.println(webSitePool.size());
    }
}
