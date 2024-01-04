package de.wathoserver.smartrace.smartraceeventhandler.views.events;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import de.wathoserver.smartrace.smartraceeventhandler.service.RaceEventsService;
import de.wathoserver.smartrace.smartraceeventhandler.views.MainLayout;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Events")
@Route(value = "events", layout = MainLayout.class)
@Slf4j
public class RaceEventsView extends HorizontalLayout {

    Registration register;
    MessageList list;
    TextField filterField;

    public RaceEventsView() {
        setMargin(true);
        list = new MessageList();
        MessageListItem message = new MessageListItem("Test", Instant.now(), "test-ip");
        list.setItems(message);
        filterField = new TextField();
        filterField.setLabel("Filter source");
        VerticalLayout verticalLayout = new VerticalLayout(filterField);
        verticalLayout.addAndExpand(list);
        add(verticalLayout);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        final UI ui = UI.getCurrent();
        register = RaceEventsService.register((eventString, source) -> {
            if (source != null && !source.isBlank() && (filterField.getValue().isBlank() || source.contains(filterField.getValue()))) {
                //log.debug("Event received {}", eventString);
                ui.access(() -> {
                    List<MessageListItem> items = new ArrayList<>(list.getItems());
                    items.addFirst(new MessageListItem(eventString, Instant.now(), source));
                    list.setItems(items);
                });
            } else {
                log.debug("Event from {} received, but not matching filter {}", source, filterField.getValue());
            }
        });
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        super.onDetach(detachEvent);
        if (this.register != null) {
            this.register.remove();
        }
    }
}