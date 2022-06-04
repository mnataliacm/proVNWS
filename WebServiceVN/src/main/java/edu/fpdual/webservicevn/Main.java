package edu.fpdual.webservicevn;

import edu.fpdual.webservicevn.controller.UsuarioController;
import edu.fpdual.webservicevn.model.dao.Usuario;

import java.sql.SQLException;


public class Main {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    System.out.println(new UsuarioController().todos());
    System.out.println(new UsuarioController().buscaId(3));



    /*Connector connector = new Connector();
    Connection con = connector.getConnection();
    System.out.println("Base de Datos: " + con.getCatalog());
    System.out.println("Listado de todos los usuarios");
    System.out.println(new UsuarioService(new UsuarioManagerImpl()).todosUsuarios());
    System.out.println("Buscar usuario por id");
    System.out.println(new UsuarioService(new UsuarioManagerImpl()).buscaId(3));
    System.out.println("Nuevo usuario");*/
   Usuario usuario = new Usuario(15, "lili", "lili", "lili", "lili@email.com", "123");
    System.out.println(new UsuarioController().crear("lili", "lili", "lili", "lili@email.com", "123"));



  }
}
