package general_classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class URLBuilderTests {
    private static final String RESOURCE_URL = "https://test.com/get";

    @Test
    public void testToString() {
        URLBuilder urlBuilder = new URLBuilder(RESOURCE_URL);
        Assertions.assertEquals(RESOURCE_URL + "?", urlBuilder.toString());
    }

    @Test
    public void testBuild() throws MalformedURLException {
        URLBuilder urlBuilder = new URLBuilder(RESOURCE_URL);
        Assertions.assertEquals(new URL(RESOURCE_URL + "?"), urlBuilder.build());
    }

    @Test
    public void testWithParam() throws UnsupportedEncodingException, MalformedURLException {
        String key = "key";
        String value = "value";
        URLBuilder urlBuilder = new URLBuilder(RESOURCE_URL);
        urlBuilder.withParam(key, new ArrayList<>() {{add(value);}});

        String expected = RESOURCE_URL + "?" + key + "=" + value;
        Assertions.assertEquals(new URL(expected), urlBuilder.build());
    }

    @Test
    public void testWithParams() throws UnsupportedEncodingException, MalformedURLException {
        String param = "key";
        List<String> values = new ArrayList<>();
        values.add("val1");
        values.add("val2");

        URLBuilder urlBuilder = new URLBuilder(RESOURCE_URL);
        urlBuilder.withParam(param, values);

        String expected = RESOURCE_URL + "?" + param + "=" + values.get(0) + "&" + param + "=" + values.get(1);
        Assertions.assertEquals(new URL(expected), urlBuilder.build());
    }
}