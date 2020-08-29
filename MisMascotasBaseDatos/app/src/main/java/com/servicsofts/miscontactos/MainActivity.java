package com.servicsofts.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import vista.fragment.IrecyclerViewFragmentView;

public class MainActivity extends AppCompatActivity implements IrecyclerViewFragmentView {


    //declaro un arrary de la clase contacto
    ArrayList<Mascota> mascotas;
    //declaramos nuestro Recycler view
   private RecyclerView listaMacotas;
   private   IrecyclerViewFragmentView irecyclearViewPresentador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaMacotas = (RecyclerView) findViewById(R.id.rcViewContactos);
      //  irecyclearViewPresentador = new  IrecyclerViewFragmentView();

         //declaramos nuestro recyclerView que tenemos en nuestra activititi
       // irecyclearViewPresentador.generarLinearLayoutVertical();

    }

    /*
    public void inicializarContactos(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota( R.mipmap.mascota1,"Catyy","5", like));
        mascotas.add(new Mascota(R.mipmap.mascota2,"Ronny","3", like));

    }
*/
    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMacotas.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        ContactoAdaptador adapatador = new ContactoAdaptador(mascotas,this);
        return adapatador;
    }

    @Override
    public void inicializarAdaptador(ContactoAdaptador adaptador) {
        listaMacotas.setAdapter(adaptador);
    }
}