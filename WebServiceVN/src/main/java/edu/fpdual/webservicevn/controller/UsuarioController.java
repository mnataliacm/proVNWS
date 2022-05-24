package edu.fpdual.webservicevn.controller;

import edu.fpdual.proyectovn.model.dao.Usuario;
import edu.fpdual.proyectovn.model.manager.implement.UsuarioManagerImpl;
import edu.fpdual.webservicevn.service.UsuarioService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
  @Path("/listado")
  @Produces(MediaType.APPLICATION_JSON)
  public Response todosUsuarios() throws SQLException, ClassNotFoundException {
    return Response.ok().entity(usuarioService.todosUsuarios()).build();
  }

}
