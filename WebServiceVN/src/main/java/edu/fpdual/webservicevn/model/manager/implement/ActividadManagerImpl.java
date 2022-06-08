package edu.fpdual.webservicevn.model.manager.implement;

import edu.fpdual.webservicevn.model.dao.Actividad;
import edu.fpdual.webservicevn.model.dao.Usuario;
import edu.fpdual.webservicevn.model.manager.ActividadManager;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ActividadManagerImpl implements ActividadManager {
  @Override
  public Set<Actividad> todos(Connection con) {
    try (Statement s = con.createStatement()) {
      ResultSet resultSet = s.executeQuery("SELECT * FROM actividad ");
      Set<Actividad> actividadSet = new HashSet<>();
      resultSet.getRow();
      while (resultSet.next()) {
        Actividad actividad = new Actividad(resultSet);
        actividadSet.add(actividad);
      }
      return actividadSet;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Actividad buscaID(Connection con, Integer id) {
    String sql = "SELECT * FROM actividad WHERE IDact = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      resultSet.next();
      return new Actividad(resultSet);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean borrar(Connection con, Integer id) {
    //prepare SQL statement
    String sql = "DELETE FROM actividad WHERE IDact = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public int crear(Connection con, Actividad actividad) {
    String sql = "INSERT INTO actividad (IDcat, IDciu, NomAct, IDemp, Horario, Info) values (?, ?, ?, ?, ?, ?)";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, actividad.getIdcat());
      ps.setInt(2, actividad.getIdciu());
      ps.setString(3, actividad.getNom());
      ps.setInt(4, actividad.getIdemp());
      ps.setString(5, actividad.getHorario());
      ps.setString(6, actividad.getInfo());
      int affectedRows = ps.executeUpdate();
      if (affectedRows <= 0) {
        return 0;
      }
      ResultSet resultSet = ps.getGeneratedKeys();
      resultSet.getRow();
      resultSet.next();
      return resultSet.getInt(1);
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }

  @Override
  public boolean modificar(Connection con, Actividad actividad) {
    String sql = "UPDATE actividad SET IDcat=?, IDciu=?, NomAct=? , IDemp=? , Horario=?, Info=? WHERE IDact = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, actividad.getIdcat());
      ps.setInt(2, actividad.getIdciu());
      ps.setString(3, actividad.getNom());
      ps.setInt(4, actividad.getIdemp());
      ps.setString(5, actividad.getHorario());
      ps.setString(6, actividad.getInfo());
      ps.setInt(7, actividad.getId());
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public Set<Actividad> ActividadesPorCiudad(Connection con, Integer idciu) {
    String sql = "SELECT * FROM actividad WHERE IDciu = ? GROUP BY NomAct";
    Set<Actividad> actividadSet = new HashSet<>();
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, idciu);
      ResultSet resultSet = ps.executeQuery();
      resultSet.getRow();
      while (resultSet.next()) {
        Actividad actividad = new Actividad(resultSet);
        actividadSet.add(actividad);
      }
      return actividadSet;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
}
