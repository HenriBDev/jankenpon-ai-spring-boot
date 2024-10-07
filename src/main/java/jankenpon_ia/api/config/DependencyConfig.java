package jankenpon_ia.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jankenpon_ia.application.abstractions.services.SessaoService;
import jankenpon_ia.application.v1.services.SessaoServiceV1;

@Configuration
public class DependencyConfig 
{
    @Bean
    public SessaoService SessaoService(){ return new SessaoServiceV1(); }
}
