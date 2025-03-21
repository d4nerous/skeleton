package org.vaadin.example.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

@Component
public class NavigationStates extends VerticalLayout {

    public NavigationStates() {
        // Impostazioni layout principale
        setHeightFull();
        setWidth("250px");
        setMaxHeight("600px");
        setPadding(true);
        setAlignItems(Alignment.CENTER); // Centra gli elementi

        // Aggiungi i pulsanti con il testo sopra
        add(createButtonWithLabel("Pulsante 1", "#FF5733", true));  // Rosso - Tondo
        add(createButtonWithLabel("Pulsante 2", "#33FF57", true));  // Verde - Tondo
        add(createButtonWithLabel("Pulsante 3", "#3357FF", true));  // Blu - Tondo
        add(createButtonWithLabel("Pulsante 4", "#F4D03F", false)); // Giallo - Quadrato
        add(createButtonWithLabel("Pulsante 5", "#A569BD", true));  // Viola - Tondo
    }

    // Metodo per creare un pulsante con etichetta sopra
    private VerticalLayout createButtonWithLabel(String labelText, String color, boolean isRound) {
        // Etichetta
        Label label = new Label(labelText);
        label.getStyle()
                .set("font-size", "14px") // Imposta la dimensione del testo
                .set("margin-bottom", "5px") // Spazio tra testo e pulsante
                .set("color", "black"); // Colore del testo

        // Pulsante
        Button button = new Button();
        button.setWidth("50px");
        button.setHeight("50px");
        button.getStyle()
                .set("background-color", color) // Colore sfondo
                .set("border", "none") // Nessun bordo
                .set("cursor", "pointer") // Cursore di tipo pointer per interazione
                .set("display", "flex") // Assicuriamo che il contenuto si adatti bene
                .set("align-items", "center") // Allinea gli elementi all'interno
                .set("justify-content", "center"); // Centra il testo all'interno

        if (isRound) {
            button.getStyle().set("border-radius", "50%"); // Rende il pulsante tondo
        }

        // Aggiungi listener di click per testare l'interazione
        button.addClickListener(event -> {
            System.out.println(labelText + " cliccato!"); // Messaggio in console per testare il click
        });

        // Layout verticale per etichetta + pulsante
        VerticalLayout layout = new VerticalLayout(label, button);
        layout.setAlignItems(Alignment.CENTER); // Centra il testo sopra il pulsante
        layout.setSpacing(false); // Rimuove spazio extra tra gli elementi
        layout.setMargin(false); // Rimuove margini extra

        return layout;
    }
}
