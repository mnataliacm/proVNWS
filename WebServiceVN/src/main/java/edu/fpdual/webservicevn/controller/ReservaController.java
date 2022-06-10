package edu.fpdual.webservicevn.controller;

import edu.fpdual.webservicevn.model.dao.Reservas;
import edu.fpdual.webservicevn.model.manager.implement.ReservasManagerImpl;
import edu.fpdual.webservicevn.service.ReservaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;





@Path("/reserva")
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
    public Response buscaIDres(@PathParam("idRes") Integer id) throws SQLException, ClassNotFoundException {
        return Response.ok().entity(reservaService.buscaID(id)).build();
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
    @Path("/{idRes}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("idRes") Integer idRes) throws SQLException, ClassNotFoundException {
        Reservas reservas = reservaService.buscaID(idRes);
        reservaService.borrarReserva(idRes);
        return Response.ok().entity(reservas).build();
    }
}