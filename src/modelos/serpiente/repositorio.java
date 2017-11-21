/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.serpiente;

import dataBase.DBManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public class repositorio {
    private static DBManager database = new DBManager();
                //interactua con la base de datos y envia para crear un jugador
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
            //obtiene todos los datos de la base dedatos y los retorna en un array list 
           public static ArrayList<Datos_usuarios> obtenerTodos() {
        ArrayList<Datos_usuarios> jugadores = new ArrayList<Datos_usuarios>();

        try {
            String query = "SELECT * FROM usuario;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                jugadores.add(Datos_usuarios.crear(resultado.getInt("id"), resultado.getString("foto"), resultado.getInt("cedula"),resultado.getString("nombre"),resultado.getString("apellido"), resultado.getInt("edad"), resultado.getString("fecha_nacimiento"), resultado.getString("fecha_registro"),resultado.getInt("puntaje")));
            }

            sentenciaP.close();
            database.close();

            return jugadores;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return jugadores;
    }
              //obtiene los el rango de edades de 5 a 15 y los devuelce en un arraylist   
           public static ArrayList<Datos_usuarios> categoriaInfantil() {
        ArrayList<Datos_usuarios> jugadores = new ArrayList<Datos_usuarios>();

        try {
            String query = "SELECT * FROM usuario WHERE edad Between 5 And 15;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                jugadores.add(Datos_usuarios.crear(resultado.getInt("id"), resultado.getString("foto"), resultado.getInt("cedula"),resultado.getString("nombre"),resultado.getString("apellido"), resultado.getInt("edad"), resultado.getString("fecha_nacimiento"), resultado.getString("fecha_registro"),resultado.getInt("puntaje")));
            }

            sentenciaP.close();
            database.close();

            return jugadores;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return jugadores;
    }
          //obtiene los el rango de edades de 16 a 24 y los devuelce en un arraylist   
             
           public static ArrayList<Datos_usuarios> categoriaJuvenil() {
        ArrayList<Datos_usuarios> jugadores = new ArrayList<Datos_usuarios>();

        try {
            String query = "SELECT * FROM usuario WHERE edad Between 16 And 24;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                jugadores.add(Datos_usuarios.crear(resultado.getInt("id"), resultado.getString("foto"), resultado.getInt("cedula"),resultado.getString("nombre"),resultado.getString("apellido"), resultado.getInt("edad"), resultado.getString("fecha_nacimiento"), resultado.getString("fecha_registro"),resultado.getInt("puntaje")));
            }

            sentenciaP.close();
            database.close();

            return jugadores;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return jugadores;
    }
           //obtiene los el rango de edades de 25 a 50 y los devuelce en un arraylist   
               
           public static ArrayList<Datos_usuarios> categoriaMayores() {
        ArrayList<Datos_usuarios> jugadores = new ArrayList<Datos_usuarios>();

        try {
            String query = "SELECT * FROM usuario WHERE edad Between 25 And 50;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                jugadores.add(Datos_usuarios.crear(resultado.getInt("id"), resultado.getString("foto"), resultado.getInt("cedula"),resultado.getString("nombre"),resultado.getString("apellido"), resultado.getInt("edad"), resultado.getString("fecha_nacimiento"), resultado.getString("fecha_registro"),resultado.getInt("puntaje")));
            }

            sentenciaP.close();
            database.close();

            return jugadores;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return jugadores;
    }
}
