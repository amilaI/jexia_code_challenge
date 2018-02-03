package com.jexia.app;

import com.google.gson.Gson;
import com.jexia.app.facade.KlingonProcessor;
import com.jexia.app.facade.impl.KlingonProcessorImpl;
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
 * This is the main file to run the Jexia Klingon App
 *
 * @author Amila Iddamalgoda
 * @version 1.0
 * @since 2018-02-03
 */
public class Application {

    /**
     * Main method of the program
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(Constants.App.STAR_LINES);
        System.out.println(Constants.App.APP_NAME);
        System.out.println(Constants.App.STAR_LINES);

        if (args.length > 0) {

            System.out.println(Constants.App.PROCESSING_TEXT);

            // Create an object of KlingonProcessor interface
            KlingonProcessor klingonProcessor = new KlingonProcessorImpl();

            // Get hexadecimal codes for the given klingon name
            klingonProcessor.printKlingonUnicode(args);

            // Print Corresponding species value for the given klingon name
            klingonProcessor.printSpeciesForGivenCharacter(args);

        } else {
            System.out.println(Constants.Messages.NO_INPUT_DATA);
        }

    }


}
