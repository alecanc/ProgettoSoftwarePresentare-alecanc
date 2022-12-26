package com.example.progettosoftware.Comuni;

import java.sql.*;
import java.util.ArrayList;

public class Deamon {
    private String URL = "jdbc:mysql://localhost:3306/Azienda";
    private String username = "root";
    private String passwordDBMS = "root1234";

    public boolean verificaCredenziali(String mail, String password){
        ResultSet rs;
        try{

            Connection conn = DriverManager.getConnection(URL,username,passwordDBMS);
    /*Statement stm = conn.createStatement();
    //String sql = "SELECT * FROM Amministratore WHERE email = '" + mail1 + "'";
    String sql = "SELECT * FROM Amministratore WHERE email = 'giovanna.bertolini@azienda.it'";
    ResultSet rs = stm.executeQuery(sql);*/
            //TODO manca il fatto di mettere la password e di non interrogare l'amministratore
            String sql = "SELECT * FROM Amministratore WHERE email = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, mail);
             rs = pstm.executeQuery();
            if(!rs.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException a){
            System.out.println("Errore Comunicazione DBMS");
        }


return false;
    }


    public ArrayList<String> getDatiProfilo(/*int matricola*/) {
        ArrayList<String> dati = new ArrayList<>();
        ResultSet rs = null;
        try {

            Connection conn = DriverManager.getConnection(URL, username, passwordDBMS);
            String sql = "SELECT nome, cognome FROM Amministratore WHERE email='giovanna.bertolini@azienda.it'/*?*/";
            PreparedStatement pstm = conn.prepareStatement(sql);
           //pstm.setInt(1, matricola);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                dati.add(nome);
                String cognome = rs.getString("cognome");
                dati.add(cognome);
                System.out.println(nome);
            }
        } catch (SQLException a) {
            System.out.println("Errore Comunicazione DBMS");
        }
        return dati;
    }

    }
