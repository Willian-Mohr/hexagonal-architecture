package architecture.quarkus.adapters.outbound;

import architecture.quarkus.adapters.outbound.rest.BuscarEnderecoRest;
import architecture.quarkus.application.core.domain.Endereco;
import architecture.quarkus.application.ports.out.BuscarEnderecoPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class BuscarEnderecoAdapter implements BuscarEnderecoPort {

    @Inject
    @RestClient
    BuscarEnderecoRest buscarEnderecoRest;

    @Override
    public Endereco buscar(String cep) {
        return buscarEnderecoRest.buscar(cep);
    }
}