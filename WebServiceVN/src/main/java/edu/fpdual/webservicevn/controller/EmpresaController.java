package edu.fpdual.webservicevn.controller;

import edu.fpdual.webservicevn.model.dao.Actividad;
import edu.fpdual.webservicevn.model.dao.Empresa;
import edu.fpdual.webservicevn.model.manager.implement.ActividadManagerImpl;
import edu.fpdual.webservicevn.model.manager.implement.EmpresaManagerImpl;
import edu.fpdual.webservicevn.service.ActividadService;
import edu.fpdual.webservicevn.service.EmpresaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/empresa")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController() {
        this.empresaService = new EmpresaService(new EmpresaManagerImpl());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response todasEmpresa() throws SQLException, ClassNotFoundException {
        return Response.ok().entity(empresaService.todasEmpresa()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaIdEmpresa(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
        return Response.ok().entity(empresaService.buscaID(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearEmpresa(Empresa empresa) {
        try {
            int creaEmp = empresaService.crearEmpresa(empresa);
            if(creaEmp > 0){
                return Response.status(201).entity(empresaService.buscaID(creaEmp)).build();
            } else {
                return Response.status(500).entity("Error interno creando Empresa").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Error interno de la conexión con BBDD").build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizaEmpresa(Empresa empresa) {
        try {
            if (empresaService.modificarEmpresa(empresa)) {
                return Response.status(200).entity(empresaService.buscaID(empresa.getId())).build();
            } else {
                return Response.status(500).entity("Error interno actualizando Empresa").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Error interno de la conexión con BBDD").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrarEmpresa(@PathParam("id") Integer id)  {
        try {
            Empresa borradoEmp = empresaService.buscaID(id);
            if (borradoEmp != null) {
                if (empresaService.borrarEmpresa(id)) {
                    return Response.status(200).entity(borradoEmp).build();
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


