package org.vaadin.example.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.vaadin.example.components.RuoloSelectionEvent;

@Service
public class EventService {
    private final ApplicationEventPublisher eventPublisher;

    public EventService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishRuoloChange(String value) {
        eventPublisher.publishEvent(new RuoloSelectionEvent(this, value));
    }
}