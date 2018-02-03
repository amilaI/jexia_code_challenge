package com.jexia.app.util;

/**
 * Jexia Code Challenge | Back-end Start Trek Test
 * This class contains all the Constants used in this app.
 *
 * @author Amila Iddamalgoda
 * @version 1.0
 * @since 2018-02-03
 */
public final class Constants {

    public interface App {
        String APP_NAME = "Welcome to Jexia Code Challenge | Back-end Start Trek Test";
        String STAR_LINES = "***********************************************************";
    }

    public interface Stapi {
        String STAPI_HOST = "http://stapi.co/api/v1/rest/";
        String ROUTE_CHARACTER_SEARCH = "character/search";
        String ROUTE_SINGLE_CHARACTER = "character";
    }

    public interface HttpMethods {
        String HTTP_POST = "POST";
        String HTTP_GET = "GET";
    }

    public interface Headers {
        String CONTENT_TYPE = "Content-Type";
        String APP_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
        String UTF_8 = "UTF-8";
        int INPUT_BUFFER_SIZE = 8;
    }

    public interface ErrorMessages {
        String ERROR_IN_WS_CALL_1 = "Oh Snap! Failed to retrieve data from STAPI. HTTP response code: ";
        String ERROR_IN_WS_CALL_2 = "Oh Snap! An error occurred when calling the STAPI: Message: ";
        String RESPONSE_1 = ". Response Message: ";
        String NO_RESULTS_FOUND = "No result found for your query!";
        String NO_SPECIES_FOUND = "Sorry! No species found for ";
        String NO_INPUT_DATA = "Please enter a name as input query. Thanks. ";
    }


}
