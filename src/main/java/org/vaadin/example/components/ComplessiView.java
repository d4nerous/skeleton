package org.vaadin.example.components;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

@Component
public class ComplessiView extends HorizontalLayout {
    private final HorizontalLayout layoutSuperiore;
    private final HorizontalLayout layoutInferiore;
    public ComplessiView() {
        this.layoutSuperiore = new HorizontalLayout();
        this.layoutInferiore = new HorizontalLayout();

        setWidth("80vw");
        setHeight("20vh");
        getStyle().set("border","1px solid brown");




        // Aggiunta di 4 piccoli rettangoli con label
        for (int i = 1; i <= 4; i++) {
            Div smallBox = new Div();
            smallBox.setText("Elemento " + i);
        }


        // Aggiunta delle sezioni al layout principale
        add(layoutSuperiore, layoutInferiore);
    }
}

