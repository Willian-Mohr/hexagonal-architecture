package architecture.quarkus.adapters.outbound.rest;

import architecture.quarkus.application.core.domain.Endereco;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/ws")
@RegisterRestClient(baseUri = "https://viacep.com.br")
public interface BuscarEnderecoRest {

    @GET
    @Path("/{cep}/json")
    Endereco buscar(@PathParam("cep") String cep);

}