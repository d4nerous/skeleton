package org.vaadin.example.components;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DatePickerGridComponent extends BaseCardVertical {

    private Grid<Item> grid;
    private List<Item> itemList;

    public DatePickerGridComponent() {
        setSizeFull();

        // Creazione del DatePicker
        DatePicker datePicker = new DatePicker("Seleziona una data");
        datePicker.setClearButtonVisible(true);
        datePicker.addValueChangeListener(event -> filterGrid(event.getValue()));

        // Creazione della tabella (Grid)
        grid = new Grid<>(Item.class);
        grid.setSizeFull();

        // Popolamento dati
        itemList = getMockData();
        grid.setItems(itemList);

        // Aggiunta dei componenti al layout
        add(datePicker, grid);
    }

    // Metodo per filtrare la tabella in base alla data selezionata
    private void filterGrid(LocalDate selectedDate) {
        if (selectedDate == null) {
            grid.setItems(itemList); // Ripristina tutti i dati
        } else {
            List<Item> filteredList = itemList.stream()
                .filter(item -> item.getDate().equals(selectedDate))
                .collect(Collectors.toList());
            grid.setItems(filteredList);
        }
    }

    // Simulazione di dati finti
    private List<Item> getMockData() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(LocalDate.of(2024, 3, 1), "Elemento 1", 100));
        items.add(new Item(LocalDate.of(2024, 3, 1), "Elemento 2", 200));
        items.add(new Item(LocalDate.of(2024, 3, 2), "Elemento 3", 300));
        items.add(new Item(LocalDate.of(2024, 3, 3), "Elemento 4", 400));
        return items;
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
