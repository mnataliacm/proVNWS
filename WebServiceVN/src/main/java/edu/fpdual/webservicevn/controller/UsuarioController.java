package edu.fpdual.webservicevn.controller;

import edu.fpdual.proyectovn.model.dao.Usuario;
import edu.fpdual.proyectovn.model.manager.implement.UsuarioManagerImpl;
import edu.fpdual.webservicevn.service.UsuarioService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/usuario")
public class UsuarioController {
  Usuario usuario = new Usuario();
  private final UsuarioService usuarioService;

  public UsuarioController (){
    this.usuarioService = new UsuarioService(new UsuarioManagerImpl());
  }


  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response todosUsuarios() throws SQLException, ClassNotFoundException {
    return Response.ok().entity(usuarioService.todosUsuarios()).build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createCity(Usuario usuario){
    try {
      int createdId = usuarioService.nuevoUsuario(usuario);
      if(createdId > 0){
        return Response.status(201).entity(usuarioService.findById(createdId)).build();
      } else {
        return Response.status(500).entity("Internal Error During Creating The City").build();
      }
    } catch (SQLException | ClassNotFoundException e) {
      return Response.status(500).entity("Internal Error During DB Interaction").build();
    }
  }

}
