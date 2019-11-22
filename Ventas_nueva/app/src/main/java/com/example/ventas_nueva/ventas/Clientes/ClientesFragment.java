package com.example.ventas_nueva.ventas.Clientes;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ventas_nueva.Dao.ClienteDAO;
import com.example.ventas_nueva.R;

import io.realm.Realm;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClientesFragment extends Fragment {
    private EditText nomb,apellidos,nume,correo;
    private Button guardar;
    Realm realmDb;


    public ClientesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_clientes, container, false);
        nomb= rootView.findViewById(R.id.nom_cliente);
        apellidos = rootView.findViewById(R.id.apellido_cliente);
        nume = rootView.findViewById(R.id.telefono);
        correo = rootView.findViewById(R.id.email);
        guardar = rootView.findViewById(R.id.button4);
        Realm.init(getActivity());
        realmDb=Realm.getDefaultInstance();
        Registrar(rootView);
        return rootView;
    }
    public void Registrar(View v){
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = nume.getText().toString();
                String nom = nomb.getText().toString();
                String apellido = apellidos.getText().toString();
                String email = correo.getText().toString();
                if(!nom.isEmpty() && !apellido.isEmpty() && !email.isEmpty() &&!numero.isEmpty()) {
                    try {
                        realmDb.beginTransaction();
                        Number maxId = realmDb.where(ClienteDAO.class).max("id");
                        int nextId = (maxId == null) ? 1 : maxId.intValue() + 1;
                        ClienteDAO clienteDAO = realmDb.createObject(ClienteDAO.class, nextId);
                        clienteDAO.setNombre(nom);
                        clienteDAO.setApellidos(apellido);
                        realmDb.insertOrUpdate(clienteDAO);
                        realmDb.commitTransaction();
                        limpiar();
                        Toast.makeText(getContext(), "ClienteDAO registrado exitosamente", Toast.LENGTH_LONG).show();
                    } catch (Exception ex) {
                        Log.d("RError", ex.toString());
                        Toast.makeText(getContext(), "Error en realm", Toast.LENGTH_SHORT).show();
                    }
                }else
                    Toast.makeText(getActivity(),"Todos los campos son requeridos",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void limpiar(){
        nomb.setText("");
        apellidos.setText("");
        correo.setText("");
        nume.setText("");
    }
}