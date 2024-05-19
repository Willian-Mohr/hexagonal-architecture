package architecture.quarkus.adapters.outbound;

import architecture.quarkus.adapters.inbound.mapper.EnderecoToEnderecoEntityMapper;
import architecture.quarkus.adapters.inbound.mapper.UsuarioEntityToUsuarioMapper;
import architecture.quarkus.adapters.inbound.mapper.UsuarioToUsuarioEntityMapper;
import architecture.quarkus.adapters.outbound.repository.UsuarioRepository;
import architecture.quarkus.application.core.domain.Usuario;
import architecture.quarkus.application.ports.out.SalvarUsuarioPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class SalvarUsuarioAdapter implements SalvarUsuarioPort {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    UsuarioToUsuarioEntityMapper usuarioToUsuarioEntityMapper;

    @Inject
    UsuarioEntityToUsuarioMapper usuarioToUsuarioEntitymMapper;

    @Inject
    EnderecoToEnderecoEntityMapper enderecoToEnderecoEntityMapper;

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        var usuarioEntity = usuarioToUsuarioEntityMapper.mapper(usuario);
        var enderecoEntity = enderecoToEnderecoEntityMapper.mapper(usuario.getEndereco());
        usuarioEntity.setEndereco(enderecoEntity);
        usuarioRepository.persist(usuarioEntity);
        return usuarioToUsuarioEntitymMapper.mapper(usuarioEntity);
    }
}