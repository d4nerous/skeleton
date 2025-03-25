package org.vaadin.example.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.vaadin.example.components.LeftColumnSecondViewComponent;

@Route(value = "dettaglio-view",layout = MainLayout.class)
@UIScope
public class DettaglioView extends VerticalLayout {
    private LeftColumnSecondViewComponent leftColumnSecondViewComponent;
    public DettaglioView( LeftColumnSecondViewComponent leftColumnSecondViewComponent) {

        add(leftColumnSecondViewComponent);
        setSizeFull();
        add("Questa è la seconda vista!");
    }
}
