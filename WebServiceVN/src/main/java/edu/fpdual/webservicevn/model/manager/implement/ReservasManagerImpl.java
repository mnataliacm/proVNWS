package edu.fpdual.webservicevn.model.manager.implement;

import edu.fpdual.webservicevn.model.dao.Reservas;
import edu.fpdual.webservicevn.model.manager.ReservasManager;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ReservasManagerImpl implements ReservasManager {
  @Override
  public Set<Reservas> todos(Connection con) {
    try (Statement s = con.createStatement()) {
      ResultSet resultSet = s.executeQuery("SELECT * FROM reserva ");
      Set<Reservas> reservasSet = new HashSet<>();
      resultSet.getRow();
      while (resultSet.next()) {
        Reservas reservas = new Reservas(resultSet);
        reservasSet.add(reservas);
      }
      return reservasSet;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Reservas buscaID(Connection con, Integer id) {
    String sql = "SELECT * FROM reserva WHERE IDres = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      resultSet.next();
      return new Reservas(resultSet);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean borrar(Connection con, Integer id) {
    String sql = "DELETE FROM reserva WHERE IDres = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public int crear(Connection con, Reservas reservas) {
    String sql = "INSERT INTO reserva (IDusu, IDact, Fecha, Hora) values (?, ?, ?, ?)";
    try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      ps.setInt(1, reservas.getIdUsu());
      ps.setInt(2, reservas.getIdAct());
      ps.setDate(3, reservas.getFecha());
      ps.setTime(4, reservas.getHora());

      int affectedRows = ps.executeUpdate();
      if (affectedRows <= 0) {
        return 0;
      }
      ResultSet resultSet = ps.getGeneratedKeys();
      resultSet.next();
      return resultSet.getInt(1);
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }

  @Override
  public boolean modificar(Connection con, Reservas reservas) {
    String sql = "UPDATE reserva SET IDusu=?, IDact=?, Fecha=? , Hora=? WHERE IDres = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, reservas.getIdUsu());
      ps.setInt(2, reservas.getIdAct());
      ps.setDate(3, reservas.getFecha());
      ps.setTime(4, reservas.getHora());
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

}







