package org.vaadin.example.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;


@Component
@UIScope
public class FiltriComplessiComponent extends HorizontalLayout {
    public FiltriComplessiComponent() {
        TextField textField2 = new TextField();
        textField2.setPlaceholder("Inserisci altro testo...");
        // ComboBox selezionabili
        ComboBox<String> comboBox1 = new ComboBox<>();
        comboBox1.setPlaceholder("Sottoinsieme");
        comboBox1.setItems("Opzione A", "Opzione B", "Opzione C");

        ComboBox<String> comboBox2 = new ComboBox<>();
        comboBox2.setPlaceholder("Attività");
        comboBox2.setItems("Scelta 1", "Scelta 2", "Scelta 3");

        ComboBox<String> comboBox3 = new ComboBox<>();
        comboBox3.setPlaceholder("Priorità");
        comboBox3.setItems("Valore X", "Valore Y", "Valore Z");

        // Pulsante con icona "Lente di ingrandimento" (Cerca)
        Button searchButton = new Button(VaadinIcon.SEARCH.create());


        // Pulsante con icona "Gomma" (Resetta)
        Button clearButton = new Button(VaadinIcon.ERASER.create());

        // Imposta allineamento e distribuzione dei componenti
        setWidthFull();
        setJustifyContentMode(JustifyContentMode.START); // Allinea gli elementi a sinistra
        setAlignItems(Alignment.CENTER); // Centra verticalmente gli elementi
        setSpacing(true); // Aggiunge spazio tra i componenti

        // Aggiunge i componenti al layout
        add(comboBox1, comboBox2, textField2, comboBox3, searchButton, clearButton);
    }
}

