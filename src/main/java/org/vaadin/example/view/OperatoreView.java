package org.vaadin.example.view;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;
import org.vaadin.example.components.ComplessiComponent;
import org.vaadin.example.components.LeftColumnBottonComponent;
import org.vaadin.example.components.RightColumnComponent;
import org.vaadin.example.components.RoundButtonComponent;

@Route(value = "operatore-view", layout = MainLayout.class)
@Component
@UIScope
public class OperatoreView extends HorizontalLayout {

    private final LeftColumnBottonComponent leftStates;
    private final RightColumnComponent rightColumnComponent;
    private final HorizontalLayout mainLayout;
    private final RoundButtonComponent roundButtonComponent;
    private final ComplessiComponent complessiComponent;

    public OperatoreView() {
        this.leftStates = new LeftColumnBottonComponent();
        this.rightColumnComponent = new RightColumnComponent();
        this.mainLayout = new HorizontalLayout();
        this.roundButtonComponent = new RoundButtonComponent();
        this.complessiComponent = new ComplessiComponent();

        buildUI();
    }

    private void buildUI() {
        setWidthFull();
        VerticalLayout layoutDestro = new VerticalLayout();
        HorizontalLayout orizzontale = new HorizontalLayout();
        orizzontale.add(roundButtonComponent, rightColumnComponent);
        orizzontale.setWidthFull();
        orizzontale.setHeightFull();
        layoutDestro.add(complessiComponent,
                orizzontale);
        layoutDestro.setHeightFull();
        layoutDestro.setWidth("86vw");
        mainLayout.setAlignItems(Alignment.START); // Allinea il contenuto verticalmente al centro
        mainLayout.setJustifyContentMode(JustifyContentMode.START);

        mainLayout.add(leftStates, layoutDestro);
        mainLayout.setWidthFull();
        mainLayout.setHeight("80vh");

        add(mainLayout);
    }


}
