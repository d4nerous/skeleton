package org.vaadin.example.components;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.vaadin.example.service.EventService;
import org.vaadin.example.service.ComboBoxService;  // Importa il servizio ComboBox

@Component
public class Navbar extends HorizontalLayout {

    private ComboBox<String> annoFormativoComboBox;
    private ComboBox<String> ruoloComboBox;
    private Span matricolaLabel;
    private EventService eventService;
    private ComboBoxService comboBoxService;  // Aggiungi ComboBoxService

    @Autowired
    public Navbar(EventService eventService, ComboBoxService comboBoxService) {
        this.eventService = eventService;
        this.comboBoxService = comboBoxService;  // Inietta ComboBoxService

        setWidthFull();
        setPadding(true);
        setSpacing(true);
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        getStyle().set("background-color", "blue");

        // Titolo
        Span title = new Span("Titolo Applicazione");
        title.getStyle().set("font-size", "20px").set("font-weight", "bold");

        // ComboBox 1: Anno Formativo
        annoFormativoComboBox = new ComboBox<>();
        annoFormativoComboBox.setLabel("Anno Formativo");
        annoFormativoComboBox.setItems("2023", "2024");
        // Imposta il valore iniziale dalla variabile del servizio (se disponibile)
        annoFormativoComboBox.setValue(comboBoxService.getSelectedValue1());

        // ComboBox 2: Ruolo
        ruoloComboBox = new ComboBox<>("Ruolo");
        ruoloComboBox.setItems("Operatore", "Altro");
        // Imposta il valore iniziale dalla variabile del servizio (se disponibile)
        ruoloComboBox.setValue(comboBoxService.getSelectedValue2());

        // Quando cambia il valore di annoFormativoComboBox, aggiorna il servizio
        annoFormativoComboBox.addValueChangeListener(event -> {
            if (event.getValue() != null) {
                comboBoxService.setSelectedValue1(event.getValue());
            }
        });

        // Quando cambia il valore di ruoloComboBox, invia l'evento e aggiorna il servizio
        ruoloComboBox.addValueChangeListener(event -> {
            if (event.getValue() != null) {
                eventService.publishRuoloChange(event.getValue());
                comboBoxService.setSelectedValue2(event.getValue());
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
        add(VaadinIcon.AIRPLANE.create(), title, rightLayout);
    }
}
