package org.vaadin.example.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

@Component
public class NavigationStates extends VerticalLayout {

    public NavigationStates() {
        // Impostazioni layout principale
        setHeightFull();
        setWidth("20vw");
        setHeight("70vh");
        setAlignItems(Alignment.CENTER); // Centra gli elementi

        // Aggiungi i pulsanti con il testo sopra
        add(createRoundButtonWithLabel("1", "#FF5733"));  // Rosso - Tondo
        add(createRoundButtonWithLabel("2","#33FF57"));  // Verde - Tondo
        add(createRoundButtonWithLabel("3", "#3357FF"));  // Blu - Tondo
        add(createSquareButtonWithLabel("4", "#F4D03F")); // Giallo - Quadrato
        add(createRoundButtonWithLabel("5", "#A569BD"));  // Viola - Tondo

        getStyle().set("border","1px solid purple");
    }

    // Metodo per creare un pulsante tondo con etichetta sopra
    private Button createRoundButtonWithLabel(String labelText, String color) {

        // Pulsante tondo
        Button button = new Button(labelText);
        button.setWidth("46px");  // Aumento delle dimensioni
        button.setHeight("46px"); // Aumento delle dimensioni
        button.getStyle()
                .set("background-color", color) // Colore sfondo
                .set("border", "none") // Nessun bordo
                .set("cursor", "pointer") // Cursore di tipo pointer per interazione
               // .set("display", "flex") // Assicuriamo che il contenuto si adatti bene
                .set("align-items", "center") // Allinea gli elementi all'interno
                .set("justify-content", "center"); // Centra il testo all'interno
        button.getStyle().set("border-radius", "50%"); // Rende il pulsante tondo

        // Aggiungi listener di click per ogni pulsante
        button.addClickListener(event -> {
            handleButtonClick(labelText); // Gestisce l'evento per ogni pulsante
        });


        return button;
    }

    // Metodo per creare un pulsante quadrato con etichetta sopra
    private Button createSquareButtonWithLabel(String labelText, String color) {
        // Pulsante quadrato
        Button button = new Button(labelText);
        button.setWidth("46px");  // Aumento delle dimensioni
        button.setHeight("46px"); // Aumento delle dimensioni
        button.getStyle()
                .set("background-color", color) // Colore sfondo
                .set("border", "none") // Nessun bordo
                .set("cursor", "pointer") // Cursore di tipo pointer per interazione
               // .set("display", "flex") // Assicuriamo che il contenuto si adatti bene
                .set("align-items", "center") // Allinea gli elementi all'interno
                .set("justify-content", "center"); // Centra il testo all'interno

        // Aggiungi listener di click per ogni pulsante
        button.addClickListener(event -> {
            handleButtonClick(labelText); // Gestisce l'evento per ogni pulsante
        });

        // Layout verticale per etichetta + pulsante

        return button;
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



//    private String getScreenHeigth() {
//        // Recupera l'altezza disponibile e imposta il layout
//        AtomicReference<String> screenHeight= new AtomicReference<>("0px");
//        UI.getCurrent().getPage().retrieveExtendedClientDetails(details -> {
//            screenHeight.set(details.getScreenHeight()+"px");
//        });
//        return screenHeight.get();
//    }
}
