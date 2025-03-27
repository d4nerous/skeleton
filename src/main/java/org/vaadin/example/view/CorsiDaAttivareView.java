package org.vaadin.example.view;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;
import org.vaadin.example.Store;
import org.vaadin.example.Utility;
import org.vaadin.example.components.*;
import org.vaadin.example.model.AbilitazioniComplessiDTO;
import org.vaadin.example.model.CorsiDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Route(value = "corsiDaAttivare-view", layout = MainLayout.class)
@Component
@UIScope
public class CorsiDaAttivareView extends HorizontalLayout implements HasUrlParameter<Long> {

    private List<CorsiDTO> fullList = new ArrayList<>();
    private H3 title;
    private final List<AbilitazioniComplessiDTO> listaAbilitazioneComplessi;

    public CorsiDaAttivareView() {
        Store store = VaadinSession.getCurrent().getAttribute(Store.class);
        this.listaAbilitazioneComplessi = store.utente.getComplessi();

    }

    private void buildUI() {
        LeftColumnCorsiViewComponent leftColumnCorsiViewComponent = new LeftColumnCorsiViewComponent();
        HorizontalLayout mainLayout = new HorizontalLayout();
        FiltriComplessiComponent filtriComplessiComponent = new FiltriComplessiComponent();
        StatoListaCorsiComponent statoListaCorsiComponent = new StatoListaCorsiComponent();
        // Creazione del layout orizzontale
        HorizontalLayout wrapperTitle = new HorizontalLayout();

        wrapperTitle.setWidthFull(); // Imposta larghezza al 100%
        wrapperTitle.setJustifyContentMode(JustifyContentMode.CENTER); // Centra orizzontalmente
        wrapperTitle.setAlignItems(Alignment.CENTER); // Centra verticalmente
        wrapperTitle.add(title);


        Grid<CorsiDTO> grid = new Grid<>(CorsiDTO.class);
        // Impostare gli elementi da visualizzare
        grid.setItems(fullList);
        setWidthFull();
        VerticalLayout layoutDestro = new VerticalLayout();
        layoutDestro.add(filtriComplessiComponent, wrapperTitle, statoListaCorsiComponent, grid);
        layoutDestro.setHeightFull();
        layoutDestro.setWidth("80vw");
        mainLayout.setAlignItems(Alignment.START); // Allinea il contenuto verticalmente al centro
        mainLayout.setJustifyContentMode(JustifyContentMode.START);

        mainLayout.add(leftColumnCorsiViewComponent, layoutDestro);
        mainLayout.setWidthFull();
        mainLayout.setHeight("80vh");

        add(mainLayout);
    }

    private List<CorsiDTO> getMockData(Long idComplesso) {
        CorsiDTO[] corsi = Utility.loadJson2("listaCorsiDaAttivare.json", CorsiDTO[].class);
        return Arrays.stream(corsi).filter(n -> n.getIdComplesso().equals(idComplesso)).collect(Collectors.toList());
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, Long id) {
        removeAll();

        fullList = getMockData(id);
        title = new H3(this.listaAbilitazioneComplessi.stream().filter(el ->
                el.getId().equals(id)).findFirst().get().getNome()
        );
        buildUI();

    }
}
