package org.vaadin.example.events;

import org.springframework.context.ApplicationEvent;

public class AnnoSelectionEvent extends ApplicationEvent {
    private final String selectedValue;

    public AnnoSelectionEvent(Object source, String anno) {
        super(source);
        this.selectedValue = anno;
    }

    public String getSelectedValue() {
        return selectedValue;
    }
}
