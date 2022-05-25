package edu.fpdual.webservicevn.model.manager;

import edu.fpdual.webservicevn.model.dao.Empresa;


public interface EmpresaManager extends Manager<Empresa, Integer>{

/*    *//**
     * Busca todos las empresas
     *
     * @param con conexión a BBDD
     * @return {@code Set} of {@code Usuario}
     *//*
    Set<Empresa> todasEmpresas(Connection con);

    *//**
     * Busca todos los usuarios
     * @param con conexión a BBDD
     * @return {@code Set} of {@code Usuario}
     *//*
    public ResultSet modificarEmpresa(Connection con, String nomEmp, int idCiu, int idEmp) throws SQLException;*/
}
