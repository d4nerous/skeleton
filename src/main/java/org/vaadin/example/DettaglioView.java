package org.vaadin.example;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.example.components.LeftColumnSecondView;
import org.vaadin.example.components.Navbar;

@Route("dettaglio-view")
public class DettaglioView extends VerticalLayout {
private Navbar navbar;
    private LeftColumnSecondView leftColumnSecondView;
    public DettaglioView(Navbar navbar, LeftColumnSecondView leftColumnSecondView) {

        add(navbar);
        add(leftColumnSecondView);
        setSizeFull();
        add("Questa è la seconda vista!");
    }
}
