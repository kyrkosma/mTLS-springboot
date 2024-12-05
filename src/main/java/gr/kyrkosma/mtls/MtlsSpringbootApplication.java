package gr.kyrkosma.mtls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MtlsSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MtlsSpringbootApplication.class, args);
    }

}
