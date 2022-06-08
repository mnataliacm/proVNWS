package edu.fpdual.webservicevn.model.dao;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@Builder



public class Actividad {
  private Integer id;
  private Integer idcat;
  private Integer idciu;
  private String nom;
  private Integer idemp;
  private String horario;
  private String info;

  public Actividad(ResultSet result) throws SQLException {
    this.id = result.getInt("IDact");
    this.idcat = result.getInt("IDcat");
    this.idciu = result.getInt("IDciu");
    this.nom = result.getString("NomAct");
    this.idemp = result.getInt("IDemp");
    this.horario = result.getString("Horario");
    this.info = result.getString("Info");
  }
}
