package de.wathoserver.smartrace.smartraceeventhandler.restcontroller;

import de.wathoserver.smartrace.smartraceeventhandler.service.RaceEventsService;
import jakarta.servlet.ServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Slf4j
public class RestController {


    @GetMapping
    public Mono<String> greet() {
        return Mono.just("Hello World!");
    }

    @PostMapping
    public Mono<String> postEvent(@RequestBody String requestBody, ServletRequest request) {
        log.info("Event received.");
        //log.info("Request {}", request.get);
        log.debug("Payload: {}", requestBody);
        RaceEventsService.broadcast(requestBody, request.getRemoteHost());
        return Mono.just(requestBody);
    }
}
