package feirap_gateway.controller;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import feirap_gateway.client.IFair;
import feirap_gateway.model.Fair;
import feirap_gateway.model.FairFilter;
import jakarta.inject.Inject;
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

@Path("/gateway/fairs")
public class FairController {

    @Inject
    @RestClient
    IFair client;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fair> list() {
        return client.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Fair createFair(Fair inFair) {
        return client.create(inFair);
    }


    @POST
    @Path("/filter")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Fair> filterFair(FairFilter filter) {
        return client.filterFair(filter);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Fair fair) {
        return client.update(id, fair);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        client.delete(id);
    }
    
}
