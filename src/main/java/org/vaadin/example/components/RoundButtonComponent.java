package org.vaadin.example.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class RoundButtonComponent extends BaseCardHorizontal {


    public RoundButtonComponent() {
        VerticalLayout layout = new VerticalLayout();
        layout.setDefaultHorizontalComponentAlignment(Alignment.START);

        // Crea un bottone grande, tondo e grigio
        setHeightFull();
        setWidth("70vw");
// Label sopra e sotto il bottone
        Label labelAbove = new Label("CORSI DA ATTIVARE");
        Label labelBelow = new Label("PLANNING ATTIVITA' DEL SETTORE");

// Bottone circolare
        Button roundButton = new Button();
        roundButton.getStyle()
                .set("width", "150px")
                .set("height", "150px")
                .set("border-radius", "50%")
                .set("background-color", "#808080") // colore grigio
                .set("color", "white")
                .set("font-size", "20px")
                .set("border", "none")
                .set("cursor", "pointer");

// Aggiunta degli elementi nel layout
        layout.add(labelAbove, roundButton, labelBelow);

        // Aggiungi il listener di click al bottone
        roundButton.addClickListener(e -> {
            // Naviga alla vista "second-view"
            getUI().ifPresent(ui -> ui.navigate("dettaglio-view"));
            // Opzionale: mostra una notifica per il click
            Notification.show("Hai cliccato il bottone e sei stato reindirizzato alla seconda vista!");
        });

        add(layout);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
}
