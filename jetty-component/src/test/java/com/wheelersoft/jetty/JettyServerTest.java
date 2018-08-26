package com.wheelersoft.jetty;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.junit.Before;
import org.junit.Test;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class JettyServerTest {
    private JettyServer jettyServer;

    @Before
    public void setUp() throws Exception {
        jettyServer = new JettyServer();
        jettyServer.start();
    }

    @Test
    public void testGetBlockingServlet() throws IOException {
        String url = "http://localhost:8090/status";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);

        //then
        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(200);
    }
}
