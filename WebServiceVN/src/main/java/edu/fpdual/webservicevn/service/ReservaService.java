package edu.fpdual.webservicevn.service;

import edu.fpdual.webservicevn.model.connector.Connector;
import edu.fpdual.webservicevn.model.dao.Actividad;
import edu.fpdual.webservicevn.model.dao.Reservas;
import edu.fpdual.webservicevn.model.manager.implement.ActividadManagerImpl;
import edu.fpdual.webservicevn.model.manager.implement.ReservasManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class ReservaService {
    private final ReservasManagerImpl reservasManager;

    public ReservaService(ReservasManagerImpl reservasManager) {
        this.reservasManager = reservasManager;
    }

    public Set<Reservas> todosReserva() throws SQLException, ClassNotFoundException {
        try (Connection con = new Connector().getConnection()) {
            return reservasManager.todos(con);
        }
    }


    public Reservas buscaID(Integer id) throws SQLException, ClassNotFoundException {
        try (Connection con = new Connector().getConnection()) {
            return reservasManager.buscaID(con, id);
        }
    }


    public boolean borrarReserva(Integer id) throws SQLException, ClassNotFoundException {
        try (Connection con = new Connector().getConnection()) {
            return reservasManager.borrar(con, id);
        }
    }


    public int crearReserva(Reservas reservas) throws SQLException, ClassNotFoundException {
        try (Connection con = new Connector().getConnection()) {
            return reservasManager.crear(con, reservas);
        }
    }

    public boolean modificarReserva(Reservas reservas) throws SQLException, ClassNotFoundException {
        try (Connection con = new Connector().getConnection()) {
            return reservasManager.modificar(con, reservas);
        }
    }
}








