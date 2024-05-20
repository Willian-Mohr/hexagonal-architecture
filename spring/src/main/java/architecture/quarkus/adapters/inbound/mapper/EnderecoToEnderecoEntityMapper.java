package architecture.quarkus.adapters.inbound.mapper;

import architecture.quarkus.adapters.inbound.entity.EnderecoEntity;
import architecture.quarkus.application.core.domain.Endereco;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EnderecoToEnderecoEntityMapper {

    public EnderecoEntity mapper(Endereco endereco) {

        var enderecoEntity = new EnderecoEntity();

        BeanUtils.copyProperties(endereco, enderecoEntity);

        return enderecoEntity;
    }
}