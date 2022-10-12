package com.example.navigation_2022;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    //el tipo es pokemon arraylist
    RecyclerView recyclerView;
    ArrayList<Pokemon> listaPokes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState){
        Button PparaTercera = view.findViewById(R.id.SparaT);

        Context context = this.getContext();
        recyclerView = getView().findViewById(R.id.idRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        listaPokes = new ArrayList<>();
        Pokemon p1 = new Pokemon("Pokemon 1", "Descripcion del pokemon",R.drawable.charmander);
        Pokemon p2 = new Pokemon("Pokemon 2", "Descripcion del pokemon",R.drawable.pikachuazul);
        Pokemon p3 = new Pokemon("Pokemon 3", "Descripcion del pokemon",R.drawable.eve);
        Pokemon p4 = new Pokemon("Pokemon 4", "Descripcion del pokemon",R.drawable.squerel);
        Pokemon p5 = new Pokemon("Pokemon 5", "Descripcion del pokemon",R.drawable.pikachuazul);

        listaPokes.add(p1);listaPokes.add(p2);listaPokes.add(p3);listaPokes.add(p4);listaPokes.add(p5);

        PokemonAdapter pokeAdapter = new PokemonAdapter(listaPokes);
        recyclerView.setAdapter(pokeAdapter);

        PparaTercera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_thirdFragment2);
            }
        });
    }


}