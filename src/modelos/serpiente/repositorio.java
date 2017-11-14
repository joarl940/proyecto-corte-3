/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.serpiente;

import dataBase.DBManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jose
 */
public class repositorio {
    private static DBManager database = new DBManager();
    
       public static void crear (Datos_usuarios usuario) {
        try {
            String query = "INSERT INTO usuario (foto, cedula,nombre, apellido, edad,fecha_nacimiento,fecha_registro,puntaje) VALUES (?,?, ?,?, ?, ?, ?,?);";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, usuario.getFoto());
            sentenciaP.setInt(2, usuario.getCedula());
            sentenciaP.setString(3,usuario.getNombre());
            sentenciaP.setString(4,usuario.getApellido());
            sentenciaP.setInt(5, usuario.getEdad());
            sentenciaP.setString(6, usuario.getFecha_nacimiento());
            sentenciaP.setString(7, usuario.getFecha_registro());
            sentenciaP.setInt(8, usuario.getPuntaje());

            
            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
