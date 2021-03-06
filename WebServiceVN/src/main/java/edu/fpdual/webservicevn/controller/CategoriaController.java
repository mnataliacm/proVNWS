package edu.fpdual.webservicevn.controller;

import edu.fpdual.webservicevn.model.dao.Categoria;
import edu.fpdual.webservicevn.model.manager.implement.CategoriaManagerImpl;
import edu.fpdual.webservicevn.service.CategoriaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/categoria")
public class CategoriaController {
  private final CategoriaService categoriaService;

  public CategoriaController() {
    this.categoriaService = new CategoriaService(new CategoriaManagerImpl());
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response todasCategorias() throws SQLException, ClassNotFoundException {
    return Response.ok().entity(categoriaService.todasCategorias()).build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response buscaID(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
    return Response.ok().entity(categoriaService.buscaId(id)).build();
  }

  @GET
  @Path("/grupo/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response catConAct(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
    return Response.ok().entity(categoriaService.catConAct(id)).build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response crearCategoria(Categoria categoria) throws SQLException, ClassNotFoundException {
    categoriaService.nuevaCategoria(categoria);
    return Response.status(201).entity(categoria).build();
  }

  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response actualizaCategoria(Categoria categoria) throws SQLException, ClassNotFoundException {
    categoriaService.modificarCategoria(categoria);
    return Response.ok().entity(categoria).build();
  }

  @DELETE
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response borrar(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
    Categoria categoria = categoriaService.buscaId(id);
    categoriaService.borrarCategoria(id);
    return Response.ok().entity(categoria).build();
  }

}
