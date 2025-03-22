package org.vaadin.example.view;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;
import org.vaadin.example.components.NavigationStates;
import org.vaadin.example.components.RightColumnView;
import org.vaadin.example.components.RoundButtonComponent;
import org.vaadin.example.service.EventService;

@Route(value = "altro-view",layout = MainLayout.class)
@Component
@UIScope
public class AltroView extends VerticalLayout {


    private final HorizontalLayout mainLayout;

    public AltroView(EventService eventService) {

        this.mainLayout = new HorizontalLayout();

        buildUI();
    }

    private void buildUI() {
        setWidthFull();

    mainLayout.add(new Span("Ancora Nulla"));
    mainLayout.setWidthFull();
    mainLayout.setHeightFull();
    mainLayout.setAlignItems(Alignment.START); // Allinea il contenuto verticalmente al centro
    mainLayout.setJustifyContentMode(JustifyContentMode.START) ;

    mainLayout.getStyle().set("border","1px solid grey");


    add( mainLayout);
    }



}
