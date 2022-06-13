package edu.fpdual.webservicevn.model.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReservaTest {

    @Mock
    private ResultSet resultSet;

    @Test
    void constructor() throws SQLException {
        Reservas reservas1 = new Reservas(55, 5, 3, 10-12-2022, 25);

        when(resultSet.getInt(any())).thenAnswer((Answer<Integer>) invocationOnMock -> {
            if (invocationOnMock.getArgument(0).equals("IDres")) {
                return reservas1.getIdRes();
            } else if (invocationOnMock.getArgument(0).equals("IDusu")) {
                return reservas1.getIdUsu();
            } else if (invocationOnMock.getArgument(0).equals("IDact")) {
                return reservas1.getIdAct();
            } else {
                return null;
            }
        });

        when(resultSet.getDate(any())).thenAnswer((Answer<Date>) invocationOnMock -> {
            if (invocationOnMock.getArgument(0).equals("Fecha")) {
                return reservas1.getFecha();
            } else {
                return null;
            }
        });

        when(resultSet.getTime(any())).thenAnswer((Answer<Time>) invocationOnMock -> {
            if (invocationOnMock.getArgument(0).equals("Hora")) {
                return reservas1.getHora();
            } else {
                return null;
            }
        });

        Reservas reservas2 = new Reservas(resultSet);
        assertEquals(reservas1, reservas2);
    }
}