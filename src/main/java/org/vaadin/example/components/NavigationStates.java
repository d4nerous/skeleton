package org.vaadin.example.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@UIScope
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
        Label label = new Label(labelText);
        label.getStyle()
                .set("font-size", "14px") // Imposta la dimensione del testo
                .set("margin-bottom", "5px") // Spazio tra testo e pulsante
                .set("color", "black"); // Colore del testo

        Button button = new Button();
        button.setWidth("46px");
        button.setHeight("46px");
        button.getStyle()
                .set("background-color", color) // Colore sfondo
                .set("border", "none"); // Nessun bordo

        if (isRound) {
            button.getStyle().set("border-radius", "50%"); // Rende il pulsante tondo
        }

        // Layout verticale per etichetta + pulsante
        VerticalLayout layout = new VerticalLayout(label, button);
        layout.setAlignItems(Alignment.CENTER); // Centra il testo sopra il pulsante
        return layout;
    }
}


