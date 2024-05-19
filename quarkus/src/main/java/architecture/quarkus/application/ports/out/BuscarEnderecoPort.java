package architecture.quarkus.application.ports.out;

import architecture.quarkus.application.core.domain.Endereco;

public interface BuscarEnderecoPort {
    Endereco buscar(String cep);
}