package io.github.tiagofrbarbosa.pontotelapp.activity;

import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.tiagofrbarbosa.pontotelapp.R;
import io.github.tiagofrbarbosa.pontotelapp.adapter.UserAdapter;
import io.github.tiagofrbarbosa.pontotelapp.model.User;
import io.github.tiagofrbarbosa.pontotelapp.model.UserList;
import io.github.tiagofrbarbosa.pontotelapp.retrofit.UsersService;
import io.github.tiagofrbarbosa.pontotelapp.util.RecyclerItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private ProgressBar progressBar;
    private List<User> listUsers = new ArrayList<>();

    public static UsersService api = null;
    private static final String ENDPOINT = "https://s3-sa-east-1.amazonaws.com/pontotel-docs/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        loadApi();

        FloatingActionButton fab_refresh = findViewById(R.id.fab_refresh);
        fab_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                loadApi();
            }
        });

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), listUsers.get(position).getName(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), listUsers.get(position).getName(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void loadApi(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MainActivity.api = retrofit.create(UsersService.class);

        Call<UserList> userCall = api.getUsers();

        userCall.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                listUsers.clear();
                listUsers = response.body().getUsers();
                userAdapter = new UserAdapter(listUsers);
                recyclerView.setAdapter(userAdapter);

                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {

                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
