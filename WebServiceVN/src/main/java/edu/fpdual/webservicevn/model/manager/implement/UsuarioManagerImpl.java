package edu.fpdual.webservicevn.model.manager.implement;


import edu.fpdual.webservicevn.model.dao.Usuario;
import edu.fpdual.webservicevn.model.manager.UsuarioManager;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UsuarioManagerImpl implements UsuarioManager {

  @Override
  public Set<Usuario> todos(Connection con) {
    try (Statement s = con.createStatement()) {
      ResultSet resultSet = s.executeQuery("SELECT * FROM usuario");
      Set<Usuario> usuarioSet = new HashSet<>();
      resultSet.getRow();
      while (resultSet.next()) {
        Usuario usuario = new Usuario(resultSet);
        usuarioSet.add(usuario);
      }
      return usuarioSet;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Usuario buscaID(Connection con, Integer id) throws SQLException {
    String sql = "SELECT * FROM usuario WHERE IDusu = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      resultSet.beforeFirst();
      Usuario usuario = null;
      while (resultSet.next()) {
        usuario = new Usuario(resultSet);
      }
      return usuario;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean borrar(Connection con, Integer id) {
    //prepare SQL statement
    String sql = "DELETE FROM usuario WHERE IDusu = ?";

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
  public int crear(Connection con, Usuario usuario) {
    //prepare SQL statement
    String sql = "INSERT INTO usuario (NomUsu, ApeUsu, PassUsu, Email, Movil) values (?, ?, ?, ?, ?)";

    // Create general statement
    try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      //Add Parameters
      ps.setString(1, usuario.getNom());
      ps.setString(2, usuario.getApe());
      ps.setString(3, usuario.getPass());
      ps.setString(3, usuario.getEmail());
      ps.setString(3, usuario.getMovil());
      // Queries the DB
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
  public boolean modificar(Connection con, Usuario usuario) {
    //prepare SQL statement
    String sql = "UPDATE usuario SET NomUsu=?, ApeUsu=?, PassUsu=? , Email=? , Movil=? WHERE IDusu = ?";

    // Create general statement
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      //Add Parameters
      ps.setString(1, usuario.getNom());
      ps.setString(2, usuario.getApe());
      ps.setString(3, usuario.getPass());
      ps.setString(4, usuario.getEmail());
      ps.setString(5, usuario.getMovil());
      ps.setInt(6, usuario.getId());
      // Queries the DB
      return ps.executeUpdate() > 0;

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }




/*


  public boolean nuevoUsuario(Connection con, String nom, String ape, String pass, String email,  String movil) {
    try (PreparedStatement ps = (PreparedStatement) con.createStatement()) {
      ResultSet resultSet = ps.executeQuery("INSERT INTO usuario (NomUsu, ApeUsu, PassUsu, Email, Movil) VALUES ("
          + "NomUsu = ?"
          + ", ApeUsu = ?"
          + ", PassUsu = ?"
          + ", Email = ?"
          + ", Movil = ?)");
      ps.setString(1, nom);
      ps.setString(2, ape);
      ps.setString(3, pass);
      ps.setString(4, email);
      ps.setString(5, movil);

      return resultSet.rowInserted();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean modificarUsuario(Connection con, String nom, String ape, String email, String pass, String movil, int id) {
    try (PreparedStatement ps = (PreparedStatement) con.createStatement()) {
      ResultSet resultSet = ps.executeQuery("UPDATE usuario SET "
          + "NomUsu = ?"
          + ", ApeUsu = ?"
          + ", PassUsu = ?"
          + ", Email = ?"
          + ", Movil = ?"
          + " WHERE IDusu = ?");
      ps.setString(1, nom);
      ps.setString(2, ape);
      ps.setString(3, pass);
      ps.setString(4, email);
      ps.setString(5, movil);
      ps.setInt(6, id);
      return resultSet.rowUpdated();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean borraUsuario(Connection con, int id) {
    try (PreparedStatement ps = (PreparedStatement) con.createStatement()) {
      ResultSet resultSet = ps.executeQuery("DELETE FROM usuario WHERE IDusu = ?");
      ps.setInt(1, id);
      return resultSet.rowDeleted();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean buscarUserPorID(Connection con, int id) {
    try (PreparedStatement ps = (PreparedStatement) con.createStatement()) {
      ResultSet result = ps.executeQuery("SELECT * FROM usuario WHERE IDusu = ?");
      ps.setInt(1, id);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
*/

}



