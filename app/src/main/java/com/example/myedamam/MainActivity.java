package com.example.myedamam;

import static utils.ApiCredentials.API_KEY;
import static utils.ApiCredentials.APP_ID;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myedamam.databinding.ActivityMainBinding;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

import Adapter.RecipeAdapter;
import Response.SearchRecipes;
import apis.ApiClient;
import models.RootObjectModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.ApiCredentials;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private static final String TAG = "\t" + MainActivity.class.getSimpleName();
    private int recyclerView;
    private ArrayList<RootObjectModel> recipes;
    private RecipeAdapter adapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (R.layout.recipe_recyclerview);
        searchView = findViewById(R.id.search_bar);
        searchView.setQueryHint("Search");
        searchView.onActionViewCollapsed();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchRecipes(query);
                return true;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
    }

    private void searchRecipes(String query) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiCredentials.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        ApiClient apiClient = retrofit.create(ApiClient.class);
        Call<SearchRecipes> searchRecipesCall = apiClient.searchRecipes(ApiCredentials.TYPE, query, "ApiCredentials", APP_ID, API_KEY);
        searchRecipesCall.enqueue(new Callback<SearchRecipes>() {
            @Override
            public void onResponse(Call<SearchRecipes> call, Response<SearchRecipes> response) {
                if (response.isSuccessful() && response.body() != null) ;
                recipes = new ArrayList<>(Arrays.asList(response.body().getFoodRecipes()));
                for (int i = 0; i < recipes.size(); i++) {
                    RootObjectModel rootObjectModel = recipes.get(i);
                    recipes.add(rootObjectModel);
                    Log.v("Tag" + "TAG", "label" + rootObjectModel.getRecipeModel().getLabel());

                }

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                boolean b = true;
                adapter = new RecipeAdapter(MainActivity.this, recipes);

            }

            @Override
            public void onFailure(Call<SearchRecipes> call, Throwable t) {
                Log.v("Tag"+TAG, "onFailure()"+t.getMessage());

            }
        });


                    @NonNull RecipeAdapter.FoodViewHolder onCreateViewHolder;
        Object Object = new Object();
        ViewGroup viewGroup = (ViewGroup)
                Object;
        Object parent = new Object();
        java.lang.Object parent2 = parent;
        Object parent1 = parent2; int viewType = 0; {
                    }
                }
}



