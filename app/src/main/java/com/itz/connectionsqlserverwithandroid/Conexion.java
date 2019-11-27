package com.itz.connectionsqlserverwithandroid;

import android.database.sqlite.SQLiteException;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexion() throws  SQLException {

        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
        }catch (Exception cnfe){ }
        return
                DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.76/proyecto_final;user=sa;password=123;");
                                               // jdbc:jtds:<server_type>://<server>[:<port>][/<database>][;<property>=<value>[;...]]
                                            //jdbc:jtds:sqlserver://a.example.com/xyz;instance=MSSQLSERVER;user=bob;password=xxx;TDS=7.0

                                                //jdbc:jdts:sqlserver://192.168.1.76:1433;databaseName=proyecto_final;user=sa;password=123
                                                //"jdbc:sqlserver://localhost:1433;databaseName=master;user=sa;password=your_password";
    }

}

