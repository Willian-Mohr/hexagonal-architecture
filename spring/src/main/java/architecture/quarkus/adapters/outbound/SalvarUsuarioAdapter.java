package architecture.quarkus.adapters.outbound;

import architecture.quarkus.adapters.inbound.mapper.EnderecoToEnderecoEntityMapper;
import architecture.quarkus.adapters.inbound.mapper.UsuarioEntityToUsuarioMapper;
import architecture.quarkus.adapters.inbound.mapper.UsuarioToUsuarioEntityMapper;
import architecture.quarkus.adapters.outbound.repository.UsuarioRepository;
import architecture.quarkus.application.core.domain.Usuario;
import architecture.quarkus.application.ports.out.SalvarUsuarioPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SalvarUsuarioAdapter implements SalvarUsuarioPort {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioToUsuarioEntityMapper usuarioToUsuarioEntityMapper;
    private final UsuarioEntityToUsuarioMapper usuarioToUsuarioEntitymMapper;
    private final EnderecoToEnderecoEntityMapper enderecoToEnderecoEntityMapper;

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        var usuarioEntity = usuarioToUsuarioEntityMapper.mapper(usuario);
        var enderecoEntity = enderecoToEnderecoEntityMapper.mapper(usuario.getEndereco());
        usuarioEntity.setEndereco(enderecoEntity);
        usuarioRepository.saveAndFlush(usuarioEntity);
        return usuarioToUsuarioEntitymMapper.mapper(usuarioEntity);
    }
}