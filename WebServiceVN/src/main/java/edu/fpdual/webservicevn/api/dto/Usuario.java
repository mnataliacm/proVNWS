package edu.fpdual.webservicevn.api.dto;

import lombok.*;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor

  public class Usuario {
    private int id;
    private String nom;
    private String ape;
    private String pass;
    private String email;
    private String movil;
    private String idciu;
}
