package edu.fpdual.webservicevn.model.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoriaTest {

  @Mock
  private ResultSet resultSet;

  @Test
  void constructor() throws SQLException {
    Categoria categoria1 = new Categoria(50, "Varios", "no disponible");

    when(resultSet.getInt(any())).thenAnswer((Answer<Integer>) invocationOnMock -> {
      if (invocationOnMock.getArgument(0).equals("IDusu")) {
        return categoria1.getId();
      } else {
        return null;
      }
    });

    when(resultSet.getString(any())).thenAnswer((Answer<String>) invocationOnMock -> {
      if (invocationOnMock.getArgument(0).equals("NomCat")) {
        return categoria1.getNom();
      } else if (invocationOnMock.getArgument(0).equals("Imagen")) {
        return categoria1.getImagen();
      } else {
        return null;
      }
    });

    Categoria categoria2 = new Categoria(resultSet);
    assertEquals(categoria1, categoria2);
  }
}