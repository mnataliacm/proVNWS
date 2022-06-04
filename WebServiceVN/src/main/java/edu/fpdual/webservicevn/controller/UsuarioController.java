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
  private final UsuarioService usuarioService;

  public UsuarioController (){
    this.usuarioService = new UsuarioService(new UsuarioManagerImpl());
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response todos() throws SQLException, ClassNotFoundException {
    return Response.ok().entity(usuarioService.todosUsuarios()).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{id}")
  public Response buscaId(@PathParam("id") Integer id) {
    try {
      if (id == null) {
        return Response.status(400).entity("Parámetros Incorrectos").build();
      } else {
        return Response.ok().entity(usuarioService.buscaId(id)).build();
      }
    } catch (SQLException | ClassNotFoundException e) {
      return Response.status(500).entity("Internal Error During DB Interaction").build();
    }
  }

  @POST
  @Path("/post")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response crear(String nom, String ape, String pass, String email, String movil) {
    Usuario u = new Usuario();
    u.setNom(nom);
    u.setApe(ape);
    u.setPass(pass);
    u.setEmail(email);
    u.setMovil(movil);
    try {
      int nuevo = usuarioService.nuevoUsuario(u);
    if (nuevo > 0) {
      return Response.status(201).entity(usuarioService.buscaId(nuevo)).build();
    } else {
      return Response.status(500).entity("Internal Error During Creating The User").build();
    }
  } catch (SQLException | ClassNotFoundException e) {
      return Response.status(500).entity("Internal Error During DB Interaction").build();
    }
  }

  @PUT
  @Path("/put/{id}{nom}{ape}{pass}{email}{movil}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response modificar(Usuario usuario){
    try {
      if(usuarioService.modificarUsuario(usuario)){
        return Response.status(200).entity(usuarioService.buscaId(Integer.valueOf("id"))).build();
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
      Usuario borraUsuario = usuarioService.buscaId(id);
      if (borraUsuario != null) {
        if (usuarioService.borrarUsuario(id)) {
          return Response.status(200).entity(borraUsuario).build();
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
