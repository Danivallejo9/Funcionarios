package com.iudigital.dao;

import com.iudigital.dominio.Funcionarios;
import com.iudigital.util.recursos.humanos.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionariosDao {

    private static final String GET_FUNCIONARIOS = "select * from funcionarios";
    private static final String CREATE_FUNCIONARIO = "insert into "
            + "funcionarios(iddoc, tipodoc, nombre, apellidos, estadocivil, sexo, direccion, telefono, fechanac)"
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_FUNCIONARIO_BY_ID = "select * from funcionarios where iddoc = ?";
    private static final String UPDATE_FUNCIONARIO = "update "
            + "funcionarios set tipodoc = ?, nombre = ?, apellidos = ?, estadocivil = ?, sexo = ?, direccion = ?, telefono = ?, fechanac = ? where iddoc = ?";
    private static final String DELETE_FUNCIONARIO = "delete from funcionarios where iddoc = ?";

    public void crearFuncionario (Funcionarios funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIO);
            preparedStatement.setInt(1, funcionario.getIddoc());
            preparedStatement.setString(2, funcionario.getTipodoc());
            preparedStatement.setString(3, funcionario.getNombre());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setString(5, funcionario.getEstadocivil());
            preparedStatement.setString(6, funcionario.getSexo()); 
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setDate(9, funcionario.getFechanac());
            
            preparedStatement.executeUpdate();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            
            if (connection != null) {
                connection.close();
            }
        }
    }
    
    public List<Funcionarios> obtenerFuncionarios() throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionarios> funcionarios = new ArrayList<>();
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Funcionarios funcionario = new Funcionarios();
                funcionario.setIddoc(resultSet.getInt("iddoc"));
                funcionario.setTipodoc(resultSet.getString("TipoDoc"));
                funcionario.setNombre(resultSet.getString("Nombre"));
                funcionario.setApellidos(resultSet.getString("Apellidos"));
                funcionario.setEstadocivil(resultSet.getString("EstadoCivil"));
                funcionario.setSexo(resultSet.getString("Sexo"));
                funcionario.setDireccion(resultSet.getString("Direccion"));
                funcionario.setTelefono(resultSet.getString("Telefono"));
                funcionario.setFechanac(resultSet.getDate("FechaNac"));
                funcionarios.add(funcionario);
            }
            return funcionarios;
            
        }finally {
            if (connection != null) {
                connection.close();
            }
                      
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (resultSet != null){
                resultSet.close();
            }
        }
    }
    
    public Funcionarios obtenerFuncionario(int iddoc) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionarios funcionario = null; 
        
        try {
            
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, iddoc);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                funcionario = new Funcionarios();
                funcionario.setIddoc(resultSet.getInt("iddoc"));
                funcionario.setTipodoc(resultSet.getString("TipoDoc"));
                funcionario.setNombre(resultSet.getString("Nombre"));
                funcionario.setApellidos(resultSet.getString("Apellidos"));
                funcionario.setEstadocivil(resultSet.getString("EstadoCivil"));
                funcionario.setSexo(resultSet.getString("Sexo"));
                funcionario.setDireccion(resultSet.getString("Direccion"));
                funcionario.setTelefono(resultSet.getString("Telefono"));
                funcionario.setFechanac(resultSet.getDate("FechaNac"));
                         
            }
            
            return funcionario;
            
        }finally {
            if (connection != null) {
                connection.close();
            }
                      
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (resultSet != null){
                resultSet.close();
            }
        }
    }
    
    public void actualizarFuncionario(int iddoc, Funcionarios funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_FUNCIONARIO);
            
            preparedStatement.setString(1, funcionario.getTipodoc());
            preparedStatement.setString(2, funcionario.getNombre());
            preparedStatement.setString(3, funcionario.getApellidos());
            preparedStatement.setString(4, funcionario.getEstadocivil());
            preparedStatement.setString(5, funcionario.getSexo());
            preparedStatement.setString(6, funcionario.getDireccion());
            preparedStatement.setString(7, funcionario.getTelefono());
            preparedStatement.setDate(8, funcionario.getFechanac());
            preparedStatement.setInt(9, funcionario.getIddoc());
            
            preparedStatement.executeUpdate();
            
        }finally {
            if (connection != null) {
                connection.close();
            }
                      
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
    public void eliminarFuncionario(int iddoc) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, iddoc);
            preparedStatement.executeUpdate();
            
        }finally {
            if (connection != null) {
                connection.close();
            }
                      
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
} 
