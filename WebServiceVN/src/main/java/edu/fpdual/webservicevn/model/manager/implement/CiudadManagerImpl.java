package edu.fpdual.webservicevn.model.manager.implement;

import edu.fpdual.webservicevn.model.dao.Ciudad;
import edu.fpdual.webservicevn.model.manager.CiudadManager;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class CiudadManagerImpl implements CiudadManager {

@Override
  public Set<Ciudad> todos(Connection con) {
    try (Statement s = con.createStatement()) {
      ResultSet resultSet = s.executeQuery("SELECT * FROM ciudad ");
      Set<Ciudad> ciudadSet = new HashSet<>();
      resultSet.getRow();
      while (resultSet.next()) {
        Ciudad ciudad = new Ciudad(resultSet);
        ciudadSet.add(ciudad);
      }
      return ciudadSet;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
@Override
  public Ciudad buscaID(Connection con, Integer id) {
    String sql = "SELECT * FROM ciudad WHERE IDciu = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      resultSet.next();
      return new Ciudad(resultSet);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean borrar(Connection con, Integer id) {
    String sql = "DELETE FROM ciudad WHERE IDciu = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public int crear(Connection con, Ciudad ciudad) {
    String sql = "INSERT INTO Ciudad (IDciu, NomCiu) values (?, ?)";
    try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      ps.setInt(1, ciudad.getId());
      ps.setString(2, ciudad.getNom());
      int affectedRows = ps.executeUpdate();
      if(affectedRows<=0){
        return 0;
      }
      ResultSet resultSet = ps.getGeneratedKeys();
      resultSet.beforeFirst();
      resultSet.next();
      return resultSet.getInt(1);
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }
  @Override
  public boolean modificar(Connection con, Ciudad ciudad) {
    //prepare SQL statement
    String sql = "UPDATE ciudad SET Idciu=?, NomCiu=? WHERE IDciu = ?";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, ciudad.getId());
      ps.setString(2, ciudad.getNom());
      ps.setInt(3, ciudad.getId());
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public String nombreCiudad(Connection con, Integer id) {
    String sql = "SELECT NomCiu FROM ciudad WHERE IDciu = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      return String.valueOf(ps.executeQuery());
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
}
