package org.vaadin.example.listener;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.page.LoadingIndicatorConfiguration;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import org.springframework.context.ApplicationContext;
import org.vaadin.example.Store;

public class UiServiceInitListener  implements VaadinServiceInitListener {

    private final ApplicationContext applicationContext;

    public UiServiceInitListener(ApplicationContext context) {
        this.applicationContext=context;
    }

    @Override
    public void serviceInit(ServiceInitEvent serviceInitEvent) {
        serviceInitEvent.getSource().addUIInitListener( uiInitEvent -> {


            // servirà per selezionare un ruolo appena parte l'app
           Store store =applicationContext.getBean(Store.class);
            uiInitEvent.getUI().addBeforeEnterListener(event->{

            });
        });
    }
}
