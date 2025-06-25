package com.reservasi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/private_class_reservation";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Koneksi database berhasil!");
        }catch (SQLException e){
            System.err.println("Koneksi database gagal: "+ e.getMessage());
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(Connection connection){
        if  (connection != null){
            try{
                connection.close();
                System.out.println("Koneksi database ditutup.");
            }catch (SQLException e){
                System.err.println("Gagal menutup koneksi database: "+ e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null){

            DatabaseConnection.closeConnection(conn);
        }
    }  
}