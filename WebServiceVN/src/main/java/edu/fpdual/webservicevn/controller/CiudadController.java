package edu.fpdual.webservicevn.controller;

import edu.fpdual.webservicevn.model.dao.Ciudad;
import edu.fpdual.webservicevn.model.dao.Usuario;
import edu.fpdual.webservicevn.model.manager.implement.CiudadManagerImpl;
import edu.fpdual.webservicevn.service.CiudadService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/ciudad")
public class CiudadController {
  Ciudad ciudad = new Ciudad();
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
  public Response buscaNombre(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
    return Response.ok().entity(ciudadService.nombreCiudad(id)).build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response crearCiudad(Ciudad ciudad) throws SQLException, ClassNotFoundException {
    ciudadService.nuevaCiudad(ciudad);
    return Response.status(201).build();
  }

  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response actualizaUsuario(Ciudad ciudad) throws SQLException, ClassNotFoundException {
    ciudadService.modificarCiudad(ciudad);
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response borrar(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
    ciudadService.borrarCiudad(id);
    return Response.ok().build();
  }


}
