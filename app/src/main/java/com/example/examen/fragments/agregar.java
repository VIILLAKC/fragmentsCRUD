package com.example.examen.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examen.R;
import com.example.examen.db.SQL.DB.methods;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link agregar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class agregar extends Fragment {
    EditText txtNombre, txtEditorial, txtCosto;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public agregar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment agregar.
     */
    // TODO: Rename and change types and number of parameters
    public static agregar newInstance(String param1, String param2) {
        agregar fragment = new agregar();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_agregar,
                container, false);
        Button button = (Button) view.findViewById(R.id.registrarBTN);
        txtNombre = (EditText) view.findViewById(R.id.nombretxt);
        txtCosto = (EditText) view.findViewById(R.id.costotxt);
        txtEditorial = (EditText) view.findViewById(R.id.editorialtxt);
        button.setOnClickListener(new View.OnClickListener()
        {
            //<BtnGuardar>
            @Override
            public void onClick(View v)
            {
                methods DBmangas = new methods(getActivity());
             long id =  DBmangas.insertarComic(txtNombre.getText().toString(), txtEditorial.getText().toString(), txtCosto.getText().toString() );

                if(id > 0 ){
                    Toast.makeText(getActivity(), "Se guardo con exito", Toast.LENGTH_LONG).show() ;
                }
                else {
                    Toast.makeText(getActivity(), "ERROR al guardar", Toast.LENGTH_LONG).show();
                }
            }
        });
            //</BtnGuardar>
        return view;
    }
}