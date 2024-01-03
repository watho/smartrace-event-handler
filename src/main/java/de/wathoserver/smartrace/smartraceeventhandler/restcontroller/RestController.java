package de.wathoserver.smartrace.smartraceeventhandler.restcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
@CrossOrigin("*")
@Slf4j
public class RestController {

    private String lastPayload;

    @GetMapping
    public Mono<String> greet(){
        return Mono.just("Hello World!\n"+lastPayload);
    }
    @PostMapping
    public Mono<String> postEvent(@RequestBody String requestBody){
      log.info("Post received.");
      log.info("Payload: {}", requestBody);
      lastPayload = requestBody;
      return Mono.just(requestBody);
    }
}
