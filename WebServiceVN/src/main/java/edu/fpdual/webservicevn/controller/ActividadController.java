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
  public Response todasActividad() throws SQLException, ClassNotFoundException {
    return Response.ok().entity(actividadService.todasActividades()).build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response buscaIdActividad(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
    return Response.ok().entity(actividadService.buscaId(id)).build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response crearActividad(Actividad actividad) {
    try {
      int creaAct = actividadService.crearActividad(actividad);
      if(creaAct > 0){
        return Response.status(201).entity(actividadService.buscaId(creaAct)).build();
      } else {
        return Response.status(500).entity("Error interno creando Actividad").build();
      }
    } catch (SQLException | ClassNotFoundException e) {
      return Response.status(500).entity("Error interno de la conexión con BBDD").build();
    }
  }

  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response actualizaActividad(Actividad actividad) {
    try {
      if (actividadService.modificarActividad(actividad)) {
        return Response.status(200).entity(actividadService.buscaId(actividad.getId())).build();
      } else {
        return Response.status(500).entity("Error interno actualizando Actividad").build();
      }
    } catch (SQLException | ClassNotFoundException e) {
      return Response.status(500).entity("Error interno de la conexión con BBDD").build();
    }
  }

  @DELETE
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response borrarActividad(@PathParam("id") Integer id)  {
    try {
      Actividad borradoAct = actividadService.buscaId(id);
      if (borradoAct != null) {
        if (actividadService.borrarActividad(id)) {
          return Response.status(200).entity(borradoAct).build();
        } else {
          return Response.status(304).entity("Actividad no ha sido borrada").build();
        }
      } else {
        return Response.status(404).entity("Actividad no encontrada").build();
      }
    } catch (SQLException | ClassNotFoundException e) {
      return Response.status(500).entity("Error interno de la conexión con BBDD").build();
    }
  }

}
