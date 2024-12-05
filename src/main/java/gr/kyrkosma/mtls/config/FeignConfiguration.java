package gr.kyrkosma.mtls.config;

import feign.Client;
import feign.Feign;
import feign.Retryer;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class FeignConfiguration {

    @Value("${external-services.badssl.client-cert-path}")
    private String clientCertPath;

    @Value("${external-services.badssl.client-cert-password}")
    private String clientCertPassword;


    @Bean
    public Feign.Builder feignBuilder() throws UnrecoverableKeyException, CertificateException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        return Feign.builder()
                .retryer(Retryer.NEVER_RETRY)
                .client(new Client.Default(sslSocketFactory(), null));
    }

    SSLSocketFactory sslSocketFactory() throws IOException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        char[] pass = clientCertPassword.toCharArray();

        SSLContext sslContext = SSLContexts.custom()
                .loadKeyMaterial(ResourceUtils.getFile(clientCertPath), pass, pass)
                .build();
        return sslContext.getSocketFactory();
    }

}
