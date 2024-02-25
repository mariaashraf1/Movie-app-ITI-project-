package com.example.myapplication;


import static com.example.myapplication.MyAdapter.IMAGE_BASE_URL;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;


import com.example.myapplication.databinding.ActivityMain2Binding;

import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    MyAdapter adapter;
    private ActivityMain2Binding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Movie> movies = new ArrayList<>();
        adapter = new MyAdapter(movies);
        b=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        Bundle bundle = getIntent().getExtras();
        String str = bundle.getString("title");
        String str1 = bundle.getString("details");
        String i=bundle.getString("image");
        Picasso.with(b.image2.getContext()).load(IMAGE_BASE_URL + i).into(b.image2);
        b.title.setText(str);
        b.detalis.setText(str1);
    }

}
