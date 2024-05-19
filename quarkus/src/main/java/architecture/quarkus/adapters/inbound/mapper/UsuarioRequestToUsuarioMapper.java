package architecture.quarkus.adapters.inbound.mapper;

import architecture.quarkus.adapters.inbound.request.UsuarioRequest;
import architecture.quarkus.application.core.domain.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UsuarioRequestToUsuarioMapper {

    Usuario mapper(UsuarioRequest usuarioRequest);

}