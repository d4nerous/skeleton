package org.vaadin.example.components;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

@Component
public class LeftColumnBottonComponent extends BaseCardVertical {

    public LeftColumnBottonComponent() {
        // Impostazioni layout principale
        setHeightFull();
        setWidth("15vw");
        //setHeight("70vh");
        setAlignItems(Alignment.CENTER); // Centra gli elementi

        // Aggiungi i pulsanti con il testo sopra
        add(createRoundButtonWithLabel("Corsi Attivati", "sfera-verde"));
        add(createRoundButtonWithLabel("Corsi Chiusi","sfera-rossa"));
        add(createRoundButtonWithLabel("Corsi Annullati", "sfera-blue"));
        add(createSquareButtonWithLabel("Extra PAF", "rettangolo-yellow"));
        add(createRoundButtonWithLabel("Annulla Corso", "sfera-azure"));

    }

    // Metodo per creare un pulsante tondo con etichetta sopra
    private VerticalLayout createRoundButtonWithLabel(String labelText, String style) {

        VerticalLayout vl=new VerticalLayout();
        vl.setAlignItems(Alignment.CENTER);
        vl.setJustifyContentMode(JustifyContentMode.CENTER);
        vl.setPadding(false);
        vl.setMargin(false);
        // Pulsante tondo
        Span button = new Span();
        button.addClassName(style);
        // Aggiungi listener di click per ogni pulsante
        button.addClickListener(event -> {
            handleButtonClick(labelText); // Gestisce l'evento per ogni pulsante
        });

        vl.add(button);
        vl.add(new Label(labelText));
        return vl;
    }

    // Metodo per creare un pulsante quadrato con etichetta sopra
    private VerticalLayout createSquareButtonWithLabel(String labelText, String style) {
        // Pulsante quadrato
        VerticalLayout vl=new VerticalLayout();
        vl.setAlignItems(Alignment.CENTER);
        vl.setJustifyContentMode(JustifyContentMode.CENTER);
        vl.setPadding(false);
        vl.setMargin(false);
        Span button = new Span();
        button.addClassName(style);

        vl.add(button);
        vl.add(new Label(labelText));
        // Aggiungi listener di click per ogni pulsante
        button.addClickListener(event -> {
            handleButtonClick(labelText); // Gestisce l'evento per ogni pulsante
        });

        // Layout verticale per etichetta + pulsante
        return vl;
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
