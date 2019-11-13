package com.itz.connectionsqlserverwithandroid;

import android.database.sqlite.SQLiteException;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConexion() throws SQLiteException{
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
        }catch (ClassNotFoundException cnfe){ }
        return
                DriverManager.getConnection("jd");
    }

}

