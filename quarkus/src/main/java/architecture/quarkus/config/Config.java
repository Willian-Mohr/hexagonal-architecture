package architecture.quarkus.config;

import architecture.quarkus.adapters.outbound.BuscarEnderecoAdapter;
import architecture.quarkus.adapters.outbound.SalvarUsuarioAdapter;
import architecture.quarkus.application.core.usecases.SalvarUsuarioService;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Default;

@Dependent
public class Config {

    @Default
    public SalvarUsuarioService salvarUsuarioService(SalvarUsuarioAdapter salvarUsuarioAdapter, BuscarEnderecoAdapter buscarEnderecoAdapter) {
        return new SalvarUsuarioService(salvarUsuarioAdapter, buscarEnderecoAdapter);
    }


}
