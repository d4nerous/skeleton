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
        add(createRoundButtonWithLabel("Pulsante 1", "#FF5733"));  // Rosso - Tondo
        add(createRoundButtonWithLabel("Pulsante 2", "#33FF57"));  // Verde - Tondo
        add(createRoundButtonWithLabel("Pulsante 3", "#3357FF"));  // Blu - Tondo
        add(createSquareButtonWithLabel("Pulsante 4", "#F4D03F")); // Giallo - Quadrato
        add(createRoundButtonWithLabel("Pulsante 5", "#A569BD"));  // Viola - Tondo
    }

    // Metodo per creare un pulsante tondo con etichetta sopra
    private VerticalLayout createRoundButtonWithLabel(String labelText, String color) {
        // Etichetta
        Label label = new Label(labelText);
        label.getStyle()
                .set("font-size", "14px") // Imposta la dimensione del testo
                .set("margin-bottom", "5px") // Spazio tra testo e pulsante
                .set("color", "black"); // Colore del testo

        // Pulsante tondo
        Button button = new Button();
        button.setWidth("70px");  // Aumento delle dimensioni
        button.setHeight("70px"); // Aumento delle dimensioni
        button.getStyle()
                .set("background-color", color) // Colore sfondo
                .set("border", "none") // Nessun bordo
                .set("cursor", "pointer") // Cursore di tipo pointer per interazione
                .set("display", "flex") // Assicuriamo che il contenuto si adatti bene
                .set("align-items", "center") // Allinea gli elementi all'interno
                .set("justify-content", "center"); // Centra il testo all'interno
        button.getStyle().set("border-radius", "50%"); // Rende il pulsante tondo

        // Aggiungi listener di click per ogni pulsante
        button.addClickListener(event -> {
            handleButtonClick(labelText); // Gestisce l'evento per ogni pulsante
        });

        // Layout verticale per etichetta + pulsante
        VerticalLayout layout = new VerticalLayout(label, button);
        layout.setAlignItems(Alignment.CENTER); // Centra il testo sopra il pulsante
        layout.setSpacing(false); // Rimuove spazio extra tra gli elementi
        layout.setMargin(false); // Rimuove margini extra

        return layout;
    }

    // Metodo per creare un pulsante quadrato con etichetta sopra
    private VerticalLayout createSquareButtonWithLabel(String labelText, String color) {
        // Etichetta
        Label label = new Label(labelText);
        label.getStyle()
                .set("font-size", "14px") // Imposta la dimensione del testo
                .set("margin-bottom", "5px") // Spazio tra testo e pulsante
                .set("color", "black"); // Colore del testo

        // Pulsante quadrato
        Button button = new Button();
        button.setWidth("70px");  // Aumento delle dimensioni
        button.setHeight("70px"); // Aumento delle dimensioni
        button.getStyle()
                .set("background-color", color) // Colore sfondo
                .set("border", "none") // Nessun bordo
                .set("cursor", "pointer") // Cursore di tipo pointer per interazione
                .set("display", "flex") // Assicuriamo che il contenuto si adatti bene
                .set("align-items", "center") // Allinea gli elementi all'interno
                .set("justify-content", "center"); // Centra il testo all'interno

        // Aggiungi listener di click per ogni pulsante
        button.addClickListener(event -> {
            handleButtonClick(labelText); // Gestisce l'evento per ogni pulsante
        });

        // Layout verticale per etichetta + pulsante
        VerticalLayout layout = new VerticalLayout(label, button);
        layout.setAlignItems(Alignment.CENTER); // Centra il testo sopra il pulsante
        layout.setSpacing(false); // Rimuove spazio extra tra gli elementi
        layout.setMargin(false); // Rimuove margini extra

        return layout;
    }

    // Gestione evento del click per ciascun pulsante
    private void handleButtonClick(String buttonText) {
        // Esegui azioni diverse per ogni pulsante
        switch (buttonText) {
            case "Pulsante 1":
                System.out.println("Hai cliccato il " + buttonText + " - Azione 1");
                // Inserisci la logica per il pulsante 1
                break;
            case "Pulsante 2":
                System.out.println("Hai cliccato il " + buttonText + " - Azione 2");
                // Inserisci la logica per il pulsante 2
                break;
            case "Pulsante 3":
                System.out.println("Hai cliccato il " + buttonText + " - Azione 3");
                // Inserisci la logica per il pulsante 3
                break;
            case "Pulsante 4":
                System.out.println("Hai cliccato il " + buttonText + " - Azione 4");
                // Inserisci la logica per il pulsante 4
                break;
            case "Pulsante 5":
                System.out.println("Hai cliccato il " + buttonText + " - Azione 5");
                // Inserisci la logica per il pulsante 5
                break;
            default:
                System.out.println("Pulsante sconosciuto cliccato");
        }
    }
}
