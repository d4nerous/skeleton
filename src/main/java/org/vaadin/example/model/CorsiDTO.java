package org.vaadin.example.model;

public class CorsiDTO {
    private Long id;
    private Long idComplesso;
    private String codiceSCU;
    private Double costo;

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

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
}
