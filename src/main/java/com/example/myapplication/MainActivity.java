package com.example.myapplication;


import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);

        ArrayList<Movie> movies = new ArrayList<>();

        adapter = new MyAdapter(movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }

    public void updateData(ArrayList<Movie> movies) {
    adapter.setData(movies);
    }


    public void click(View view) {
        new MyTask().execute("https://api.themoviedb.org/3/movie/top_rated?api_key=3c3d662f3dfecdd191da7642c1b1e2af");
    }
        class MyTask extends AsyncTask<String, Void, String> {


            @Override
            protected String doInBackground(String... params) {
                String result = null;
                try {
                    URL url = new URL(params[0]);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setConnectTimeout(5000);
                    if (conn.getResponseCode() != 200) {
                        throw new IOException(conn.getResponseMessage());
                    }



                    BufferedReader buffrd = new BufferedReader(new InputStreamReader(
                            conn.getInputStream()));
                    StringBuffer sb = new StringBuffer();
                    String line;
                    while ((line = buffrd.readLine()) != null) {
                        sb.append(line);
                    }
                    result = sb.toString();
                    buffrd.close();
                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                if (s != null) {
                    Gson gson = new Gson();
                    MoviesModel response = gson.fromJson(s, MoviesModel.class);
                     updateData(response.getMovies());
                }
            }

        }
    }
