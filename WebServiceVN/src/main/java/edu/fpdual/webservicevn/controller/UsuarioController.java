package edu.fpdual.webservicevn.controller;

import edu.fpdual.webservicevn.model.dao.Usuario;
import edu.fpdual.webservicevn.model.manager.implement.UsuarioManagerImpl;
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

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response buscaID(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
    return Response.ok().entity(usuarioService.buscaId(id)).build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
    usuarioService.nuevoUsuario(usuario);
    return Response.status(201).build();
  }

  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response actualizaUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
    usuarioService.modificarUsuario(usuario);
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response borrar(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
    Usuario usuario = usuarioService.buscaId(id);
   usuarioService.borrarUsuario(id);
    return Response.ok().entity(usuario).build();
  }
}
