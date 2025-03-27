package org.vaadin.example.components;

import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.vaadin.example.Utility;
import org.vaadin.example.events.TabComplessiChangeEvent;
import org.vaadin.example.model.AbilitazioniComplessiDTO;
import org.vaadin.example.model.CorsoDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@UIScope
public class ListaCorsiComponent extends BaseCardVertical {

    private final ListBox<CorsoDTO> itemList= new ListBox<>();
    private List<CorsoDTO> fullList= new ArrayList<>();
    private final DatePicker datePicker = new DatePicker("Seleziona una data");
    private AbilitazioniComplessiDTO complessoSelezionato;
    private VerticalLayout listBoxContainer = new VerticalLayout();

    private final HorizontalLayout nessunRisulatato=new HorizontalLayout(new H3("Non ci sono attività presenti"));
    public ListaCorsiComponent() {
        setSizeFull();
        setHeight("43vh");
        getStyle().set("overflow","auto");
        listBoxContainer.setWidth("30vh");
        listBoxContainer.setWidthFull();
        listBoxContainer.getStyle().set("overflow","auto");
        nessunRisulatato.setWidthFull();

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
        listBoxContainer.add(fullList.isEmpty()?nessunRisulatato:itemList);

        HorizontalLayout ol= new HorizontalLayout();
        ol.setJustifyContentMode(JustifyContentMode.END);
        ol.setAlignItems(Alignment.BASELINE);
        // Creazione del DatePicker
        datePicker.setClearButtonVisible(true);
        datePicker.addValueChangeListener(event -> filterGrid(event.getValue(),complessoSelezionato));
        datePicker.setValue(LocalDate.now());
        HorizontalLayout labelBelow = new HorizontalLayout(new H5("PLANNING ATTIVITA' DEL SETTORE"));
        labelBelow.setWidthFull();
        labelBelow.setHeightFull();
        labelBelow.setAlignItems(FlexComponent.Alignment.BASELINE);
        labelBelow.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        // Popolamento dati
        ol.add(labelBelow,datePicker);

        // Aggiunta dei componenti al layout

        add(ol, listBoxContainer);


        ComponentUtil.addListener(UI.getCurrent(), TabComplessiChangeEvent.class, event->
                UI.getCurrent().access(() -> {
                    filterGrid(datePicker.getValue(),event.getSelectedValue());
                    this.complessoSelezionato=event.getSelectedValue();
                })
        );


    }

    // Metodo per filtrare la tabella in base alla data selezionata
    private void filterGrid(LocalDate selectedDate, AbilitazioniComplessiDTO complessoSelezionato) {
        if (selectedDate != null) {
            listBoxContainer.removeAll();
            List<CorsoDTO> filteredList = fullList
                .stream().filter(item -> item.getDataInizio().toLocalDate().equals(selectedDate)
                                && item.getIdComplesso().equals(complessoSelezionato.getId()))
                .collect(Collectors.toList());
            itemList.setItems(filteredList);

            listBoxContainer.add(filteredList.isEmpty()?nessunRisulatato:itemList);

        }
    }

    // Simulazione di dati finti
    private List<CorsoDTO> getMockData() {
        CorsoDTO[] corsi = Utility.loadJson2("listaCorsi.json",  CorsoDTO[].class);
        return Arrays.asList(corsi);
    }


}
