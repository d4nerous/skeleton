package org.vaadin.example.components;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.springframework.stereotype.Component;

@Component
public class BaseCardHorizontal extends HorizontalLayout {

    public BaseCardHorizontal() {


        getStyle()
                .set("background", "white")
                .set("box-shadow", "1px 5px 5px 5px #e5e5e5")
                .set("border-radius", "10px");
    }


}
