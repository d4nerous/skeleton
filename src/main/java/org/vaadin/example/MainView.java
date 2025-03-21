package org.vaadin.example;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.vaadin.example.components.Navbar;
import org.vaadin.example.components.NavigationStates;
import org.vaadin.example.components.RuoloSelectionEvent;
import org.vaadin.example.service.EventService;

import javax.servlet.Registration;
import java.util.function.Consumer;


@Route("")
@Component
public class MainView extends VerticalLayout {

    Navbar navbar ;
    NavigationStates leftStates;


    public MainView(EventService eventService) {


        this.navbar = new Navbar(eventService);
        this.leftStates = new NavigationStates();
        setSizeFull();
        setPadding(true);

        // Aggiungo header e contenuto principale
        add(navbar);


    }

    @EventListener
    public void handleUserTypeSelection(RuoloSelectionEvent event) {
        // Se la ComboBox è su "Operatore", mostra il menu, altrimenti lo nasconde
        if (!"Operatore".equals(event.getSelectedValue())) {
            remove(leftStates);
        } else {
            add(leftStates);

        }

    }
}


