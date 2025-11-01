package com.saboresdomundo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.saboresdomundo.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class EstoqueRepository {

    private final DatabaseHelper dbHelper;

    public EstoqueRepository(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void inserirProduto(Produto produto) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NOME, produto.getNome());
        values.put(DatabaseHelper.COLUMN_CATEGORIA, produto.getCategoria());
        values.put(DatabaseHelper.COLUMN_QUANTIDADE, produto.getQuantidade());
        values.put(DatabaseHelper.COLUMN_UNIDADE, produto.getUnidade());

        db.insert(DatabaseHelper.TABLE_PRODUTOS, null, values);
        db.close();
    }

    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_PRODUTOS, null);

        if (cursor.moveToFirst()) {
            do {
                Produto produto = new Produto();
                produto.setId(cursor.getInt(0));
                produto.setNome(cursor.getString(1));
                produto.setCategoria(cursor.getString(2));
                produto.setQuantidade(cursor.getInt(3));
                produto.setUnidade(cursor.getString(4));

                produtos.add(produto);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return produtos;
    }
}