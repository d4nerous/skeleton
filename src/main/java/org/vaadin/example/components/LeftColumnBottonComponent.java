package org.vaadin.example.components;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
        add(createRoundButtonWithLabel("Corsi Attivati", "sfera-verde","green"));
        add(createRoundButtonWithLabel("Corsi Chiusi","sfera-rossa","red"));
        add(createRoundButtonWithLabel("Corsi Annullati", "sfera-blue","blue"));
        add(createSquareButtonWithLabel("Extra PAF", "rettangolo-yellow","yellow"));
        add(createRoundButtonWithLabel("Annulla Corso", "sfera-azure","cyan"));

    }

    // Metodo per creare un pulsante tondo con etichetta sopra
    private HorizontalLayout createRoundButtonWithLabel(String labelText, String style,String color) {

        HorizontalLayout vl=new HorizontalLayout();
        vl.getStyle().set("border","1px solid "+color);
        vl.getStyle().set("border-radius","20px");
        vl.getStyle().set("box-shadow","2px 4px 5px 5px #5d222221");
        vl.getStyle().set("cursor","pointer");
        vl.setAlignItems(Alignment.CENTER);
        vl.setJustifyContentMode(JustifyContentMode.START);
        vl.setPadding(true);
        vl.setWidthFull();
        vl.setMargin(true);

        Span button = new Span();
        button.addClassName(style);
        // Aggiungi listener di click per ogni pulsante
        vl.addClickListener(event -> {
            handleButtonClick(labelText); // Gestisce l'evento per ogni pulsante
        });

        vl.add(button);
        vl.add(new Label(labelText));
        return vl;
    }

    // Metodo per creare un pulsante quadrato con etichetta sopra
    private HorizontalLayout createSquareButtonWithLabel(String labelText, String style,String color) {
        // Pulsante quadrato
        HorizontalLayout vl=new HorizontalLayout();
        vl.getStyle().set("border","1px solid "+color);
        vl.getStyle().set("border-radius","20px");
        vl.getStyle().set("box-shadow","2px 4px 5px 5px #5d222221");
        vl.setAlignItems(Alignment.CENTER);
        vl.setJustifyContentMode(JustifyContentMode.START);
        vl.setWidthFull();
        vl.setMargin(true);
        vl.setPadding(true);
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
