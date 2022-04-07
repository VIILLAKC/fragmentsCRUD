package com.example.examen.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examen.R;
import com.example.examen.db.SQL.DB.methods;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link eliminar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class eliminar extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText idtxt;

    public eliminar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment eliminar.
     */
    // TODO: Rename and change types and number of parameters
    public static eliminar newInstance(String param1, String param2) {
        eliminar fragment = new eliminar();
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
        View view = inflater.inflate(R.layout.fragment_eliminar,
                container, false);
        Button button = (Button) view.findViewById(R.id.registrarBTN);
        methods DBmangas = new methods(getActivity());

        //<ListView>
        ArrayList<String> comicsArrayList;
        TextView textView;
        ListView listView;
        comicsArrayList =  DBmangas.mostrarSpiner();

        listView = view.findViewById(R.id.listView);
        textView = view.findViewById(R.id.textView);

        String[] listItem = comicsArrayList.toArray(new String[0]);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);
        //</ListView>

        idtxt = (EditText) view.findViewById(R.id.idtxt);
       button.setOnClickListener(new View.OnClickListener()
        {

            //<BtnEliminar>
            @Override
            public void onClick(View v)
            {
                long id =  DBmangas.eliminarComic(Integer.valueOf(idtxt.getText().toString()));

                if(id > 0 ){
                    Toast.makeText(getActivity(), "Se elimino con exito", Toast.LENGTH_LONG).show() ;
                }
                else {
                    Toast.makeText(getActivity(), "ERROR ", Toast.LENGTH_LONG).show();
                }
            }
        });
             //</BtnEliminar>

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value=adapter.getItem(position);
                Toast.makeText(getActivity(),value,Toast.LENGTH_SHORT).show();

            }
        });

        return view;}
}