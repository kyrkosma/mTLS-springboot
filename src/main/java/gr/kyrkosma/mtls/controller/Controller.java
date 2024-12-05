package gr.kyrkosma.mtls.controller;

import gr.kyrkosma.mtls.service.FeignClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {

    private final FeignClientService feignClientService;

    public Controller(FeignClientService feignClientService) {
        this.feignClientService = feignClientService;
    }

    @GetMapping("")
    public ResponseEntity<String> getResponse() {
        return feignClientService.getBadsslResponse();
    }
}
