package edu.fpdual.webservicevn.model.manager.implement;

import edu.fpdual.webservicevn.model.dao.Empresa;
import edu.fpdual.webservicevn.model.manager.EmpresaManager;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

// TODO: 08/06/2022 Pendiente de revisar
public class EmpresaManagerImpl implements EmpresaManager {

  @Override
  public Set<Empresa> todos(Connection con) {
    try (Statement s = con.createStatement()) {
      ResultSet resultSet = s.executeQuery("SELECT * FROM empresa ");
      Set<Empresa> empresaSet = new HashSet<>();
      resultSet.getRow();
      while (resultSet.next()) {
        Empresa empresa = new Empresa(resultSet);
        empresaSet.add(empresa);
      }
      return empresaSet;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Empresa buscaID(Connection con, Integer id) {
    String sql = "SELECT * FROM empresa WHERE IDemp = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      resultSet.beforeFirst();
      Empresa empresa = null;
      while (resultSet.next()) {
        empresa = new Empresa(resultSet);
      }
      return empresa;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean borrar(Connection con, Integer id) {
    //prepare SQL statement
    String sql = "DELETE FROM empresa WHERE IDemp = ?";

    // Create general statement
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      //Add Parameters
      ps.setInt(1, id);
      // Queries the DB
      return ps.executeUpdate() > 0;

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public int crear(Connection con, Empresa empresa) {
    //prepare SQL statement
    String sql = "INSERT INTO empresa (NomEmp) values (?)";

    // Create general statement
    try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      //Add Parameters
      ps.setString(1, empresa.getNom());
      // Queries the DB
      int affectedRows = ps.executeUpdate();
      if (affectedRows <= 0) {
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
  public boolean modificar(Connection con, Empresa empresa) {
    //prepare SQL statement
    String sql = "UPDATE empresa SET NomEmp=? WHERE IDemp = ?";

    // Create general statement
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      //Add Parameters
      ps.setString(1, empresa.getNom());
      ps.setInt(2, empresa.getId());
      // Queries the DB
      return ps.executeUpdate() > 0;

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
}
