package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.examen.fragments.actualizar;
import com.example.examen.fragments.agregar;
import com.example.examen.fragments.eliminar;

public class crud extends AppCompatActivity {


    Fragment fgOp1, fgOp2, fgOp3, fgBienvenida;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_crud);
            getSupportActionBar().hide();
            fgOp1 = new agregar();
            fgOp2 = new actualizar();
            fgOp3 = new eliminar();
            fgBienvenida = new agregar();
            getSupportFragmentManager().beginTransaction().add(R.id.contenedor, fgBienvenida).commit();
    }

        public void mGetFragments(View view){
            transaction = getSupportFragmentManager().beginTransaction();
            switch (view.getId()){
                case R.id.btnOp1:
                    transaction.replace(R.id.contenedor, fgOp1).commit();
                    transaction.addToBackStack(null);
                    break;
                case R.id.btnOp2:
                    transaction.replace(R.id.contenedor, fgOp2).commit();
                    transaction.addToBackStack(null);
                    break;
                case R.id.btnOp3:
                    transaction.replace(R.id.contenedor, fgOp3).commit();
                    transaction.addToBackStack(null);
                    break;
            }
        }
    }
