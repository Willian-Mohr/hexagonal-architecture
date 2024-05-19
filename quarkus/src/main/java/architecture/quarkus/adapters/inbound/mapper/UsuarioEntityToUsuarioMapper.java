package architecture.quarkus.adapters.inbound.mapper;

import architecture.quarkus.adapters.inbound.entity.UsuarioEntity;
import architecture.quarkus.application.core.domain.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UsuarioEntityToUsuarioMapper {

    Usuario mapper(UsuarioEntity usuario);

}
