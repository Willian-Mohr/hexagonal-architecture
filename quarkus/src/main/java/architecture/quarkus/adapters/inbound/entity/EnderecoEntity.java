package architecture.quarkus.adapters.inbound.entity;

import architecture.quarkus.application.core.domain.Endereco;
import jakarta.persistence.*;

@Entity
public class EnderecoEntity extends Endereco {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}