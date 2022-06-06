package edu.fpdual.webservicevn.controller;

import edu.fpdual.webservicevn.model.dao.Actividad;
import edu.fpdual.webservicevn.model.manager.implement.ActividadManagerImpl;
import edu.fpdual.webservicevn.service.ActividadService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/actividad")
public class ActividadController {
  private final ActividadService actividadService;

  public ActividadController() {
    this.actividadService = new ActividadService(new ActividadManagerImpl());
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response todasActividades() throws SQLException, ClassNotFoundException {
    return Response.ok().entity(actividadService.todasActividades()).build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response buscaID(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
    return Response.ok().entity(actividadService.buscaId(id)).build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response crearActividad(Actividad actividad) throws SQLException, ClassNotFoundException {
    actividadService.nuevaActividad(actividad);
    return Response.status(201).build();
  }

  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response actualizaActividad(Actividad actividad) throws SQLException, ClassNotFoundException {
    actividadService.modificarActividad(actividad);
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response borrar(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
    actividadService.borrarActividad(id);
    return Response.ok().build();
  }
}
