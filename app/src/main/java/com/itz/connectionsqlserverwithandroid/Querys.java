package com.itz.connectionsqlserverwithandroid;

import android.database.sqlite.SQLiteException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Querys {

    public static void ejecutaIUD(String query) throws SQLException {
        Connection con = Conexion.getConexion();
        Statement st = con.createStatement();
        st.executeUpdate(query);
        st.close();
        con.close();
    }


    public static ArrayList getAll() throws SQLException{
        ArrayList datos = new ArrayList();
        Connection con = Conexion.getConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT nc,nombre,apellidos,semestre FROM alumnos");

        while (rs.next()){
            DatosAlumno da = new DatosAlumno();
            da.setNc("nc");
            da.setNombre("nombre");
            da.setApellidos("apellidos");
            da.setSemestre(rs.getInt("semestre"));
            datos.add(da);
        }
        st.close();
        con.close();

        return datos;
    }























}
