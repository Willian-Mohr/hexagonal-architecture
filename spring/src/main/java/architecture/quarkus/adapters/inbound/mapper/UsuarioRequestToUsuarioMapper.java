package architecture.quarkus.adapters.inbound.mapper;

import architecture.quarkus.adapters.inbound.request.UsuarioRequest;
import architecture.quarkus.application.core.domain.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UsuarioRequestToUsuarioMapper {

    public Usuario mapper(UsuarioRequest usuarioRequest) {

        var usuario = new Usuario();

        BeanUtils.copyProperties(usuarioRequest, usuario);

        return usuario;
    }
}