package org.vaadin.example.events;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import org.vaadin.example.model.AbilitazioniComplessiDTO;

public class TabComplessiChangeEvent extends ComponentEvent<Component> {
    private final AbilitazioniComplessiDTO selectedValue;

    public TabComplessiChangeEvent(Component source, AbilitazioniComplessiDTO selectedValue) {
        super(source, false);
        this.selectedValue = selectedValue;
    }

    public AbilitazioniComplessiDTO getSelectedValue() {
        return selectedValue;
    }
}
