package edu.fpdual.webservicevn.controller;

import edu.fpdual.webservicevn.model.dao.Ciudad;
import edu.fpdual.webservicevn.model.manager.implement.CiudadManagerImpl;
import edu.fpdual.webservicevn.service.CiudadService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/ciudad")
public class CiudadController {
  private final CiudadService ciudadService;

  public CiudadController() {
    this.ciudadService = new CiudadService(new CiudadManagerImpl());
  }

@GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response todasCiudades() throws SQLException, ClassNotFoundException {
    return Response.ok().entity(ciudadService.todasCiudades()).build();
}

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response buscaID(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
    return Response.ok().entity(ciudadService.buscaID(id)).build();
  }

  @GET
  @Path("/grupo/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response ciuConAct(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
    return Response.ok().entity(ciudadService.ciuConAct(id)).build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response crearCiudad(Ciudad ciudad) throws SQLException, ClassNotFoundException {
    ciudadService.nuevaCiudad(ciudad);
    return Response.status(201).entity(ciudad).build();
  }

  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response actualizaUsuario(Ciudad ciudad) throws SQLException, ClassNotFoundException {
    ciudadService.modificarCiudad(ciudad);
    return Response.ok().entity(ciudad).build();
  }

  @DELETE
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response borrar(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
    Ciudad ciudad = ciudadService.buscaID(id);
    ciudadService.borrarCiudad(id);
    return Response.ok().entity(ciudad).build();
  }

}
