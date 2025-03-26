package org.vaadin.example.components;

import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.vaadin.example.events.TabComplessiChangeEvent;

@Component
@UIScope
public class RoundButtonComponent extends Div {

    private final ListaCorsiComponent listaCorsiComponent;
    private final HorizontalLayout title = new HorizontalLayout();
    private final VerticalLayout layout = new VerticalLayout();

    public RoundButtonComponent() {
        this.listaCorsiComponent = new ListaCorsiComponent();

        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        // Crea un bottone grande, tondo e grigio
        setHeightFull();
        setWidth("70vw");


// Bottone circolare
        Span roundButton = new Span();
        roundButton.addClassName("sfera-grigia");

// Label sopra e sotto il bottone
        HorizontalLayout labelAbove = new HorizontalLayout(roundButton,new H5("CORSI DA ATTIVARE"));
        HorizontalLayout labelBelow = new HorizontalLayout(new H5("PLANNING ATTIVITA' DEL SETTORE"));
        title.setAlignItems(FlexComponent.Alignment.CENTER);
        title.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
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


        ComponentUtil.addListener(UI.getCurrent(), TabComplessiChangeEvent.class,event->
            UI.getCurrent().access(() -> {
                removeSome();
                this.title.add(new H4(event.getSelectedValue().getNome()));
                add(title);
                add(layout);
                add(listaCorsiComponent);
            })
        );


        // Aggiungi il listener di click al bottone
        roundButton.addClickListener(e -> {
            // Naviga alla vista "second-view"
            getUI().ifPresent(ui -> ui.navigate("dettaglio-view"));
            // Opzionale: mostra una notifica per il click
            Notification.show("Hai cliccato il bottone e sei stato reindirizzato alla seconda vista!");
        });


    }

    private void removeSome(){
        this.title.removeAll();
        remove(title);
        remove(layout);
        remove(listaCorsiComponent);
    }





}
