package org.vaadin.example.components;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import org.springframework.stereotype.Component;
import org.vaadin.example.Utility;
import org.vaadin.example.model.CorsoDTO;
import org.vaadin.example.model.UtenteDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListaCorsiComponent extends BaseCardVertical {

    private final ListBox<CorsoDTO> itemList= new ListBox<>();
    private List<CorsoDTO> fullList= new ArrayList<>();

    public ListaCorsiComponent() {
        setSizeFull();
        setHeight("50vh");
        getStyle().set("overflow","auto");

        itemList.setRenderer(new ComponentRenderer<>(corso -> {
            HorizontalLayout row = new HorizontalLayout();
            row.setAlignItems(Alignment.START);

            row.add(new Label(corso.getCodiceSCU() +", "+corso.getAula()+", "
                    +corso.getDataInizio().getHour()+":"+corso.getDataInizio().getMinute()+" - "
                    +corso.getDataFine().getHour()+":"+corso.getDataFine().getMinute()+","+
                    corso.getDocente()

            ));
            row.getStyle().set("line-height", "var(--lumo-line-height-m)");
            return row;
        }));
        fullList=getMockData();
        itemList.setItems(fullList);
        itemList.setWidthFull();


        HorizontalLayout ol= new HorizontalLayout();
        ol.setJustifyContentMode(JustifyContentMode.END);
        ol.setAlignItems(Alignment.BASELINE);
        // Creazione del DatePicker
        DatePicker datePicker = new DatePicker("Seleziona una data");
        datePicker.setClearButtonVisible(true);
        datePicker.addValueChangeListener(event -> filterGrid(event.getValue()));
        datePicker.setValue(LocalDate.now());
        // Popolamento dati
        ol.add(datePicker);

        // Aggiunta dei componenti al layout
        add(ol, itemList);
    }

    // Metodo per filtrare la tabella in base alla data selezionata
    private void filterGrid(LocalDate selectedDate) {
        if (selectedDate != null) {
            List<CorsoDTO> filteredList = fullList
                .stream().filter(item -> item.getDataInizio().toLocalDate().equals(selectedDate))
                .collect(Collectors.toList());
            itemList.setItems(filteredList);
        }
    }

    // Simulazione di dati finti
    private List<CorsoDTO> getMockData() {
        CorsoDTO[] corsi = Utility.loadJson2("listaCorsi.json",  CorsoDTO[].class);

        return Arrays.asList(corsi);
    }

    // Classe interna per gli elementi della tabella
    public static class Item {
        private LocalDate date;
        private String name;
        private int value;

        public Item(LocalDate date, String name, int value) {
            this.date = date;
            this.name = name;
            this.value = value;
        }

        public LocalDate getDate() {
            return date;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }
}
