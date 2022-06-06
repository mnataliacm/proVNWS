package edu.fpdual.webservicevn.model.manager.implement;

import edu.fpdual.webservicevn.model.dao.Categoria;
import edu.fpdual.webservicevn.model.manager.CategoriaManager;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class CategoriaManagerImpl implements CategoriaManager {
@Override
  public Set<Categoria> todos(Connection con) {
   try (Statement s = con.createStatement()) {
    ResultSet resultSet = s.executeQuery("SELECT * FROM categoria ");
    Set<Categoria> categoriaSet = new HashSet<>();
    resultSet.getRow();
    while (resultSet.next()) {
      Categoria categoria = new Categoria(resultSet);
      categoriaSet.add(categoria);
    }
    return categoriaSet;
  } catch (SQLException e) {
    e.printStackTrace();
    return null;
  }
}
@Override
  public ResultSet CatConAct(Connection con, int id) {
    /*try (PreparedStatement ps = (PreparedStatement) con.createStatement()) {
      ResultSet result = ps.executeQuery("SELECT DISTINCT(NomCat), COUNT(a.NomAct) AS total FROM categoria c"
          + " INNER JOIN subcategoria s ON c.IDcat = s.IDcat"
          + " INNER JOIN actividad a ON s.IDsub = a.IDsub"
          + " INNER JOIN ciudad ci ON a.IDciu = ci.IDciu"
          + " WHERE a.IDciu = ?");
      ps.setInt(1, id);
      return result;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }*/
    return null;
  }
  @Override
  public boolean borrar(Connection con, Integer id) {
    //prepare SQL statement
    String sql = "DELETE FROM categoria WHERE IDcat = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
  @Override
  public int crear(Connection con, Categoria categoria) {
    String sql = "INSERT INTO categoria (NomCat, Imagen) values (?, ?)";
    try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1, categoria.getNom());
      ps.setString(2, categoria.getImagen());
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
  public boolean modificar(Connection con, Categoria categoria) {
    String sql = "UPDATE categoria SET NomCat=?, Imagen=? WHERE IDcat = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setString(1, categoria.getNom());
      ps.setString(2, categoria.getImagen());
      ps.setInt(3, categoria.getId());
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public Categoria buscaID(Connection con, Integer id) {
    return null;
  }
}
