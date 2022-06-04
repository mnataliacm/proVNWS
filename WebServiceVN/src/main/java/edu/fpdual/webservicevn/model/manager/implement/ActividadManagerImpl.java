package edu.fpdual.webservicevn.model.manager.implement;

import edu.fpdual.webservicevn.model.dao.Actividad;
import edu.fpdual.webservicevn.model.manager.ActividadManager;

import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActividadManagerImpl implements ActividadManager {

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

  // TODO: 05/06/2022 arreglar
  public boolean NuevaActividad(Connection con, String nom, int idemp, int idsub, String horario, int idciu) throws SQLException {
    try (PreparedStatement ps = (PreparedStatement) con.createStatement()) {
    ResultSet resultSet = ps.executeQuery("INSERT INTO actividad (NomAct, IDemp, Horario, IDciu) VALUES ("
        + " NomAct = ?"
        + ", IDemp = ?"
        + ", Horario = ?"
        + ", IDciu = ?)");
    ps.setString(1, nom);
    ps.setInt(2, idemp);
    ps.setInt(3, idsub);
    ps.setString(4, horario);
    ps.setInt(5, idciu);
    return resultSet.rowUpdated();
  } catch (SQLException e) {
    e.printStackTrace();
    return false;
  }
}

  // TODO: 05/06/2022 arreglar
  public boolean ModificaActividad(Connection con, String nom, int idemp, int idsub, String horario, int idciu, int idact) throws SQLException {
    try (PreparedStatement ps = (PreparedStatement) con.createStatement()) {
      ResultSet resultSet = ps.executeQuery("UPDATE actividad SET "
          + "NomAct = ?"
          + ", IDemp = ?"
          + ", Horario = ?"
          + ", IDciu = ?"
          + " WHERE IDact = ?");
      ps.setString(1, nom);
      ps.setInt(2, idemp);
      ps.setInt(3, idsub);
      ps.setString(4, horario);
      ps.setInt(5, idciu);
      ps.setInt(6, idact);
      return resultSet.rowUpdated();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
@Override
  public boolean borrar(Connection con, Integer id) {
    String sql = "DELETE FROM actividad WHERE IDact = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public List ActividadesPorCiudad(Connection con, int idciu) {
// TODO: 05/06/2022 arreglar
    try (PreparedStatement ps = (PreparedStatement) con.createStatement()) {
      List<String> actividades = (List<String>) ps.executeQuery("SELECT * FROM actividad WHERE IDciu = ? GROUP BY NomAct");
      ps.setInt(1, idciu);
      return actividades;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean crear(Connection con, Actividad entity) {
    return false;
  }

  @Override
  public boolean modificar(Connection con, Actividad entity) {
    return false;
  }

  @Override
  public Actividad buscaID(Connection con, Integer id) throws ClassNotFoundException, SQLException {
    return null;
  }

}
