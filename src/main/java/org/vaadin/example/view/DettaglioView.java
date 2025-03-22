package org.vaadin.example.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.vaadin.example.components.LeftColumnSecondView;

@Route(value = "dettaglio-view",layout = MainLayout.class)
@UIScope
public class DettaglioView extends VerticalLayout {
    private LeftColumnSecondView leftColumnSecondView;
    public DettaglioView( LeftColumnSecondView leftColumnSecondView) {

        add(leftColumnSecondView);
        setSizeFull();
        add("Questa è la seconda vista!");
    }
}
