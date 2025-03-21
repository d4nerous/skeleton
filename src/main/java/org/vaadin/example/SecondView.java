package org.vaadin.example;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("second-view")
public class SecondView extends VerticalLayout {

    public SecondView() {
        setSizeFull();
        add("Questa è la seconda vista!");
    }
}
