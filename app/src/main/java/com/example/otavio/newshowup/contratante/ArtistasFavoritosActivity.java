package com.example.otavio.newshowup.contratante;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.otavio.newshowup.R;
import com.example.otavio.newshowup.utils.SnapshotContratante;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistasFavoritosActivity extends AppCompatActivity {

    @BindView(R.id.recycler_candidatos)RecyclerView recyclerView;
    @BindView(R.id.text_candidatos)TextView textViewEvento;
    ArtistaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistas_favoritos);
        ButterKnife.bind(this);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        String nome_evento=textViewEvento.getText().toString()+getIntent().getStringExtra("nome_evento");
        textViewEvento.setText(nome_evento);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ArtistasFavoritosActivity.this);
        layoutManager.setReverseLayout(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ArtistaAdapter(SnapshotContratante.artistas,ArtistasFavoritosActivity.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SnapshotContratante.artistas=new ArrayList<>();
        adapter=null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
