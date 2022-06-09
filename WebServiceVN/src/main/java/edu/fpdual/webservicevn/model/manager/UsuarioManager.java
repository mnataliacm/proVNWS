package edu.fpdual.webservicevn.model.manager;

import edu.fpdual.webservicevn.model.dao.Usuario;

import java.sql.Connection;

public interface UsuarioManager extends Manager<Usuario, Integer> {

  Usuario buscaNombre(Connection con, String nom);

}
