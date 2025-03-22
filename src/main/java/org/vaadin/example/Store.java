package org.vaadin.example;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.springframework.stereotype.Component;
import org.vaadin.example.model.RuoloDTO;
import org.vaadin.example.model.UtenteDTO;

@Component
@VaadinSessionScope
public class Store {

    public UtenteDTO utente=null;
    public RuoloDTO ruoloSelected=null;

}
