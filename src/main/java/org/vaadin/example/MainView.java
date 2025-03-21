package org.vaadin.example;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.vaadin.example.components.Navbar;
import org.vaadin.example.components.NavigationStates;
import org.vaadin.example.components.RuoloSelectionEvent;
import org.vaadin.example.service.EventService;

@Route("")
@Component
public class MainView extends VerticalLayout {

    private final Navbar navbar;
    private final NavigationStates leftStates;
    private final HorizontalLayout mainContent;

    public MainView(EventService eventService) {
        this.navbar = new Navbar(eventService);
        this.leftStates = new NavigationStates();
        this.mainContent = new HorizontalLayout();

        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.START);
        setJustifyContentMode(JustifyContentMode.START);

        // Imposto la colonna laterale sinistra (inizialmente nascosta)
        leftStates.setVisible(false);
        leftStates.setWidth("250px");

        // Layout principale con navbar e contenuto
        mainContent.setWidthFull();
        mainContent.add(leftStates); // Aggiungo il menu laterale, ma lo lascio nascosto

        add(navbar, mainContent);
    }

    @EventListener
    public void handleUserTypeSelection(RuoloSelectionEvent event) {
        // Se la ComboBox è su "Operatore", mostra il menu, altrimenti lo nasconde
        leftStates.setVisible("Operatore".equals(event.getSelectedValue()));
    }
}
