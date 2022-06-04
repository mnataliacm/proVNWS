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

  public ActividadController(){
    this.actividadService = new ActividadService(new ActividadManagerImpl());
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response todos() throws SQLException, ClassNotFoundException {
    return Response.ok().entity(actividadService.todasActividades()).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{id}")
  public Response buscaId(@PathParam("id") Integer id) {
    try {
      if (id == null) {
        return Response.status(400).entity("Parámetros Incorrectos").build();
      } else {
        return Response.ok().entity(actividadService.buscaId(id)).build();
      }
    } catch (SQLException | ClassNotFoundException e) {
      return Response.status(500).entity("Internal Error During DB Interaction").build();
    }
  }

 /* @POST
  @Path("/post")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response crear(int idcat, int idciu, String nom, int idemp, String horario, String info) {
    Actividad a = new Actividad();
    a.setIdcat(idcat);
    a.setIdciu(idciu);
    a.setNom(nom);
    a.setIdemp(idemp);
    a.setHorario(horario);
    a.setInfo(info);
    /*try {
      int nuevo = actividadService.nuevaActividad();
    if (nuevo > 0) {
      return Response.status(201).entity(actividadService.buscaId(nuevo)).build();
    } else {
      return Response.status(500).entity("Internal Error During Creating The User").build();
    }
  } catch (SQLException | ClassNotFoundException e) {
      return Response.status(500).entity("Internal Error During DB Interaction").build();
    }
  }*/

  @PUT
  @Path("/put/{id}{nom}{ape}{pass}{email}{movil}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response modificar(Actividad actividad){
    try {
      if(actividadService.modificarUsuario(actividad)){
        return Response.status(200).entity(actividadService.buscaId(Integer.valueOf("id"))).build();
      } else {
        return Response.status(500).entity("Internal Error During User Update").build();
      }
    } catch (SQLException | ClassNotFoundException e) {
      return Response.status(500).entity("Internal Error During DB Interaction").build();
    }
  }

  @DELETE
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response borrar(@PathParam("id") Integer id) {
    try {
      Actividad borraActividad = actividadService.buscaId(id);
      if (borraActividad != null) {
        if (actividadService.borrarUsuario(id)) {
          return Response.status(200).entity(borraActividad).build();
        }else{
          return Response.status(304).entity("El usuarios no se ha borrado").build();
        }
      } else{
        return Response.status(404).entity("Usuario no encontrado").build();
      }
    } catch (SQLException | ClassNotFoundException e) {
      return Response.status(500).entity("Internal Error During DB Interaction").build();
    }
  }
}
