package org.vaadin.example.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class RoundButtonComponent extends Div {

    private final ListaCorsiComponent listaCorsiComponent;

    public RoundButtonComponent() {
        this.listaCorsiComponent = new ListaCorsiComponent();

        VerticalLayout layout = new VerticalLayout();
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        // Crea un bottone grande, tondo e grigio
        setHeightFull();
        setWidth("70vw");


// Bottone circolare
        Span roundButton = new Span();
        roundButton.addClassName("sfera-grigia");

// Label sopra e sotto il bottone
        HorizontalLayout labelAbove = new HorizontalLayout(roundButton,new Label("CORSI DA ATTIVARE"));
        HorizontalLayout labelBelow = new HorizontalLayout(new Label("PLANNING ATTIVITA' DEL SETTORE"));
        labelAbove.setHeightFull();
        labelAbove.setWidthFull();
        labelAbove.setAlignItems(FlexComponent.Alignment.CENTER);
        labelAbove.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        labelBelow.setWidthFull();
        labelBelow.setHeightFull();
        labelBelow.setAlignItems(FlexComponent.Alignment.BASELINE);
        labelBelow.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
// Aggiunta degli elementi nel layout
        layout.add(labelAbove, labelBelow);

        // Aggiungi il listener di click al bottone
        roundButton.addClickListener(e -> {
            // Naviga alla vista "second-view"
            getUI().ifPresent(ui -> ui.navigate("dettaglio-view"));
            // Opzionale: mostra una notifica per il click
            Notification.show("Hai cliccato il bottone e sei stato reindirizzato alla seconda vista!");
        });
        add(layout);
        add(listaCorsiComponent);

    }
}
