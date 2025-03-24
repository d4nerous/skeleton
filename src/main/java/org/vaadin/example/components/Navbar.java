package org.vaadin.example.components;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;
import org.vaadin.example.Store;
import org.vaadin.example.model.RuoloDTO;
import org.vaadin.example.model.UtenteDTO;
import org.vaadin.example.service.EventService;

import java.util.ArrayList;
import java.util.Arrays;

@Component
@UIScope
public class Navbar extends HorizontalLayout {

    private ComboBox<String> annoFormativoComboBox = new ComboBox<>("Anno", Arrays.asList("2023", "2024"));
    private ComboBox<RuoloDTO> ruoloComboBox= new ComboBox<>("Ruolo");
    private Span nome;
    private EventService eventService;

    private UtenteDTO utente=null;
    private ArrayList<RuoloDTO> listaRuoli=null;
    private RuoloDTO ruoloSelected=null;
    private String annoSelected=null;


    public Navbar(EventService eventService) {
        Store store = VaadinSession.getCurrent().getAttribute(Store.class);
        this.eventService=eventService;
        this.utente= store.utente;
        this.listaRuoli=this.utente.getRoles();
        this.ruoloSelected=store.ruoloSelected;

        buildUI();
        addListener();

    }





    private void buildUI(){

        ruoloComboBox.setItems(listaRuoli);
        ruoloComboBox.setItemLabelGenerator(RuoloDTO::getName);
        if(this.ruoloSelected!=null)
            ruoloComboBox.setValue(ruoloSelected);


        setWidthFull();
        setPadding(true);
        setSpacing(true);
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        getStyle().set("border", "1px solid blue");

        // Titolo
        Span title = new Span("Titolo Applicazione");
        title.getStyle().set("font-size", "20px").set("font-weight", "bold");
        title.setWidth("300px");
        // Label con ID utente
        nome = new Span(utente.getName()+" "+utente.getSurname());

        // Layout per allineare gli elementi a destra
        HorizontalLayout rightLayout = new HorizontalLayout(annoFormativoComboBox, ruoloComboBox, nome);
        rightLayout.setWidthFull();
        rightLayout.setJustifyContentMode(JustifyContentMode.END);
        rightLayout.setAlignItems(Alignment.BASELINE);
        // Aggiunta dei componenti all'header
        add(VaadinIcon.AIRPLANE.create(), title, rightLayout);
    }



    private void addListener(){
        // Quando cambia il valore di annoFormativoComboBox, aggiorna il servizio
        annoFormativoComboBox.addValueChangeListener(event -> {
            if (event.getValue() != null) {
                eventService.publishAnnoChange(event.getValue());
            }
        });

        // Quando cambia il valore di ruoloComboBox, invia l'evento e aggiorna il servizio
        ruoloComboBox.addValueChangeListener(event -> {
            if (event.getValue() != null) {
                eventService.publishRuoloChange(event.getValue());
            }
        });
    }

    public void setRuoloComboBox(RuoloDTO ruolo) {
        this.ruoloComboBox.setValue(ruolo);
    }
}
