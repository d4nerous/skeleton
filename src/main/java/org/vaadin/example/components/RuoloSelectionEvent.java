package org.vaadin.example.components;

import org.springframework.context.ApplicationEvent;

public class RuoloSelectionEvent extends ApplicationEvent {
    private final String selectedValue;

    public RuoloSelectionEvent(Object source, String selectedValue) {
        super(source);
        this.selectedValue = selectedValue;
    }

    public String getSelectedValue() {
        return selectedValue;
    }
}
