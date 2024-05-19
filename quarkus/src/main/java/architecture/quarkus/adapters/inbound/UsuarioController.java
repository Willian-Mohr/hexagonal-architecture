package architecture.quarkus.adapters.inbound;

import architecture.quarkus.adapters.inbound.mapper.UsuarioRequestToUsuarioMapper;
import architecture.quarkus.adapters.inbound.request.UsuarioRequest;
import architecture.quarkus.application.core.domain.Usuario;
import architecture.quarkus.application.ports.in.SalvarUsuarioServicePort;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioController {

    private final SalvarUsuarioServicePort salvarUsuarioServicePort;

    private final UsuarioRequestToUsuarioMapper usuarioRequestToUsuarioMapper;

    public UsuarioController(SalvarUsuarioServicePort salvarUsuarioServicePort, UsuarioRequestToUsuarioMapper usuarioRequestToUsuarioMapper) {
        this.salvarUsuarioServicePort = salvarUsuarioServicePort;
        this.usuarioRequestToUsuarioMapper = usuarioRequestToUsuarioMapper;
    }

    @POST
    public Usuario salvarUsuario(UsuarioRequest usuarioRequest) {
        var usuario = usuarioRequestToUsuarioMapper.mapper(usuarioRequest);
        return salvarUsuarioServicePort.salvarUsuario(usuario, usuarioRequest.getCep());
    }

}