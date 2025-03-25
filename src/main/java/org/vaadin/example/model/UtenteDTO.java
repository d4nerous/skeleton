package org.vaadin.example.model;

import java.util.ArrayList;
import java.util.Objects;


public class UtenteDTO {


    private Integer id=null;
    private String username=null;
    private String name =null;
    private String surname     =null;
    private String email=null;
    private ArrayList<RuoloDTO> roles   =new ArrayList<RuoloDTO>();
    private ArrayList<AnnoFormtivoDTO> anni = new ArrayList<>();
    private ArrayList<AbilitazioniComplessiDTO> complessi = new ArrayList<>();

    public ArrayList<AbilitazioniComplessiDTO> getComplessi() {
        return complessi;
    }

    public void setComplessi(ArrayList<AbilitazioniComplessiDTO> complessi) {
        this.complessi = complessi;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(ArrayList<RuoloDTO> roles) {
        this.roles = roles;
    }
    public void setAnni(ArrayList<AnnoFormtivoDTO> anni) {
        this.anni = anni;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<RuoloDTO> getRoles() {
        return roles;
    }
    public ArrayList<AnnoFormtivoDTO> getAnni() {
        return anni;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UtenteDTO utenteDTO = (UtenteDTO) o;
        return Objects.equals(id, utenteDTO.id) && Objects.equals(username, utenteDTO.username) && Objects.equals(name, utenteDTO.name) && Objects.equals(surname, utenteDTO.surname) && Objects.equals(email, utenteDTO.email) && Objects.equals(roles, utenteDTO.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, surname, email, roles);
    }
}
