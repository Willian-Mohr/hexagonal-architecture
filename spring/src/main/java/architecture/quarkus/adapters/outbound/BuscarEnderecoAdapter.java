package architecture.quarkus.adapters.outbound;

import architecture.quarkus.adapters.outbound.rest.BuscarEnderecoRest;
import architecture.quarkus.application.core.domain.Endereco;
import architecture.quarkus.application.ports.out.BuscarEnderecoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarEnderecoAdapter implements BuscarEnderecoPort {

    private final BuscarEnderecoRest buscarEnderecoRest;

    @Override
    public Endereco buscar(String cep) {

        return buscarEnderecoRest.buscar(cep);
    }
}