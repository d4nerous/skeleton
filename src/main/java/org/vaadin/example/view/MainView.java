package org.vaadin.example.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.vaadin.example.Store;
import org.vaadin.example.events.AnnoSelectionEvent;
import org.vaadin.example.events.RuoloSelectionEvent;
import org.vaadin.example.model.RuoloDTO;
import org.vaadin.example.service.EventService;

import java.util.List;

@Route(value = "",layout = MainLayout.class)
@Component
@UIScope
public class MainView extends VerticalLayout {
    private final EventService eventService;
    List<RuoloDTO> listaRuoli;
    Store store;
    @Autowired
    public MainView(EventService eventService) {
        Store store = VaadinSession.getCurrent().getAttribute(Store.class);
        this.eventService=eventService;
        this.store=store;
        this.listaRuoli=store.utente.getRoles();
        if(store.ruoloSelected==null){
            openRoleSelectionDialog();
        }

//todo trovare il modo per selezionare all'inizio la dialog e poi caricare la navbar con i dati preselezionati


        setSizeFull();

    }
    private void openRoleSelectionDialog() {


        Dialog roleDialog = new Dialog();
        roleDialog.setCloseOnEsc(false);
        roleDialog.setCloseOnOutsideClick(false);

        // ComboBox con i ruoli disponibili
        ComboBox<RuoloDTO> ruoloComboBox = new ComboBox<>("Seleziona il tuo ruolo");
        ruoloComboBox.setItems(listaRuoli);
        ruoloComboBox.setItemLabelGenerator(RuoloDTO::getName);

        // Bottone per confermare la selezione
        Button confirmButton = new Button("Conferma", event -> {
            if (ruoloComboBox.getValue() != null) {
                ruoloComboBox.addValueChangeListener(r -> {
                    if (r.getValue() != null) {
                        this.eventService.publishRuoloChange(r.getValue());
                        this.store.ruoloSelected=r.getValue();

                    }
                });
                roleDialog.close();

            }
        });

        // Aggiungere elementi al Dialog e mostrarlo
        roleDialog.add(new VerticalLayout(ruoloComboBox, confirmButton));
        roleDialog.open();
    }

    @EventListener
    public void handleRuoloSelection(RuoloSelectionEvent event) {
        // Seleziona se la colonna sinistra deve essere visibile o meno
        if("Operatore".equalsIgnoreCase(event.getSelectedValue().getName())){
            UI.getCurrent().navigate("operatore-view");
        }else if("Altro".equalsIgnoreCase(event.getSelectedValue().getName())){
            UI.getCurrent().navigate("altro-view");
        }else{
            UI.getCurrent().navigate("");
        }



    }
    @EventListener
    public void handleAnnoSelection(AnnoSelectionEvent event) {
        String anno = event.getSelectedValue();
    }
}
