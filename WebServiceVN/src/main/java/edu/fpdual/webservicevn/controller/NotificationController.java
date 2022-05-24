package edu.fpdual.webservicevn.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/notifications")
public class NotificationController {
  @GET
  @Path("/ping")
  public Response ping() {
    return Response.ok().entity("Servicio Online").build();
  }


}
