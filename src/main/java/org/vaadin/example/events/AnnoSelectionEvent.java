package org.vaadin.example.events;

import org.springframework.context.ApplicationEvent;
import org.vaadin.example.model.AnnoFormtivoDTO;

public class AnnoSelectionEvent extends ApplicationEvent {
    private final AnnoFormtivoDTO selectedValue;

    public AnnoSelectionEvent(Object source, AnnoFormtivoDTO anno) {
        super(source);
        this.selectedValue = anno;
    }

    public AnnoFormtivoDTO getSelectedValue() {
        return selectedValue;
    }
}
