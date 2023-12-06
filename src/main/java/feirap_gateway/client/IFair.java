package feirap_gateway.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import feirap_gateway.model.Fair;
import feirap_gateway.model.FairFilter;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RegisterRestClient(baseUri = "http://localhost:8080")
public interface IFair {

    @GET
    @Path("/api/v1/fairs")   
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fair> findAll();

    @POST
    @Path("/api/v1/fairs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Fair create(Fair inFair);


    @POST
    @Path("/api/v1/fairs/search")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Fair> filterFair(FairFilter filter);

    @PUT
    @Path("/api/v1/fairs/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Fair fair);

    @DELETE
    @Path("/api/v1/fairs/{id}")
    public void delete(@PathParam("id") Long id);
    
}
