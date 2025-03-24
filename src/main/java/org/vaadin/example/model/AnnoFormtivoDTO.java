package org.vaadin.example.model;

import java.util.ArrayList;

public class AnnoFormtivoDTO {
    private Integer anno;
    private String descrizione;
    private ArrayList<AbilitazioniComplessiDTO> complessi;

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
