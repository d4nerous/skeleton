package org.vaadin.example.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.vaadin.example.components.LeftColumnDettaglioViewComponent;

@Route(value = "dettaglio-view",layout = MainLayout.class)
@UIScope
public class DettaglioView extends VerticalLayout {
    private LeftColumnDettaglioViewComponent leftColumnDettaglioViewComponent;
    public DettaglioView( LeftColumnDettaglioViewComponent leftColumnDettaglioViewComponent) {

        add(leftColumnDettaglioViewComponent);
        setSizeFull();
        add("Questa è la seconda vista!");
    }
}
