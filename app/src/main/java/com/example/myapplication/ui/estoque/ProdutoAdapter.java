package com.saboresdomundo.ui.estoque;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saboresdomundo.R;
import com.saboresdomundo.model.Produto;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder> {

    private final List<Produto> produtos;

    public ProdutoAdapter(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNome, txtQuantidade;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtQuantidade = itemView.findViewById(R.id.txtQuantidade);
        }
    }

    @NonNull
    @Override
    public ProdutoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_produto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoAdapter.ViewHolder holder, int position) {
        Produto produto = produtos.get(position);
        holder.txtNome.setText(produto.getNome());
        holder.txtQuantidade.setText(produto.getQuantidade() + " " + produto.getUnidade());
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }
}