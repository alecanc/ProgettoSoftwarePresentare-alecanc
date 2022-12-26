package com.example.progettosoftware.GestioneProfilo;

import com.example.progettosoftware.Comuni.Deamon;
import javafx.event.ActionEvent;


import java.io.IOException;
import java.util.ArrayList;

public class ControlVisualizzaProfilo {
    Deamon db= new Deamon();

    //private int matricola;

    SchermataVisualizzaProfilo schermataVisualizzaProfilo= new SchermataVisualizzaProfilo();

   /* public void create(int matricola){
        this.matricola=matricola;

    }*/


    public void clickVisualizzaProfilo(ActionEvent event) throws IOException{
        ArrayList<String> dati= new ArrayList<>();
       dati= db.getDatiProfilo(/*matricola*/);
System.out.println(dati);
        schermataVisualizzaProfilo.showDati(event, dati);
    }

    }

