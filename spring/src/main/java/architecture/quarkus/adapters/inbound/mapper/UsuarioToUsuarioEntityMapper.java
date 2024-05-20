package architecture.quarkus.adapters.inbound.mapper;

import architecture.quarkus.adapters.inbound.entity.UsuarioEntity;
import architecture.quarkus.application.core.domain.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UsuarioToUsuarioEntityMapper {

    public UsuarioEntity mapper(Usuario usuario) {

        var usuarioEntity = new UsuarioEntity();

        BeanUtils.copyProperties(usuario, usuarioEntity);

        return usuarioEntity;

    }
}