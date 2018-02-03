package com.jexia.app.model;

import java.io.Serializable;

/**
 * Jexia Code Challenge | Back-end Start Trek Test
 * This is the model class SingleCharacterRequestDTO
 *
 * @author Amila Iddamalgoda
 * @version 1.0
 * @since 2018-02-03
 */
public class SingleCharacterRequestDTO implements Serializable {

    private CharacterDTO character;

    public CharacterDTO getCharacter() {
        return character;
    }

    public void setCharacter(CharacterDTO character) {
        this.character = character;
    }

}
