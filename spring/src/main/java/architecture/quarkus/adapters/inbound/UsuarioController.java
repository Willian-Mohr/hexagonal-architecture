package architecture.quarkus.adapters.inbound;

import architecture.quarkus.adapters.inbound.mapper.UsuarioRequestToUsuarioMapper;
import architecture.quarkus.adapters.inbound.request.UsuarioRequest;
import architecture.quarkus.application.core.domain.Usuario;
import architecture.quarkus.application.ports.in.SalvarUsuarioServicePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final SalvarUsuarioServicePort salvarUsuarioServicePort;

    private final UsuarioRequestToUsuarioMapper usuarioRequestToUsuarioMapper;

    @PostMapping
    public Usuario salvarUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        var usuario = usuarioRequestToUsuarioMapper.mapper(usuarioRequest);
        return salvarUsuarioServicePort.salvarUsuario(usuario, usuarioRequest.getCep());
    }

}