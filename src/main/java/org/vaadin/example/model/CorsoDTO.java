package org.vaadin.example.model;

import java.time.LocalDateTime;

public class CorsoDTO {
    
               private Long id=null;
               private Long idComplesso =null;
               private String codiceSCU =null;
               private String aula =null;
               private LocalDateTime dataInizio =null;
               private LocalDateTime dataFine =null;
               private String docente =null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdComplesso() {
        return idComplesso;
    }

    public void setIdComplesso(Long idComplesso) {
        this.idComplesso = idComplesso;
    }

    public String getCodiceSCU() {
        return codiceSCU;
    }

    public void setCodiceSCU(String codiceSCU) {
        this.codiceSCU = codiceSCU;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aulap) {
        this.aula = aulap;
    }

    public LocalDateTime getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDateTime dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDateTime getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDateTime dataFine) {
        this.dataFine = dataFine;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }
}
