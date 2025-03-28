package org.vaadin.example.components;

import com.vaadin.flow.component.tabs.Tab;

public class BaseTabComponent extends Tab {

    BaseTabComponent(String codice){
        super.setLabel(codice);
        getStyle().set("font-size", "xx-large");

    }
}
