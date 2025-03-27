package org.vaadin.example.components;

import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.vaadin.example.events.TabComplessiChangeEvent;
import org.vaadin.example.model.AbilitazioniComplessiDTO;
import org.vaadin.example.view.CorsiDaAttivareView;

@Component
@UIScope
public class RoundButtonComponent extends Div {

    private final ListaCorsiComponent listaCorsiComponent;
    private final HorizontalLayout title = new HorizontalLayout();
    private VerticalLayout costi = new VerticalLayout();
    private final VerticalLayout layout = new VerticalLayout();
    private final Span roundButton = new Span();
    private final HorizontalLayout button= new HorizontalLayout(roundButton,new H5("CORSI DA ATTIVARE"));
    private final HorizontalLayout labelAbove = new HorizontalLayout(button,costi);
    private AbilitazioniComplessiDTO abilitazioniComplessiDTO = new AbilitazioniComplessiDTO();


    public RoundButtonComponent() {
        this.listaCorsiComponent = new ListaCorsiComponent();

        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        // Crea un bottone grande, tondo e grigio
        setHeightFull();
        setWidth("70vw");


// Bottone circolare
        roundButton.addClassName("sfera-grigia");
        roundButton.getStyle().set("height","72px");
        roundButton.getStyle().set("width","72px");

        button.getStyle().set("border","1px solid grey");
        button.getStyle().set("border-radius","20px");
        button.getStyle().set("box-shadow","2px 4px 5px 5px #5d222221");
        button.setPadding(true);
        button.setWidthFull();
        button.setMargin(true);

        title.setAlignItems(FlexComponent.Alignment.CENTER);
        title.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);


        button.setHeightFull();
        button.setWidthFull();
        button.setAlignItems(FlexComponent.Alignment.CENTER);
        button.setJustifyContentMode(FlexComponent.JustifyContentMode.START);

        labelAbove.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        labelAbove.setAlignItems(FlexComponent.Alignment.CENTER);;
        labelAbove.setWidthFull();

        layout.add(labelAbove);


        ComponentUtil.addListener(UI.getCurrent(), TabComplessiChangeEvent.class,event->
            UI.getCurrent().access(() -> {
                int indexcosti=this.labelAbove.indexOf(costi);
                removeSome();
                this.costi=new VerticalLayout();
                this.labelAbove.addComponentAtIndex(indexcosti,costi);
                this.abilitazioniComplessiDTO = event.getSelectedValue();
                this.costi.add(new Label("Importo stanziato: "+event.getSelectedValue().getImportoStanziato()));
                this.costi.add(new Label("Costi sostenuti:    "+event.getSelectedValue().getCostiSostenuti()));
                this.title.add(new H4(event.getSelectedValue().getNome()));
                add(title);
                add(layout);
                add(listaCorsiComponent);
            })
        );


        // Aggiungi il listener di click al bottone
        roundButton.addClickListener(e -> {
            getUI().ifPresent(ui -> ui.navigate("corsiDaAttivare-view/" + abilitazioniComplessiDTO.getId()));
        });


    }

    private void removeSome(){
        this.title.removeAll();
        this.labelAbove.remove(costi);
        remove(title);
        remove(layout);
        remove(listaCorsiComponent);
    }





}
