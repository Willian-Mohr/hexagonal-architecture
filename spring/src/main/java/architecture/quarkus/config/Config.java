package architecture.quarkus.config;

import architecture.quarkus.adapters.outbound.BuscarEnderecoAdapter;
import architecture.quarkus.adapters.outbound.SalvarUsuarioAdapter;
import architecture.quarkus.application.core.usecases.SalvarUsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public SalvarUsuarioService salvarUsuarioService(SalvarUsuarioAdapter salvarUsuarioAdapter, BuscarEnderecoAdapter buscarEnderecoAdapter) {
        return new SalvarUsuarioService(salvarUsuarioAdapter, buscarEnderecoAdapter);
    }

}