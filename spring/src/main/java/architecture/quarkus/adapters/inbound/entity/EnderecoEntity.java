package architecture.quarkus.adapters.inbound.entity;

import architecture.quarkus.application.core.domain.Endereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EnderecoEntity extends Endereco {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

}