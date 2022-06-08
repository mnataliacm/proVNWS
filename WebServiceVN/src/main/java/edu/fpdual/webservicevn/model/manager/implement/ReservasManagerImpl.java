package edu.fpdual.webservicevn.model.manager.implement;

import edu.fpdual.webservicevn.model.dao.Reservas;
import edu.fpdual.webservicevn.model.manager.ReservasManager;

import java.sql.Connection;
import java.util.Set;

// TODO: 08/06/2022 Pendiente de revisar
public class ReservasManagerImpl implements ReservasManager {
  @Override
  public Set<Reservas> todos(Connection con) {
    return null;
  }

  @Override
  public Reservas buscaID(Connection con, Integer id) {
    return null;
  }

  @Override
  public boolean borrar(Connection con, Integer id) {
    return false;
  }

  @Override
  public int crear(Connection con, Reservas entity) {
    return 0;
  }

  @Override
  public boolean modificar(Connection con, Reservas entity) {
    return false;
  }

}
