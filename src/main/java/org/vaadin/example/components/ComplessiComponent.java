package org.vaadin.example.components;

import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;
import org.vaadin.example.Store;
import org.vaadin.example.events.TabComplessiChangeEvent;
import org.vaadin.example.model.AbilitazioniComplessiDTO;
import org.vaadin.example.model.UtenteDTO;

import java.util.ArrayList;

@Component
@UIScope
public class ComplessiComponent extends HorizontalLayout {
    private ArrayList<AbilitazioniComplessiDTO> complessi = null;
    private UtenteDTO utente=null;
    private final Tabs tabs = new Tabs();


    public ComplessiComponent() {
        Store store = VaadinSession.getCurrent().getAttribute(Store.class);
        this.utente= store.utente;
        this.complessi = utente.getComplessi();
        setWidthFull();

        loadTabs();
        tabs.setWidthFull();
        add(tabs);
        addChangeListener();
        fireChangeTab((Tab) tabs.getComponentAt(0));

    }
    private void loadTabs() {
        for (AbilitazioniComplessiDTO complesso : complessi) {
            Tab tab = new Tab(complesso.getCodice());
            tabs.add(tab);
        }
    }

    private void addChangeListener() {

        tabs.addSelectedChangeListener(tab -> {
            fireChangeTab(tab.getSelectedTab());
        });

    }

    private void fireChangeTab(Tab tab) {
        AbilitazioniComplessiDTO a = complessi.stream()
                .filter(compl ->
                        tab.getLabel().equals(compl.getCodice())
                ).findFirst().get();

        ComponentUtil.fireEvent(UI.getCurrent(),new TabComplessiChangeEvent(UI.getCurrent(),a));
    }
}

