package org.vaadin.example.model;

public class AbilitazioniComplessiDTO {
    private Long id;
    private String nome;
    private Integer codice;
    private Double importoStanziato;
    private Double costiSostenuti;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public Double getImportoStanziato() {
        return importoStanziato;
    }

    public void setImportoStanziato(Double importoStanziato) {
        this.importoStanziato = importoStanziato;
    }

    public Double getCostiSostenuti() {
        return costiSostenuti;
    }

    public void setCostiSostenuti(Double costiSostenuti) {
        this.costiSostenuti = costiSostenuti;
    }
}
