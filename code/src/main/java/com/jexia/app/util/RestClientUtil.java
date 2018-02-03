package com.jexia.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Jexia Code Challenge | Back-end Start Trek Test
 * This util class will be used to call web services.
 *
 * @author Amila Iddamalgoda
 * @version 1.0
 * @since 2018-02-03
 */
public class RestClientUtil {
    /**
     * This method will call the given web service URL and output the response as String.
     *
     * @param urlName
     * @param method
     * @param data
     * @return result
     */
    public static String callSTAPIWebService(String urlName, String method, String data) {

        String result = null;
        try {

            // Create HTTP URL Connection
            URL url = new URL(urlName);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod(method);
            httpURLConnection.setRequestProperty(Constants.Headers.CONTENT_TYPE, Constants.Headers.APP_X_WWW_FORM_URLENCODED);

            // Open HTTP URL connection
            httpURLConnection.connect();

            // If data available in the request body, then write them accordingly.
            if (data != null) {
                OutputStreamWriter wr = new OutputStreamWriter(httpURLConnection.getOutputStream());
                wr.write(data);
                wr.flush();
            }

            // Read the response output
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), Constants.Headers.UTF_8), Constants.Headers.INPUT_BUFFER_SIZE);
            result = reader.readLine();

            // If HTTP response is not OK (Code : 200) then output error message.
            if (httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println(Constants.Messages.ERROR_IN_WS_CALL_1 + httpURLConnection.getResponseCode() + Constants.Messages.RESPONSE_1 + httpURLConnection.getContent());

            }

            // Close HTTP URL connection
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            // A MalformedURLException has occurred.
            System.out.println(Constants.Messages.ERROR_IN_WS_CALL_2 + e.getMessage());

        } catch (IOException e) {
            // A IOException has occurred.
            System.out.println(Constants.Messages.ERROR_IN_WS_CALL_2 + e.getMessage());

        }

        // Return JSON string as response.
        return result;
    }

}
