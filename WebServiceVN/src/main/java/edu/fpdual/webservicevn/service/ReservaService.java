package edu.fpdual.webservicevn.service;

import edu.fpdual.webservicevn.model.connector.Connector;
import edu.fpdual.webservicevn.model.dao.Empresa;
import edu.fpdual.webservicevn.model.dao.Reservas;
import edu.fpdual.webservicevn.model.manager.implement.EmpresaManagerImpl;
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
    public Empresa buscaIDres(Integer idRes) throws SQLException, ClassNotFoundException {
        try (Connection con = new Connector().getConnection()) {
            return reservasManager.buscaIDres(con, idRes);
        }
    }

    public boolean borrarReserva(Integer idRes) throws SQLException, ClassNotFoundException {
        try (Connection con =new Connector().getConnection()) {
            return reservasManager.borrar(con, idRes);
        }
    }
    public int nuevaReserva(Reservas reservas) throws SQLException, ClassNotFoundException {
        try (Connection con = new Connector().getConnection()) {
            return reservasManager.crear(con, reservas);
        }
    }
    public boolean modificarReserva(Reservas reservas) throws SQLException, ClassNotFoundException {
        try (Connection con =new Connector().getConnection()) {
            return reservasManager.modificar(con, reservas);
        }
    }
}
