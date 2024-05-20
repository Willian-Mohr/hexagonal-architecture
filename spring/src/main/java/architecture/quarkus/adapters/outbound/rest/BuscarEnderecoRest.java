package architecture.quarkus.adapters.outbound.rest;

import architecture.quarkus.application.core.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BuscaCep", url = "https://viacep.com.br")
public interface BuscarEnderecoRest {

    @GetMapping("/ws/{cep}/json")
    Endereco buscar(@RequestParam("cep") String cep);

}