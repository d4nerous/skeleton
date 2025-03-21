package org.vaadin.example.components;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.vaadin.example.service.EventService;

@Component
public class Navbar extends HorizontalLayout {

    private ComboBox<String> annoFormativoComboBox;
    private ComboBox<String> ruoloComboBox;
    private Span matricolaLabel;
    private EventService eventService;



    public Navbar(EventService eventService) {
        this.eventService=eventService;
        setWidthFull();
        setPadding(true);
        setSpacing(true);
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        getStyle().set("background-color", "blue");

        // Titolo
        Span title = new Span("Titolo Applicazione");
        title.getStyle().set("font-size", "20px").set("font-weight", "bold");

        // ComboBox 1: Lingua
        annoFormativoComboBox = new ComboBox<>();
        annoFormativoComboBox.setLabel("Lingua");
        annoFormativoComboBox.setItems("Italiano", "English", "Español");
        annoFormativoComboBox.setValue("Italiano");

// ComboBox 2 (tipo utente)
        ruoloComboBox = new ComboBox<>("Ruolo");
        ruoloComboBox.setItems("Operatore", "Altro");
        annoFormativoComboBox.setValue("operatore");
        // Quando cambia il valore, invia l'evento
        ruoloComboBox.addValueChangeListener(event -> {
            if (event.getValue() != null) {
                eventService.publishRuoloChange(event.getValue());
            }
        });
        // Label con ID utente
        matricolaLabel = new Span("ID: 123456");

        // Layout per allineare gli elementi a destra
        HorizontalLayout rightLayout = new HorizontalLayout(annoFormativoComboBox, ruoloComboBox, matricolaLabel);
        rightLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        rightLayout.setWidthFull();
        rightLayout.setJustifyContentMode(JustifyContentMode.END);

        // Aggiunta dei componenti all'header
        add(VaadinIcon.AIRPLANE.create(),title, rightLayout);
    }


}


