package org.vaadin.example.components;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;
import org.vaadin.example.Store;
import org.vaadin.example.model.AbilitazioniComplessiDTO;
import org.vaadin.example.model.RuoloDTO;
import org.vaadin.example.model.UtenteDTO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@UIScope
public class ComplessiComponent extends HorizontalLayout {

    private ArrayList<AbilitazioniComplessiDTO> complessi = null;
    private UtenteDTO utente=null;
    private final Tabs tabs = new Tabs();
    private final Div content = new Div();
    private final Map<Tab, Div> tabContentMap = new LinkedHashMap<>();


    public ComplessiComponent() {
        Store store = VaadinSession.getCurrent().getAttribute(Store.class);
        this.utente= store.utente;
        this.complessi = utente.getComplessi();
        setWidthFull();

        loadTabs();
        tabs.setWidthFull();
        add(tabs);


    }
    private void loadTabs() {
        for (AbilitazioniComplessiDTO complesso : complessi) {
            Tab tab = new Tab(complesso.getNome());
//            VerticalLayout label = new VerticalLayout();
//            label.add(new Label("Sostenuti: " + complesso.getCostiSostenuti().toString()));
//            label.add(new Label("Stanziamento: " + complesso.getImportoStanziato().toString()));
//
//            tab.add(label);
            tabs.add(tab);
        }

        // Mostra il contenuto del primo tab di default
        if (!tabContentMap.isEmpty()) {
            content.add(tabContentMap.values().iterator().next());
        }
    }
}

