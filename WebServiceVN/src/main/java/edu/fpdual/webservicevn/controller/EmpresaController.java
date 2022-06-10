package edu.fpdual.webservicevn.controller;

import edu.fpdual.webservicevn.model.dao.Empresa;
import edu.fpdual.webservicevn.model.manager.implement.EmpresaManagerImpl;
import edu.fpdual.webservicevn.service.EmpresaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;



    @Path("/empresa")
    public class EmpresaController {
        private final EmpresaService empresaService;

        public EmpresaController(){
            this.empresaService = new EmpresaService(new EmpresaManagerImpl());
        }



        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response todosEmpresa() throws SQLException, ClassNotFoundException {
            return Response.ok().entity(empresaService.todosEmpresa()).build();
        }

        @GET
        @Path("/{idEmp}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response buscaID(@PathParam("idEmp") Integer id) throws SQLException, ClassNotFoundException {
            return Response.ok().entity(empresaService.buscaID(id)).build();
        }



        @POST
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response crearEmpresa(Empresa empresa) throws SQLException, ClassNotFoundException {
            empresaService.nuevaEmpresa(empresa);
            return Response.status(201).entity(empresa).build();
        }

        @PUT
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response actualizaEmpresa(Empresa empresa) throws SQLException, ClassNotFoundException {
            empresaService.modificarEmpresa(empresa);
            return Response.ok().entity(empresa).build();
        }

        @DELETE
        @Path("/{idEmp}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response borrar(@PathParam("idEmp") Integer idEmp) throws SQLException, ClassNotFoundException {
            Empresa empresa = empresaService.buscaID(idEmp);
            empresaService.borrarEmpresa(idEmp);
            return Response.ok().entity(empresa).build();
        }
}


