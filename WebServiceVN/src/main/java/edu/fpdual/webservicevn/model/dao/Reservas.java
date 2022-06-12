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
    private int idRes;
    private int idUsu;
    private int idAct;
    private Date fecha;
    private Time hora;

    public Reservas(ResultSet result) throws SQLException {
        try {
            this.idRes = result.getInt("IDres");
            this.idUsu = result.getInt("IDusu");
            this.idAct = result.getInt("IDact");
            this.fecha = result.getDate("Fecha");
            this.hora = result.getTime("Hora");
        }catch(SQLException e){
                e.printStackTrace();
            }

    }
}
