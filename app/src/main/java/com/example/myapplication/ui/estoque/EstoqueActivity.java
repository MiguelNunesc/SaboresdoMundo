package com.saboresdomundo.ui.estoque;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saboresdomundo.R;
import com.saboresdomundo.data.EstoqueRepository;
import com.saboresdomundo.model.Produto;

import java.util.List;

public class EstoqueActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EstoqueRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estoque);

        recyclerView = findViewById(R.id.recyclerViewEstoque);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        repository = new EstoqueRepository(this);

        // Simulação inicial (poderia ser um botão de adicionar no futuro)
        if (repository.listarProdutos().isEmpty()) {
            repository.inserirProduto(new Produto(0, "Arroz Branco", "Grãos", 25, "kg"));
            repository.inserirProduto(new Produto(0, "Leite", "Condimentos", 10, "L"));
        }

        List<Produto> produtos = repository.listarProdutos();
        ProdutoAdapter adapter = new ProdutoAdapter(produtos);
        recyclerView.setAdapter(adapter);
    }
}