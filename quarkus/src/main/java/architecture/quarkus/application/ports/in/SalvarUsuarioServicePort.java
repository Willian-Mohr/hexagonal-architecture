package architecture.quarkus.application.ports.in;

import architecture.quarkus.application.core.domain.Usuario;

public interface SalvarUsuarioServicePort {
    Usuario salvarUsuario(Usuario usuario, String cep);
}