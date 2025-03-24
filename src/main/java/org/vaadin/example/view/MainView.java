package org.vaadin.example.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.vaadin.example.Store;
import org.vaadin.example.events.AnnoSelectionEvent;
import org.vaadin.example.events.RuoloSelectionEvent;
import org.vaadin.example.model.RuoloDTO;
import org.vaadin.example.service.EventService;

import java.util.List;

@Route(value = "",layout = MainLayout.class)
@Component
@UIScope
public class MainView extends VerticalLayout {
    private final EventService eventService;
    List<RuoloDTO> listaRuoli;
    Store store;
    @Autowired
    public MainView(EventService eventService) {
        Store store = VaadinSession.getCurrent().getAttribute(Store.class);
        this.eventService=eventService;
        this.store=store;
        this.listaRuoli=store.utente.getRoles();


//todo trovare il modo per selezionare all'inizio la dialog e poi caricare la navbar con i dati preselezionati


        setSizeFull();

    }

}
