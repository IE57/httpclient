
import com.httpclient.*;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.net.SocketException;
import java.net.URISyntaxException;

public class HttpClientTest {

    @Test
    public void test1() {
        Long s = System.currentTimeMillis();
        runDefaultHTTPClient();
        Long e = System.currentTimeMillis();
        System.out.println(e-s);
    }

    public void runDefaultHTTPClient() {
        JSONObject body = new JSONObject();
        HTTPClient httpClient = new DefaultHTTPClient();
        HTTPRequest req = new HTTPRequest(HTTPMethod.GET, "http://srh.bankofchina.com/search/whpj/search.jsp")
                .addHeader("Conetent-Type", "application/json")
                .addQueryParameter("erectDate", "2018-06-02")
                .addQueryParameter("nothing", "2018-06-02")
                .addQueryParameter("pjname", 1314)
                .setConnectionTimeout(60 * 1000)
                .setRequestTimeout(60 * 1000)
                .setBody(body.toString());
        try {
            HTTPResponse response = httpClient.fetch(req);
            String str = response.body.toString();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runPoolingHTTPClient() {
        HTTPClient httpClient = new PoolingHTTPClient();
        HTTPRequest req = new HTTPRequest(HTTPMethod.GET, "http://srh.bankofchina.com/search/whpj/search.jsp")
                .addHeader("Conetent-Type", "application/json")
                .addQueryParameter("erectDate", "2018-06-02")
                .addQueryParameter("nothing", "2018-06-02")
                .addQueryParameter("pjname", 1314)
                .setConnectionTimeout(60 * 1000)
                .setRequestTimeout(60 * 1000)
                .setBody("");
        try {
            HTTPResponse response = httpClient.fetch(req);
            String str = response.body.toString();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runProxyHTTPClient() {
        //设置代理，能被fidder监听
        HTTPClient httpClient = new ProxyHTTPClient("127.0.0.1", 8888);
        HTTPRequest req = new HTTPRequest(HTTPMethod.GET, "http://srh.bankofchina.com/search/whpj/search.jsp")
                .addHeader("Conetent-Type", "application/json")
                .addQueryParameter("erectDate", "2018-06-25")
                .addQueryParameter("nothing", "2018-06-25")
                .addQueryParameter("pjname", 1314)
                .setConnectionTimeout(60 * 1000)
                .setRequestTimeout(60 * 1000)
                .setBody("");
        try {
            HTTPResponse response = httpClient.fetch(req);
            String str = response.body.toString();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runProxyHTTPClientIpLocation() {
        //设置代理，能被fidder监听
        HTTPClient httpClient = new ProxyHTTPClient("127.0.0.1", 8888);
        HTTPRequest req = new HTTPRequest(HTTPMethod.GET, "http://srh.bankofchina.com/search/whpj/search.jsp")
                .addHeader("Conetent-Type", "text/html")
                .addQueryParameter("action", "2")
                .addQueryParameter("ip", "116.25.248.118")
                .setConnectionTimeout(60 * 1000)
                .setRequestTimeout(60 * 1000)
                .setBody("");
        try {
            HTTPResponse response = httpClient.fetch(req);
            String str = response.body.toString();
            System.out.println(str);
        } catch (SocketException e) {
            System.out.println("0000000000000000");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
