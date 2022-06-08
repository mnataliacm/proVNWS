package edu.fpdual.webservicevn.model.dao;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@Builder

public class Reservas {

    private int idUsu;
    private int idAct;
    private Date fecha;
    private Time hora;

    public Reservas(ResultSet result) throws SQLException {
        setIdUsu(result.getInt("IDusu"));
        setIdAct(result.getInt("IDact"));
        setFecha(result.getDate("Fecha"));
        setHora(result.getTime("Hora"));
    }
}
