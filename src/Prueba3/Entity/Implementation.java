package Prueba3.Entity;

import Prueba3.Core.Models.Contacto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Implementation {
    public static void createContact(Contacto contacto){
        Connection connection = DbConnection.connect();
        PreparedStatement query = null;
        try {
            String sql = "INSERT INTO contactos(Identificacion, Nombre, Apellido, Genero, TipoIdentificacion, Telefono, Direccion, Email) VALUES(?,?,?,?,?,?,?,?) ";
            query = connection.prepareStatement(sql);
            query.setString(1, contacto.identificacion);
            query.setString(2, contacto.nombre);
            query.setString(3, contacto.apellido);
            query.setString(4, contacto.genero);
            query.setString(5, contacto.tipoIdentificacion);
            query.setString(6, contacto.telefono);
            query.setString(7, contacto.direccion);
            query.setString(8, contacto.email);
            query.execute();
            System.out.println("Registro exitoso!");
        } catch(SQLException e) {
            System.out.println("CONNECTION-"+e);
        } finally {
            try{
                query.close();
                connection.close();
            } catch(SQLException e) {
                System.out.println("CONNECTION-"+e);
            }

        }
    }

    public static void readContacts() {
        Connection connection = DbConnection.connect();

        ResultSet result = null;
        try {
            String sql = "SELECT id,nombre,apellido FROM contactos";
            result = connection.prepareStatement(sql).executeQuery();
            while(result.next() ) {
                System.out.println(result.getString(1)+". "+result.getString(2)+" "+ result.getString(3));
            }

        } catch(SQLException e) {
            System.out.println("CONNECTION-"+e);
        } finally {
            try{
                result.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("CONNECTION-"+e);
            }

        }
    }

    public static void updateContact(int id, Contacto contacto) {
        Connection connection = DbConnection.connect();
        PreparedStatement query = null;
        try {
            String sql = "UPDATE contactos SET " +
                    "identificacion = ? ," +
                    "nombre = ? ," +
                    "apellido = ? ," +
                    "genero = ? ," +
                    "tipoIdentificacion = ? ," +
                    "telefono = ? ," +
                    "direccion = ? ," +
                    "email = ? " +
                    "WHERE id = ? ";
            query = connection.prepareStatement(sql);
            query.setString(1, contacto.identificacion);
            query.setString(2, contacto.nombre);
            query.setString(3, contacto.apellido);
            query.setString(4, contacto.genero);
            query.setString(5, contacto.tipoIdentificacion);
            query.setString(6, contacto.telefono);
            query.setString(7, contacto.direccion);
            query.setString(8, contacto.email);
            query.setString(9, String.valueOf(id));
            query.execute();
            System.out.println("Se ha actualizado el contacto "+String.valueOf(id));
        } catch (SQLException e) {
            System.out.println("CONNECTION-"+e);
        }
    }

    public  static void GetContact(int id){
        Connection connection = DbConnection.connect();
        PreparedStatement query = null;
        ResultSet result = null;
        try {
            String sql = "SELECT * FROM contactos WHERE Id = ?";
            query = connection.prepareStatement(sql);
            query.setString(1,String.valueOf(id));
            result = query.executeQuery();

            System.out.println("Id: "+result.getString("Id"));
            System.out.println("Nombre: "+result.getString("Nombre"));
            System.out.println("Apellido: "+result.getString("Apellido"));
            System.out.println("Genero: "+result.getString("Genero"));
            System.out.println("Tipo de identificación: "+result.getString("TipoIdentificacion"));
            System.out.println("Identificación: "+result.getString("Identificacion"));
            System.out.println("Teléfono: "+result.getString("Telefono"));
            System.out.println("Dirección: "+result.getString("Direccion"));
            System.out.println("E-mail: "+result.getString("Email"));

        } catch(SQLException e) {
            System.out.println("CONNECTION-"+e);
        } finally {
            try{
                result.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("CONNECTION-"+e);
            }

        }
    }

    public static void deleteContact(int id){
        Connection connection = DbConnection.connect();
        PreparedStatement query = null;
        try {
            String sql = "DELETE FROM contactos WHERE Id = ? ";
            query = connection.prepareStatement(sql);
            query.setString(1, String.valueOf(id));
            query.execute();
            System.out.println("Contacto "+String.valueOf(id)+" Eliminado");
        } catch (Exception e) {
            System.out.println("CONNECTION-"+e);
        } finally {
            try {
                query.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("CONNECTION-"+e);
            }


        }
    }
}
