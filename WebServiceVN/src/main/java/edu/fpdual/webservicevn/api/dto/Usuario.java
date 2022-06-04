package edu.fpdual.webservicevn.api.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement

public class Usuario {

  private int id;
  private String nom;
  private String ape;
  private String pass;
  private String email;
  private String movil;
  private int ciu;

}
