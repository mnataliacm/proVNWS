package edu.fpdual.webservicevn.controller;

import edu.fpdual.webservicevn.model.dao.Actividad;
import edu.fpdual.webservicevn.model.dao.Reservas;
import edu.fpdual.webservicevn.model.manager.implement.ActividadManagerImpl;
import edu.fpdual.webservicevn.model.manager.implement.ReservasManagerImpl;
import edu.fpdual.webservicevn.service.ActividadService;
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
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaIDreserva(@PathParam("id") Integer id) throws SQLException, ClassNotFoundException {
        return Response.ok().entity(reservaService.buscaID(id)).build();
    }



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearReserva(Reservas reservas) {
        try {
            int creaRes = reservaService.crearReserva(reservas);
            if(creaRes > 0){
                return Response.status(201).entity(reservaService.buscaID(creaRes)).build();
            } else {
                return Response.status(500).entity("Error interno creando Reserva").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Error interno de la conexión con BBDD").build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizaReserva(Reservas reservas) {
        try {
            if (reservaService.modificarReserva(reservas)) {
                return Response.status(200).entity(reservaService.buscaID(reservas.getIdRes())).build();
            } else {
                return Response.status(500).entity("Error interno actualizando Reserva").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Error interno de la conexión con BBDD").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrarReserva(@PathParam("id") Integer id)  {
        try {
            Reservas borradoRes = reservaService.buscaID(id);
            if (borradoRes != null) {
                if (reservaService.borrarReserva(id)) {
                    return Response.status(200).entity(borradoRes).build();
                } else {
                    return Response.status(304).entity("Reserva no ha sido borrada").build();
                }
            } else {
                return Response.status(404).entity("Reserva no encontrada").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Error interno de la conexión con BBDD").build();
        }
    }
}










