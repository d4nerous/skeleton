package org.vaadin.example.model;

import java.util.Objects;

public class RuoloDTO {

    private Integer id;
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RuoloDTO ruoloDTO = (RuoloDTO) o;
        return Objects.equals(id, ruoloDTO.id) && Objects.equals(name, ruoloDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
