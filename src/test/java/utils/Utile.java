package utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class Utile {

    String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiJiNmNhZGQwNS1lMzQxLTNmMTctYjU1Zi00OTM0MTI4MWQ4MmEiLCJhY2NvdW50SWQiOiI3MTIwMjA6OWI0ZDc1NTAtNmJmYS00MmJlLWJiYWItMGQzZTRkMDFhMDNkIiwiaXNYZWEiOmZhbHNlLCJpYXQiOjE3MTY0NTUyODAsImV4cCI6MTcxNjU0MTY4MCwiYXVkIjoiOEQxQTVEODI0QjlFNDc3MTlGRDA5NzVEMTRDQzk1OUIiLCJpc3MiOiJjb20ueHBhbmRpdC5wbHVnaW5zLnhyYXkiLCJzdWIiOiI4RDFBNUQ4MjRCOUU0NzcxOUZEMDk3NUQxNENDOTU5QiJ9.AG9eiX6AFb7J0E4TthBTExJrUGU9bSx8hDGWEnJKtNU";
    public void ImportToXray() throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, InterruptedException {
        HttpURLConnection conn;
        URL url;
        String result;
        String  URL ="https://xray.cloud.getxray.app/api/v1/import/execution/cucumber";
        //Call the openConnection method on the URL to create a connection object
        url = new URL(URL);
        conn = (HttpURLConnection) url.openConnection();

        //Various settings of HttpURLConnection
        //Set HTTP method to POST
        conn.setRequestMethod("POST");
        //Allow body submission of request
        conn.setDoInput(true);
        //Allow body reception of response
        conn.setDoOutput(true);
        //Specify Json format
        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        conn.setRequestProperty("Authorization", "Bearer " + token);

        // 2.Establish a connection
        conn.connect();
        // 3.Write to request and body
        //Get OutputStream from HttpURLConnection and write json string
        Thread.sleep(10000);
        PrintStream ps = new PrintStream(conn.getOutputStream());

        Path filePath = Path.of(System.getProperty("user.dir")+"\\target\\cucumber-report\\cucumber.json");
        String content = Files.readString(filePath);
        System.out.println("mon fichier  = "+content);

        ps.print(content);
        ps.close();
        // 4.Receive a response
        //HttpStatusCode 200 is returned at the end of normal operation
        if (conn.getResponseCode() != 200) {
            //Error handling
        }
        //Get InputStream from HttpURLConnection and read
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        result = sb.toString();
        // 5.Disconnect
        conn.disconnect();
        //Return the result to the caller
        System.out.println(result);
    }

}
