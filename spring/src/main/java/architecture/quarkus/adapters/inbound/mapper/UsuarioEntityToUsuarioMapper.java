package architecture.quarkus.adapters.inbound.mapper;

import architecture.quarkus.adapters.inbound.entity.UsuarioEntity;
import architecture.quarkus.application.core.domain.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityToUsuarioMapper {


    public Usuario mapper(UsuarioEntity usuarioEntity) {

        var usuario = new Usuario();

        BeanUtils.copyProperties(usuarioEntity, usuario);

        return usuario;
    }
}