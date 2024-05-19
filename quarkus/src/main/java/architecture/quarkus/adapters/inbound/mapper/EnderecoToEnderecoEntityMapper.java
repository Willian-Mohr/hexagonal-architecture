package architecture.quarkus.adapters.inbound.mapper;

import architecture.quarkus.adapters.inbound.entity.EnderecoEntity;
import architecture.quarkus.application.core.domain.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface EnderecoToEnderecoEntityMapper {

    EnderecoEntity mapper(Endereco endereco);

}
