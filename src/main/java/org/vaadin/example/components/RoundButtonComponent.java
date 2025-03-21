package org.vaadin.example.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class RoundButtonComponent extends VerticalLayout {

    public RoundButtonComponent() {
        // Crea un bottone grande, tondo e grigio
        Button roundButton = new Button();
        roundButton.setText("Clicca qui");
        roundButton.getStyle()
                .set("width", "150px")
                .set("height", "150px")
                .set("border-radius", "50%")
                .set("background-color", "#808080") // colore grigio
                .set("color", "white")
                .set("font-size", "20px")
                .set("border", "none")
                .set("cursor", "pointer");

        // Aggiungi il listener di click al bottone
        roundButton.addClickListener(e -> {
            // Naviga alla vista "second-view"
            getUI().ifPresent(ui -> ui.navigate("dettaglio-view"));
            // Opzionale: mostra una notifica per il click
            Notification.show("Hai cliccato il bottone e sei stato reindirizzato alla seconda vista!");
        });

        add(roundButton);
    }
}
