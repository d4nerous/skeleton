package org.vaadin.example.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.vaadin.example.components.*;
import org.vaadin.example.events.AnnoSelectionEvent;
import org.vaadin.example.events.RuoloSelectionEvent;

@Route(value = "",layout = MainLayout.class)
@Component
@UIScope
public class MainView extends VerticalLayout {

    @Autowired
    public MainView() {

        // in questa pagina dobbiamo gestire la navigazione
        // e la visualizzazione delle diverse pagine

        setSizeFull();

        // Aggiungi la navbar sopra
    }

    @EventListener
    public void handleRuoloSelection(RuoloSelectionEvent event) {
        // Seleziona se la colonna sinistra deve essere visibile o meno

        if("Operatore".equalsIgnoreCase(event.getSelectedValue().getName())){
            UI.getCurrent().navigate("operatore-view");
        }else if("Altro".equalsIgnoreCase(event.getSelectedValue().getName())){
            UI.getCurrent().navigate("altro-view");
        }else{
            UI.getCurrent().navigate("");
        }



    }
    @EventListener
    public void handleAnnoSelection(AnnoSelectionEvent event) {
        String anno = event.getSelectedValue();

    }
}
