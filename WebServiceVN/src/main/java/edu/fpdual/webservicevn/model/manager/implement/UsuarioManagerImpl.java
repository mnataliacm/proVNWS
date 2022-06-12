package edu.fpdual.webservicevn.model.manager.implement;

import edu.fpdual.webservicevn.email.Sender;
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
  public Usuario buscaID(Connection con, Integer id) {
    String sql = "SELECT * FROM usuario WHERE IDusu = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      resultSet.next();
      return new Usuario(resultSet);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean borrar(Connection con, Integer id) {
    //prepare SQL statement
    String sql = "DELETE FROM usuario WHERE IDusu = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, id);
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public int crear(Connection con, Usuario usuario) {
    String sql = "INSERT INTO usuario (NomUsu, ApeUsu, PassUsu, Email, Movil, IDciu) values (?, ?, ?, ?, ?, ?)";
    try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1, usuario.getNom());
      ps.setString(2, usuario.getApe());
      ps.setString(3, usuario.getPass());
      ps.setString(4, usuario.getEmail());
      ps.setString(5, usuario.getMovil());
      ps.setInt(6, usuario.getIdciu());
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
  public boolean modificar(Connection con, Usuario usuario) {
    String sql = "UPDATE usuario SET NomUsu=?, ApeUsu=?, PassUsu=? , Email=? , Movil=?, IDciu=? WHERE IDusu = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setString(1, usuario.getNom());
      ps.setString(2, usuario.getApe());
      ps.setString(3, usuario.getPass());
      ps.setString(4, usuario.getEmail());
      ps.setString(5, usuario.getMovil());
      ps.setInt(6, usuario.getIdciu());
      ps.setInt(7, usuario.getId());
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public Usuario buscaNombre(Connection con, String nom) {
    String sql = "SELECT * FROM usuario WHERE NomUsu LIKE ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setString(1, nom);
      ResultSet resultSet = ps.executeQuery();
      resultSet.next();
      return new Usuario(resultSet);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public boolean enviaEmailBienvenida(Usuario usuario) {
    return new Sender().send("muloxa@gmail.com", "" + usuario.getEmail() + "", "Bienvenid@ a ¡Vaya plaN!;)",
        "Hola <b>" + usuario.getNom() + "</b>,<br><br>" +
            "<b>Bienvenid@<b> a nuestra comunidad.<br><br>" +
            "Su registro se ha realizado correctamente:<br>" +
            "Nombre Completo:<b> " + usuario.getNom() + " " + usuario.getApe() + "</b><br>" +
            "Email:<b> " + usuario.getEmail() + "</b><br>" +
            "Móvil:<b> " + usuario.getMovil() + "</b><br>" +
            "Descubre todo lo que puedes hacer en tu tiempo libre, acude al teatro, aprende surf o busca un grupo para pasar la tarde en una batalla de paintball.<br><br><br><br>" +
            "Saludos, <br>" +
            "El equipo de VN<br>");
  }
}



