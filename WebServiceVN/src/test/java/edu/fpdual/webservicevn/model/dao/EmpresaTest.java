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
class EmpresaTest {

    @Mock
    private ResultSet resultSet;

    @Test
    void constructor() throws SQLException {
        Empresa empresa1 = new Empresa(25, "Gonzalez S.A");

        when(resultSet.getInt(any())).thenAnswer((Answer<Integer>) invocationOnMock -> {
            if (invocationOnMock.getArgument(0).equals("IDemp")) {
                return empresa1.getId();
            } else {
                return null;
            }
        });

        when(resultSet.getString(any())).thenAnswer((Answer<String>) invocationOnMock -> {
            if (invocationOnMock.getArgument(0).equals("NomEmp")) {
                return empresa1.getNomEmp();
            } else {
                return null;
            }
        });

        Empresa empresa2 = new Empresa(resultSet);
        assertEquals(empresa1, empresa2);
    }
}
