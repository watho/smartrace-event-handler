package de.wathoserver.smartrace.smartraceeventhandler.views.about;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import de.wathoserver.smartrace.smartraceeventhandler.views.MainLayout;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.vaadin.firitin.components.RichText;

import java.io.IOException;

@PageTitle("About")
@Route(value = "about", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Slf4j
public class AboutView extends VerticalLayout {

    public AboutView() {
        setSpacing(true);
        RichText richText = new RichText();
        add(richText);
        try {
            richText.withMarkDown(new ClassPathResource("resources/about.md").getInputStream());
        } catch (IOException e) {
            richText.setText(e.getMessage());
        }
        setSizeFull();
    }

}
