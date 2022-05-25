package edu.fpdual.webservicevn.model.manager.implement;


import edu.fpdual.webservicevn.model.manager.ReservasManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReservasManagerImpl implements ReservasManager {

    public ResultSet TodosReserva(Connection con) throws SQLException {
        try (Statement s = con.createStatement()) {
            ResultSet result = s.executeQuery("SELECT * FROM reserva ");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



}
