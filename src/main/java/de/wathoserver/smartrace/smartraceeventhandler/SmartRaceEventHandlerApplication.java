package de.wathoserver.smartrace.smartraceeventhandler;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Theme(value = "sr-event-notifier", variant = Lumo.DARK)
@Push
public class SmartRaceEventHandlerApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(SmartRaceEventHandlerApplication.class, args);
    }
}
