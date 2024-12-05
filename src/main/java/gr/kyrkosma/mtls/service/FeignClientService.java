package gr.kyrkosma.mtls.service;

import gr.kyrkosma.mtls.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(
        name = "BadsslFeignClient",
        url = "${external-services.badssl.base-url}",
        configuration = FeignConfiguration.class
)
public interface FeignClientService {
    @GetMapping(value = "/")
    ResponseEntity<String> getBadsslResponse();
}
