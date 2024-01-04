package de.wathoserver.smartrace.smartraceeventhandler.service;

import com.vaadin.flow.shared.Registration;
import org.atmosphere.cpr.Broadcaster;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

@Service
public class RaceEventsService {

    static Executor executor = Executors.newSingleThreadExecutor();

    static LinkedList<BiConsumer<String, String>> listeners = new LinkedList<>();

    public static synchronized Registration register(
            BiConsumer<String, String> listener) {
        listeners.add(listener);
        return () -> {
            synchronized (Broadcaster.class) {
                listeners.remove(listener);
            }
        };
    }

    public static synchronized void broadcast(String message, String source) {
        for (BiConsumer<String, String> listener : listeners) {
            executor.execute(() -> listener.accept(message, source));
        }
    }
}
