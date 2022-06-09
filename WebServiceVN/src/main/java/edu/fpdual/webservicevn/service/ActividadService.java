package edu.fpdual.webservicevn.service;

import edu.fpdual.webservicevn.model.connector.Connector;
import edu.fpdual.webservicevn.model.dao.Actividad;
import edu.fpdual.webservicevn.model.manager.implement.ActividadManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

// TODO: 08/06/2022 preguntar a Mariano si no se quita lo del void
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
  public boolean borrarActividad(Integer id) throws SQLException, ClassNotFoundException {
    try (Connection con =new Connector().getConnection()) {
      return actividadManager.borrar(con, id);
    }
  }
  public int crearActividad(Actividad actividad) throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return actividadManager.crear(con, actividad);
    }
  }
  public boolean modificarActividad(Actividad actividad) throws SQLException, ClassNotFoundException {
    try (Connection con =new Connector().getConnection()) {
      return actividadManager.modificar(con, actividad);
    }
  }
}
