package jankenpon_ia.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jankenpon_ia.application.abstractions.services.JogadaService;
import jankenpon_ia.application.v1.services.JogadaServiceV1;

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
        jogadaService();
    }

    @Bean
    public JogadaService jogadaService(){ return new JogadaServiceV1(); }
}
