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
class ActividadTest {

  @Mock
  private ResultSet resultSet;

  @Test
  void constructor() throws SQLException {
    Actividad actividad1 = new Actividad(50, 2, 4, "Maratón", 1, "No disponible", "No disponible");

    when(resultSet.getInt(any())).thenAnswer((Answer<Integer>) invocationOnMock -> {
      if (invocationOnMock.getArgument(0).equals("IDact")) {
        return actividad1.getId();
      } else if (invocationOnMock.getArgument(0).equals("IDcat")) {
        return actividad1.getIdcat();
      } else if (invocationOnMock.getArgument(0).equals("IDciu")) {
        return actividad1.getIdciu();
      } else if (invocationOnMock.getArgument(0).equals("IDemp")) {
        return actividad1.getIdemp();
      } else {
        return null;
      }
    });

    when(resultSet.getString(any())).thenAnswer((Answer<String>) invocationOnMock -> {
      if (invocationOnMock.getArgument(0).equals("NomAct")) {
        return actividad1.getNom();
      } else if (invocationOnMock.getArgument(0).equals("Horario")) {
        return actividad1.getHorario();
      } else if (invocationOnMock.getArgument(0).equals("Info")) {
        return actividad1.getInfo();
      } else {
        return null;
      }
    });

    Actividad actividad2 = new Actividad(resultSet);
    assertEquals(actividad1, actividad2);
  }
}