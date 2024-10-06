package jankenpon_ia.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jankenpon_ia.application.abstractions.services.RodadaService;
import jankenpon_ia.application.v1.services.RodadaServiceV1;

@Configuration
public class DependencyConfig 
{
    @Bean
    public void configurarDependencias()
    {
        configurarServices();
    }

    @Bean
    public void configurarServices()
    {
        RodadaService();
    }

    @Bean
    public RodadaService RodadaService(){ return new RodadaServiceV1(); }
}
