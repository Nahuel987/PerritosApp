package com.example.perritoapp.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.perritoapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaRazasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaRazasFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private String animalName;
    private String animalURL;

    private ImageView imageView;
    private TextView textViewName;



    public ListaRazasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaRazasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaRazasFragment newInstance(String param1, String param2) {
        ListaRazasFragment fragment = new ListaRazasFragment();
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
           // mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);

            animalName = getArguments().getString(ARG_PARAM1);
            animalURL = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_lista_razas, container, false);

        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_lista_imagenes_razas, container, false);
        initializeView(view);

        textViewName.setText(animalName);

        Glide.with(getContext())
                .load(animalURL)     //obtiene url
                .centerCrop()        //centra la imagen
                .into(imageView);    //donde se muestra la imagen

        return view;

    }


    private void initializeView(View view){

        textViewName= view.findViewById(R.id.listaPerritosEnFragmento);
        //imageView =view.findViewById(R.id.imageViewFragment);

    }





}
