package edu.fpdual.webservicevn.service;

import edu.fpdual.webservicevn.model.connector.Connector;
import edu.fpdual.webservicevn.model.dao.Actividad;
import edu.fpdual.webservicevn.model.dao.Usuario;
import edu.fpdual.webservicevn.model.manager.implement.ActividadManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class ActividadService {
  private final ActividadManagerImpl actividadManager;
  public ActividadService(ActividadManagerImpl actividadManager) {
    this.actividadManager = actividadManager;
  }

  public Set<Actividad> todasActividades() throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return actividadManager.todos(con);
    }
  }

  public Actividad buscaId(Integer id) throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return actividadManager.buscaID(con, id);
    }
  }

  public boolean borrarUsuario(Integer id) throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return actividadManager.borrar(con, id);
    }
  }

  // TODO: 05/06/2022 arreglar 
  public boolean nuevaActividad(String nom, String ape, String pass, String email, String movil, int ciu) throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      boolean crea = nuevaActividad(nom, ape, pass, email, movil, ciu);
      Usuario usuario = new Usuario();
      usuario.getNom();
      usuario.getApe();
      usuario.getPass();
      usuario.getEmail();
      usuario.getMovil();

      if (crea) {
       
        return true;

      } else {
        return false;
      }
    }
  }

  public boolean modificarUsuario(Actividad actividad) throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return actividadManager.modificar(con, actividad);
    }
  }


  public int nuevoUsuario(Usuario usuario) {
    return 0;
  }
}
