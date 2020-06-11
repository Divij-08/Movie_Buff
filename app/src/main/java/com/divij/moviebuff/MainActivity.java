
package com.divij.moviebuff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.BuildCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.divij.moviebuff.adapter.MoviesAdapter;
import com.divij.moviebuff.api.Client;
import com.divij.moviebuff.api.Service;
import com.divij.moviebuff.model.Movie;
import com.divij.moviebuff.model.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ProgressBar pd;
    private SwipeRefreshLayout swipeContainer;
    private static final String LOG_TAG = MoviesAdapter.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        swipeContainer=findViewById(R.id.main_content);
        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initViews();
                Toast.makeText(MainActivity.this,"Movies Refreshed",Toast.LENGTH_SHORT).show();

            }
        });
    }
    public Activity getActivity(){
        Context context = this ;
        while(context instanceof ContextWrapper){
            if(context instanceof Activity){
                return (Activity) context;

            }
            context= ((ContextWrapper)context).getBaseContext();

        }
        return null;
    }
    private void initViews()
    {
        pd = new ProgressBar(this);
        pd.isShown();

        recyclerView = findViewById(R.id.recycler_view);
        List<Movie> movieList = new ArrayList<>();
        MoviesAdapter adapter = new MoviesAdapter(this, movieList);

        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        }
        else
        {
            recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        loadJSON();
    }
    private void loadJSON(){
     try {

         Client client = new Client();
         Service apiService = client.getClient().create(Service.class);
         Call<MovieResponse> call = apiService.getPopularMovies(BuildConfig.THE_MOVIE_API_TOKEN);
         call.enqueue(new Callback<MovieResponse>() {
             @Override
             public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                 List<Movie>movies = response.body().getResults();
                 recyclerView.setAdapter(new MoviesAdapter(getApplicationContext(),movies));
                 recyclerView.smoothScrollToPosition(0);
                 if (swipeContainer.isRefreshing()){
                     swipeContainer.setRefreshing(false);
                 }
             }

             @Override
             public void onFailure(Call<MovieResponse> call, Throwable t) {
                 Toast.makeText(MainActivity.this, "Error Fetching Data!", Toast.LENGTH_SHORT).show();

             }
         });
     } catch (Exception a){
     }
    }



}