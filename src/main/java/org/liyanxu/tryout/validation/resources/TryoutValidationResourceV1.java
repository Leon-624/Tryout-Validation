package org.liyanxu.tryout.validation.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;
import org.liyanxu.tryout.validation.api.PersonalInfoApi;
import org.liyanxu.tryout.validation.api.model.Person;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(description = "Tryout Swagger", protocols = "http")
public class TryoutValidationResourceV1 {

    private final PersonalInfoApi api;

    @Inject
    public TryoutValidationResourceV1(@NonNull PersonalInfoApi api) {
        this.api = api;
    }

    @POST
    @Path("/set")
    @ApiOperation(value = "Sets a person.")
    public Response setPerson(@ApiParam Person person) {
        try {
            api.setPerson(person);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/setvalid")
    @ApiOperation(value = "Sets a person (must be valid).")
    public Response setPersonValid(@ApiParam @Valid Person person) {
        try {
            api.setPerson(person);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
