package com.jexia.app.model;

import java.io.Serializable;
import java.util.List;

/**
 * Jexia Code Challenge | Back-end Start Trek Test
 * This is the model class CharacterDTO
 *
 * @author Amila Iddamalgoda
 * @version 1.0
 * @since 2018-02-03
 */
public class CharacterDTO implements Serializable {

    private String uid;
    private String name;
    private List<CharacterSpeciesDTO> characterSpecies;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CharacterSpeciesDTO> getCharacterSpecies() {
        return characterSpecies;
    }

    public void setCharacterSpecies(List<CharacterSpeciesDTO> characterSpecies) {
        this.characterSpecies = characterSpecies;
    }
}
