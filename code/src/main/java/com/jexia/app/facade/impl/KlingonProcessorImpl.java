package com.jexia.app.facade.impl;

import com.google.gson.Gson;
import com.jexia.app.facade.KlingonProcessor;
import com.jexia.app.model.CharacterDTO;
import com.jexia.app.model.CharacterSearchDTO;
import com.jexia.app.model.CharacterSpeciesDTO;
import com.jexia.app.model.SingleCharacterRequestDTO;
import com.jexia.app.util.Constants;
import com.jexia.app.util.RestClientUtil;
import org.apache.commons.lang3.StringUtils;

import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;

/**
 * Jexia Code Challenge | Back-end Start Trek Test
 * This is the implementation class of the KlingonProcessor interface
 *
 * @author Amila Iddamalgoda
 * @version 1.0
 * @since 2018-02-03
 */
public class KlingonProcessorImpl implements KlingonProcessor {

    /**
     * This method will loop through the input words and call the printKlingonValue()
     *
     * @param args
     */
    public void printKlingonUnicode(String[] args) {

        for (int i = 0; i < args.length; i++) {

            // Print hexadecimal value for the given word
            printKlingonValue(args[i]);

            if (args.length > 1 && i < args.length - 1) {
                System.out.print(Constants.KlingonAlphabet.SPACE + Constants.KlingonAlphabet.SPACE_FORMAT + Constants.KlingonAlphabet.SPACE);
            }

        }

    }

    /***
     * Print hexadecimal value corresponding to the given Klingon word.
     * @param word
     */
    private void printKlingonValue(String word) {

        // Making the letters of the given word to lowercase (hence for instance, D and d are same)
        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {

            // Get character of the i position of the word
            Character character = word.charAt(i);

            for (int j = 0; j < Constants.KlingonAlphabet.ALPHABET_pIqaD.length; j++) {

                if (Constants.KlingonAlphabet.ALPHABET_pIqaD[j].equalsIgnoreCase(character.toString())) {

                    int val = j / Constants.KlingonAlphabet.HEXA_VALUE;
                    int remainder = j % Constants.KlingonAlphabet.HEXA_VALUE;

                    if (val == 0) {
                        if (remainder <= 9) {
                            System.out.print(Constants.KlingonAlphabet.FORMAT_1 + remainder);
                        } else if (remainder == 10) {
                            System.out.print(Constants.KlingonAlphabet.FORMAT_1 + "A");
                        } else if (remainder == 11) {
                            System.out.print(Constants.KlingonAlphabet.FORMAT_1 + "B");
                        } else if (remainder == 12) {
                            System.out.print(Constants.KlingonAlphabet.FORMAT_1 + "C");
                        } else if (remainder == 13) {
                            System.out.print(Constants.KlingonAlphabet.FORMAT_1 + "D");
                        } else if (remainder == 14) {
                            System.out.print(Constants.KlingonAlphabet.FORMAT_1 + "E");
                        } else if (remainder == 15) {
                            System.out.print(Constants.KlingonAlphabet.FORMAT_1 + "F");
                        }
                    } else if (val == 1) {
                        System.out.print(Constants.KlingonAlphabet.FORMAT_2 + remainder);
                    }

                    System.out.print(Constants.KlingonAlphabet.SPACE);

                }
            }

        }

    }

    /**
     * This method returns the species corresponding to the given character input
     *
     * @param requestList This is the input word list
     */
    public void printSpeciesForGivenCharacter(String[] requestList) {

        // Stores start time
        long startTime = System.currentTimeMillis();

        // For a given query, there can be multiple response results. Hence showing only the first satisfied result (Valid Name and Valid Species Name).
        boolean tempChecker = false;

        // Prepare request body values
        String data = getFormattedString(requestList);

        // Used for print output purpose
        String request = data;

        try {

            data = URLEncoder.encode("name", Constants.Headers.UTF_8) + "="
                    + URLEncoder.encode(data, Constants.Headers.UTF_8);

        } catch (Exception e) {

            System.out.println("Error when creating request body data");

        }

        // Using this URL we can get the CharacterBaseResponse for the given character
        String characterURL = Constants.Stapi.STAPI_HOST + Constants.Stapi.ROUTE_CHARACTER_SEARCH;

        // The character base response string. RestClientUtil is used to do the web service communication.
        String characterListResponse = RestClientUtil.callSTAPIWebService(characterURL, Constants.HttpMethods.HTTP_POST, data);

        // Create a new Gson object
        Gson g = new Gson();

        // Convert the JSON string to CharacterSearchDTO object
        CharacterSearchDTO resObj = g.fromJson(characterListResponse, CharacterSearchDTO.class);

        if (resObj != null && resObj.getCharacters() != null && resObj.getCharacters().size() > 0) {

            for (CharacterDTO characterDTO :
                    resObj.getCharacters()) {

                // If tempChecker true, that means already found a satisfied result for the given query. Hence not checking further searches.
                if (!tempChecker) {

                    if (characterDTO.getUid() != null && !StringUtils.isEmpty(characterDTO.getUid())) {

                        // Using this URL, we can get the full character response for the given character. RestClientUtil is used to do the web service communication.
                        String singleCharacterUrl = Constants.Stapi.STAPI_HOST + Constants.Stapi.ROUTE_SINGLE_CHARACTER + characterDTO.getUid();

                        // The full character response string
                        String characterSpeciesResponse = RestClientUtil.callSTAPIWebService(singleCharacterUrl, Constants.HttpMethods.HTTP_GET, null);

                        // Convert the JSON string to SingleCharacterRequestDTO object
                        SingleCharacterRequestDTO singleCharacterRequestDTO = g.fromJson(characterSpeciesResponse, SingleCharacterRequestDTO.class);

                        if (singleCharacterRequestDTO.getCharacter().getCharacterSpecies() != null && singleCharacterRequestDTO.getCharacter().getCharacterSpecies().size() > 0) {

                            // This list will contain all the species values corresponding to the given name. (no duplicates needed hence using Set)
                            Set<String> speciesList = new HashSet<String>();

                            for (CharacterSpeciesDTO characterSpeciesDTO :
                                    singleCharacterRequestDTO.getCharacter().getCharacterSpecies()) {

                                if (characterSpeciesDTO.getName() != null) {

                                    // Add species name to the hashset
                                    speciesList.add(characterSpeciesDTO.getName());

                                }

                            }

                            // Already found a satisfied result set, hence making the tempChecker true.
                            tempChecker = true;

                            // Stores program end time
                            long estimatedTime = System.currentTimeMillis();

                            // Output results
                            System.out.println(Constants.Messages.RESULT_FOUND + String.valueOf((estimatedTime - startTime) / 1000) + Constants.Messages.SECONDS_TEXT);
                            System.out.println(Constants.Messages.NAME + characterDTO.getName());
                            System.out.println(Constants.Messages.SPECIES + speciesList.toString());

                        }
                    }
                }


            }
        } else {

            // Couldn't find any results for the given query, from the first search even.
            System.out.println(Constants.Messages.NO_RESULTS_FOUND + request);

            // Therefore, unable to perform Species check, hence as per logic making the temp value true.
            tempChecker = true;

        }

        // From the first search we found some results. Unfortunately when executing species check call, there's wasn't any species result found.
        if (!tempChecker) {
            System.out.println(Constants.Messages.NO_SPECIES_FOUND + request);
        }
    }


    /**
     * Util for format string array
     *
     * @param requestList - input word list
     * @return data - String with appended word list
     */
    private String getFormattedString(String[] requestList) {

        StringBuilder data = new StringBuilder();

        for (String input :
                requestList) {
            data.append(input).append(" ");
        }

        return data.toString();
    }

}
