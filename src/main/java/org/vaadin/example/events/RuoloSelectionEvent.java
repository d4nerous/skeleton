package org.vaadin.example.events;

import org.springframework.context.ApplicationEvent;
import org.vaadin.example.model.RuoloDTO;

public class RuoloSelectionEvent extends ApplicationEvent {
    private final RuoloDTO selectedValue;

    public RuoloSelectionEvent(Object source, RuoloDTO selectedValue) {
        super(source);
        this.selectedValue = selectedValue;
    }

    public RuoloDTO getSelectedValue() {
        return selectedValue;
    }
}
