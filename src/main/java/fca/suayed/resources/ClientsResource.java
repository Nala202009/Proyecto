package resources;

import dto.ClientDto;
import dto.ResponseDto;
import fca.suayed.dal.StoreDal;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.util.List;

@Path("/clients")
public class ClientsResource {

    @Inject
    StoreDal storeDal;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all clients")
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Clients fetched successfully", content = @org.eclipse.microprofile.openapi.annotations.media.Content(mediaType = MediaType.APPLICATION_JSON))
    })
    public Response getClients() {
        ResponseDto<List<ClientDto>> responseDto = storeDal.getClients();
        return Response.ok(responseDto).build();
    }
}
