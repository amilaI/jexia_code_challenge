package com.jexia.app.model;

import java.io.Serializable;
import java.util.List;

/**
 * Jexia Code Challenge | Back-end Start Trek Test
 * This is the model class CharacterSearchDTO
 *
 * @author Amila Iddamalgoda
 * @version 1.0
 * @since 2018-02-03
 */
public class CharacterSearchDTO implements Serializable {

    List<CharacterDTO> characters;

    public List<CharacterDTO> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterDTO> characters) {
        this.characters = characters;
    }
}
