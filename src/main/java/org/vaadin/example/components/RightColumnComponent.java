package org.vaadin.example.components;

import com.vaadin.flow.component.button.Button;
import org.springframework.stereotype.Component;

@Component
public class RightColumnComponent extends BaseCardVertical {

    public RightColumnComponent() {
        // Impostazioni layout principale
        setHeightFull();
        setWidth("15vw");
        setAlignItems(Alignment.CENTER);  // Centra i pulsanti

        // Aggiungi i 5 pulsanti con testo
        add(createButton("Pulsante 1", "evento1"));
        add(createButton("Pulsante 2", "evento2"));
        add(createButton("Pulsante 3", "evento3"));
        add(createButton("Pulsante 4", "evento4"));
        add(createButton("Pulsante 5", "evento5"));


    }


    // Metodo per creare un pulsante rettangolare con etichetta
    private Button createButton(String buttonText, String eventType) {
        Button button = new Button(buttonText);

        button.setWidth("200px");  // Impostiamo una larghezza fissa per il pulsante
        button.setHeight("50px");  // Impostiamo l'altezza del pulsante
        button.getStyle()
                .set("background-color", "#4CAF50")  // Colore di sfondo
                .set("color", "white")  // Colore del testo
                .set("border", "none")  // Nessun bordo
                .set("cursor", "pointer")  // Cursore pointer per interazione
                .set("text-align", "center");  // Allinea il testo al centro

        // Aggiungi il listener per il click
        button.addClickListener(event -> {
            handleButtonClick(eventType);  // Passa il tipo di evento per identificare il pulsante
        });

        return button;
    }

    // Gestione evento del click per ciascun pulsante
    private void handleButtonClick(String eventType) {
        switch (eventType) {
            case "evento1":
                System.out.println("Pulsante 1 cliccato!");
                // Logica per Pulsante 1
                break;
            case "evento2":
                System.out.println("Pulsante 2 cliccato!");
                // Logica per Pulsante 2
                break;
            case "evento3":
                System.out.println("Pulsante 3 cliccato!");
                // Logica per Pulsante 3
                break;
            case "evento4":
                System.out.println("Pulsante 4 cliccato!");
                // Logica per Pulsante 4
                break;
            case "evento5":
                System.out.println("Pulsante 5 cliccato!");
                // Logica per Pulsante 5
                break;
            default:
                System.out.println("Evento sconosciuto!");
                break;
        }
    }
}
