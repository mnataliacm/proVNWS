package edu.fpdual.webservicevn.controller;

import edu.fpdual.webservicevn.model.dao.Empresa;
import edu.fpdual.webservicevn.model.dao.Reservas;
import edu.fpdual.webservicevn.model.manager.implement.EmpresaManagerImpl;
import edu.fpdual.webservicevn.model.manager.implement.ReservasManagerImpl;
import edu.fpdual.webservicevn.service.EmpresaService;
import edu.fpdual.webservicevn.service.ReservaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;





@Path("/empresa")
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(){
        this.reservaService = new ReservaService(new ReservasManagerImpl());
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response todosReserva() throws SQLException, ClassNotFoundException {
        return Response.ok().entity(reservaService.todosReserva()).build();
    }

    @GET
    @Path("/{idRes}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaIDres(@PathParam("idRes") Integer idRes) throws SQLException, ClassNotFoundException {
        return Response.ok().entity(reservaService.buscaIDres(idRes)).build();
    }



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearReserva(Reservas reservas) throws SQLException, ClassNotFoundException {
        reservaService.nuevaReserva(reservas);
        return Response.status(201).entity(reservas).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizaReserva(Reservas reservas) throws SQLException, ClassNotFoundException {
        reservaService.modificarReserva(reservas);
        return Response.ok().entity(reservas).build();
    }

    @DELETE
    @Path("/{idEmp}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("idEmp") Integer idRes) throws SQLException, ClassNotFoundException {
        Empresa empresa = reservaService.buscaIDres(idRes);
        reservaService.borrarReserva(idRes);
        return Response.ok().entity(empresa).build();
    }
}