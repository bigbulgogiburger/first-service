package org.example.firstservice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
@Slf4j
@RequiredArgsConstructor
public class FirstServiceController {


    private final Environment env;

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to First Service";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header){
      log.info(header);
      return "Hello world in First service";

    }

    @GetMapping("/check")
    public String check(HttpServletRequest request){
        log.info("Server port = {}",request.getServerPort());
        return String.format("Hi, there this is first service on Port %s", env.getProperty("local.server.port"));
    }
}
