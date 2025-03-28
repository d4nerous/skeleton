package org.vaadin.example.components;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;
import org.vaadin.example.Store;
import org.vaadin.example.model.AnnoFormtivoDTO;
import org.vaadin.example.model.RuoloDTO;
import org.vaadin.example.model.UtenteDTO;
import org.vaadin.example.service.EventService;

import java.util.ArrayList;
import java.util.Comparator;

@Component
@UIScope
public class NavbarComponent extends HorizontalLayout {

    private ComboBox<AnnoFormtivoDTO> annoFormativoComboBox = new ComboBox<>("Anno");
    private ComboBox<RuoloDTO> ruoloComboBox = new ComboBox<>("Ruolo");
    private Span nome;
    private EventService eventService;

    private UtenteDTO utente = null;
    private ArrayList<RuoloDTO> listaRuoli = null;
    private ArrayList<AnnoFormtivoDTO> listaAnni = null;
    private RuoloDTO ruoloSelected = null;


    public NavbarComponent(EventService eventService) {
        Store store = VaadinSession.getCurrent().getAttribute(Store.class);
        this.eventService = eventService;
        this.utente = store.utente;
        this.listaRuoli = this.utente.getRoles();
        this.listaAnni = this.utente.getAnni();
        this.ruoloSelected = store.ruoloSelected;

        buildUI();
        addListener();

    }

    private void buildUI() {

        ruoloComboBox.setItems(listaRuoli);
        ruoloComboBox.setItemLabelGenerator(RuoloDTO::getName);
        ruoloComboBox.getStyle().set("color", "white !important");
        if (this.ruoloSelected != null)
            ruoloComboBox.setValue(ruoloSelected);

        listaAnni.sort(Comparator.comparingInt(AnnoFormtivoDTO::getAnno).reversed());
        annoFormativoComboBox.setItems(listaAnni);
        annoFormativoComboBox.setItemLabelGenerator(AnnoFormtivoDTO::getDescrizione);
        annoFormativoComboBox.getStyle().set("color", "white !important");
        annoFormativoComboBox.setValue(listaAnni.get(0));


        getStyle().set("background", "royalblue")
                .set("color", "white").
                set("border-radius", "0px 0px 10px 10px");
        setWidthFull();
        setPadding(true);
        setSpacing(true);
        setMargin(false);
        setDefaultVerticalComponentAlignment(Alignment.CENTER);

        // Titolo
        Span title = new Span("Ge.Co.");
        title.getStyle().set("font-size", "20px").set("font-weight", "bold");
        title.setWidth("300px");
        // Label con ID utente
        nome = new Span(utente.getName() + " " + utente.getSurname());

        Icon iconNotification = VaadinIcon.BELL_O.create();
        iconNotification.setColor("white");
        // Layout per allineare gli elementi a destra
        HorizontalLayout rightLayout = new HorizontalLayout(annoFormativoComboBox, ruoloComboBox, nome, iconNotification);
        rightLayout.setWidthFull();
        rightLayout.setJustifyContentMode(JustifyContentMode.END);
        rightLayout.setAlignItems(Alignment.BASELINE);
        // Aggiunta dei componenti all'header
        add(VaadinIcon.AIRPLANE.create(), title, rightLayout);
    }


    private void addListener() {
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

    public void setAnnoFormativoBox(AnnoFormtivoDTO of) {
        this.annoFormativoComboBox.setValue(of);
    }
}
