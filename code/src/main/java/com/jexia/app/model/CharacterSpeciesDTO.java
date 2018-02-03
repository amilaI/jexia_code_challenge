package com.jexia.app.model;

import java.io.Serializable;

/**
 * Jexia Code Challenge | Back-end Start Trek Test
 * This is the model class CharacterSpeciesDTO
 *
 * @author Amila Iddamalgoda
 * @version 1.0
 * @since 2018-02-03
 */
public class CharacterSpeciesDTO implements Serializable {

    private String uid;
    private String name;

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

}
