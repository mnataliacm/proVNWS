package edu.fpdual.webservicevn.model.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ReservasManager {
    /**
     * Busca todos las reservas
     * @param con conexión a BBDD
     * @return {@code Set} of {@code Usuario}
     */
    public ResultSet todosReserva(Connection con) throws SQLException;
}
