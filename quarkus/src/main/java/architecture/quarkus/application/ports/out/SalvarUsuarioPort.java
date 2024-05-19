package architecture.quarkus.application.ports.out;

import architecture.quarkus.application.core.domain.Usuario;

public interface SalvarUsuarioPort {
    Usuario salvar(Usuario usuario);
}