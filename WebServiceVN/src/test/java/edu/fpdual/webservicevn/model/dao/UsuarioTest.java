package edu.fpdual.webservicevn.model.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UsuarioTest {

  @Mock
  private ResultSet resultSet;

  @Test
  void constructor() throws SQLException {
    Usuario usuario1 = new Usuario(50, "Maria", "Gonzalez", "123", "mg@email.com", "123456789", 0);

    when(resultSet.getInt(any())).thenAnswer((Answer<Integer>) invocationOnMock -> {
      if (invocationOnMock.getArgument(0).equals("IDusu")) {
        return usuario1.getId();
      } else if (invocationOnMock.getArgument(0).equals("IDciu")) {
        return usuario1.getIdciu();
      } else {
        return null;
      }
    });

    when(resultSet.getString(any())).thenAnswer((Answer<String>) invocationOnMock -> {
      if (invocationOnMock.getArgument(0).equals("NomUsu")) {
        return usuario1.getNom();
      } else if (invocationOnMock.getArgument(0).equals("ApeUsu")) {
        return usuario1.getApe();
      } else if (invocationOnMock.getArgument(0).equals("PassUsu")) {
        return usuario1.getPass();
      } else if (invocationOnMock.getArgument(0).equals("Email")) {
        return usuario1.getEmail();
      } else if (invocationOnMock.getArgument(0).equals("Movil")) {
        return usuario1.getMovil();
      } else {
        return null;
      }
    });

    Usuario usuario2 = new Usuario(resultSet);
    assertEquals(usuario1, usuario2);
  }
}
