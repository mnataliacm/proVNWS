package edu.fpdual.webservicevn.model.dao;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@XmlRootElement

public class Actividad {

  private int id;
  private int idcat;
  private int idciu;
  private String nom;
  private int idemp;
  private String horario;
  private String info;

  public Actividad(ResultSet result) throws SQLException {
    setId(result.getInt("IDact"));
    setIdcat(result.getInt("IDcat"));
    setIdciu(result.getInt("IDciu"));
    setNom(result.getString("NomAct"));
    setIdemp(result.getInt("IDemp"));
    setHorario(result.getString("Horario"));
    setInfo(result.getString("Info"));
  }
}
