package org.vaadin.example;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.vaadin.example.components.*;
import org.vaadin.example.service.EventService;

@Route("operatore-view")
@Component
public class OperatoreView extends VerticalLayout {

    private Navbar navbar;
    private final NavigationStates leftStates;
    private final RightColumnView rightColumnView;
    private final HorizontalLayout mainLayout;
    private final RoundButtonComponent roundButtonComponent;

    public OperatoreView(EventService eventService, Navbar navbar) {
        this.navbar = navbar;
        this.leftStates = new NavigationStates();
        this.rightColumnView = new RightColumnView();
        this.mainLayout = new HorizontalLayout();
        this.roundButtonComponent = new RoundButtonComponent();

        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.START);
        setJustifyContentMode(JustifyContentMode.START);

        // Imposta la colonna laterale sinistra (inizialmente nascosta)
        leftStates.setVisible(false);
        leftStates.setWidth("250px");

        rightColumnView.setVisible(false);
        rightColumnView.setWidth("250px");

        roundButtonComponent.setVisible(false);
        roundButtonComponent.setWidth("250px");

        // Configura il layout principale
        mainLayout.setWidthFull();
        mainLayout.setHeightFull(); // Assicura che occupi tutta l'altezza
        mainLayout.setSpacing(false);
        mainLayout.setPadding(false);
        mainLayout.setAlignItems(Alignment.CENTER); // Allinea il contenuto verticalmente al centro
        mainLayout.setJustifyContentMode(JustifyContentMode.BETWEEN); // Spazio tra le colonne

        // Aggiungi la colonna sinistra
        mainLayout.add(leftStates);

        // Aggiungi il bottone grigio
        mainLayout.add(roundButtonComponent);

        // Aggiungi la colonna destra
        mainLayout.add(rightColumnView);

        // Aggiungi la navbar sopra
        add(navbar, mainLayout);
    }

    @EventListener
    public void handleUserTypeSelection(RuoloSelectionEvent event) {
        // Seleziona se la colonna sinistra deve essere visibile o meno
        boolean isOperatore = "Operatore".equals(event.getSelectedValue());
        leftStates.setVisible(isOperatore);
        rightColumnView.setVisible(isOperatore);
        roundButtonComponent.setVisible(isOperatore);
    }
}
