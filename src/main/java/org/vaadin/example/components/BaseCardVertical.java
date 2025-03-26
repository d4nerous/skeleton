package org.vaadin.example.components;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

@Component
public class BaseCardVertical extends VerticalLayout {

    public BaseCardVertical() {


        getStyle()
            .set("box-shadow", "1px 5px 5px 5px #e5e5e5")
            .set("border-radius", "10px");
    }


}
