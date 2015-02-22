package com.myapp.wicket.Conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class conexion {
    Connection conn = null;
    public conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
  conn = DriverManager.getConnection("jdbc:mysql://localhost/medico", "root", "123");
  // conn = DriverManager.getConnection("jdbc:mysql://mariadb2227-docthor.jl.serv.net.mx/medico","root","qd79dn719w");
             if (conn != null) {
                System.out.println("Conexion a base de datos lista");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public Connection getConnection() {
        return conn;
    }
    public void desconectar() {
        conn = null;
    }
}
