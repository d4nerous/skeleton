package org.vaadin.example.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class StatoListaCorsiComponent extends HorizontalLayout {
    public StatoListaCorsiComponent() {
        H3 title = new H3("Corsi da attivare");

        Span roundButton = new Span();
        roundButton.addClassName("sfera-grigia");
        roundButton.getStyle().set("height","35px");
        roundButton.getStyle().set("width","35px");

        Icon plusIcon = VaadinIcon.PLUS.create();
        plusIcon.getStyle().set("color", "white"); // Imposta il colore verde

        // Creazione del pulsante con icona e testo
        Button addButton = new Button("Aggiungi a sessione", plusIcon);
        addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addButton.getStyle().set("color", "white");


        setWidthFull(); // Imposta larghezza al 100%
        setJustifyContentMode(JustifyContentMode.CENTER); // Centra orizzontalmente
        setAlignItems(Alignment.CENTER); // Centra verticalmente

        // Aggiunge il titolo al layout
        add(roundButton,title,addButton);

    }

}
