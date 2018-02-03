
package com.jexia.app;

import com.google.gson.Gson;
import com.jexia.app.model.CharacterDTO;
import com.jexia.app.model.CharacterSearchDTO;
import com.jexia.app.model.CharacterSpeciesDTO;
import com.jexia.app.model.SingleCharacterRequestDTO;
import com.jexia.app.util.Constants;
import com.jexia.app.util.RestClientUtil;
import org.apache.commons.lang3.StringUtils;

import java.net.URLEncoder;

/**
 * Jexia Code Challenge | Back-end Start Trek Test
 * This is the main file to run the Jexia Klingon App
 *
 * @author Amila Iddamalgoda
 * @version 1.0
 * @since 2018-02-03
 */
public class Application {

    public static void main(String[] args) {

        System.out.println("\n" + Constants.App.STAR_LINES);
        System.out.println(Constants.App.APP_NAME);
        System.out.println(Constants.App.STAR_LINES + "\n");

        if (args.length > 0) {

            System.out.println("Processing... Please Wait! :) \n");
            String request = args[0];

            long startTime = System.currentTimeMillis();

            // For a given query, there can be multiple response results. Hence showing only the first satisfied result (Valid Name and Valid Species Name).
            boolean tempChecker = false;

            String data = "";
            try {
            /*data = URLEncoder.encode("title", "UTF-8")
                    + "=" + URLEncoder.encode("horse", "UTF-8");*/

                data += "&" + URLEncoder.encode("name", "UTF-8") + "="
                        + URLEncoder.encode(request, "UTF-8");
            } catch (Exception e) {
                System.out.println("Error when creating request body data");
            }

            String characterURL = Constants.Stapi.STAPI_HOST + Constants.Stapi.ROUTE_CHARACTER_SEARCH;

            String characterListResponse = RestClientUtil.callSTAPIWebService(characterURL, Constants.HttpMethods.HTTP_POST, data);

            Gson g = new Gson();
            CharacterSearchDTO resObj = g.fromJson(characterListResponse, CharacterSearchDTO.class);


            if (resObj != null && resObj.getCharacters() != null && resObj.getCharacters().size() > 0) {

                for (CharacterDTO characterDTO :
                        resObj.getCharacters()) {

                    // If tempChecker true, that means already found a satisfied result for the given query. Hence not checking further searches.
                    if (!tempChecker) {

                        if (characterDTO.getUid() != null && !StringUtils.isEmpty(characterDTO.getUid())) {

                            String singleCharacterUrl = Constants.Stapi.STAPI_HOST + Constants.Stapi.ROUTE_SINGLE_CHARACTER + "?uid=" + characterDTO.getUid();
                            String characterSpeciesResponse = RestClientUtil.callSTAPIWebService(singleCharacterUrl, Constants.HttpMethods.HTTP_GET, null);
                            SingleCharacterRequestDTO singleCharacterRequestDTO = g.fromJson(characterSpeciesResponse, SingleCharacterRequestDTO.class);

                            if (singleCharacterRequestDTO.getCharacter().getCharacterSpecies() != null && singleCharacterRequestDTO.getCharacter().getCharacterSpecies().size() > 0) {

                                for (CharacterSpeciesDTO characterSpeciesDTO :
                                        singleCharacterRequestDTO.getCharacter().getCharacterSpecies()) {
                                    if (characterSpeciesDTO.getName() != null) {
                                        long estimatedTime = System.currentTimeMillis();
                                        System.out.println("Yeah! Result found in " + String.valueOf((estimatedTime - startTime) / 1000) + " seconds. :) \n");

                                        System.out.println("Name : " + characterDTO.getName());
                                        System.out.println("Species : " + characterSpeciesDTO.getName());
                                        tempChecker = true;
                                        break;
                                    }

                                }

                            }
                        }
                    }


                }
            } else {
                // Couldn't find any results for the given query, from the first search even.
                System.out.println(Constants.ErrorMessages.NO_RESULTS_FOUND);
                // Therefore, unable to perform Species check, hence as per logic making the temp value true.
                tempChecker = true;
            }

            // From the first search we found some results. Unfortunately when executing species check call, there's wasn't any species result found.
            if (!tempChecker) {
                System.out.println(Constants.ErrorMessages.NO_SPECIES_FOUND + request);
            }
        } else {
            System.out.println(Constants.ErrorMessages.NO_INPUT_DATA);
        }


    }
}
