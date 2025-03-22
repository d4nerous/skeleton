package org.vaadin.example.view;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;
import org.vaadin.example.components.NavigationStates;
import org.vaadin.example.components.RightColumnView;
import org.vaadin.example.components.RoundButtonComponent;
import org.vaadin.example.service.EventService;

@Route(value = "operatore-view",layout = MainLayout.class)
@Component
@UIScope
public class OperatoreView extends VerticalLayout {

    private final NavigationStates leftStates;
    private final RightColumnView rightColumnView;
    private final HorizontalLayout mainLayout;
    private final RoundButtonComponent roundButtonComponent;

    public OperatoreView(EventService eventService) {
        this.leftStates = new NavigationStates();
        this.rightColumnView = new RightColumnView();
        this.mainLayout = new HorizontalLayout();
        this.roundButtonComponent = new RoundButtonComponent();

        buildUI();
    }

    private void buildUI() {
        setWidthFull();

    mainLayout.add(leftStates,roundButtonComponent,rightColumnView);
    mainLayout.setWidthFull();
    mainLayout.setHeightFull();
    mainLayout.setAlignItems(Alignment.START); // Allinea il contenuto verticalmente al centro
    mainLayout.setJustifyContentMode(JustifyContentMode.START) ;

    mainLayout.getStyle().set("border","1px solid grey");


    add( mainLayout);
    }



}
