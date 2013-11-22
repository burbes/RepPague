package br.newm.repague.database;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class RepositorioExec {

	private static final String NOME_BANCO = "repague";

	// Nome da tabela
	public static final String TABELA_TB_LOG_LOCALIZACAO = "tb_log_localizacao";

	// Instancia do banco
	protected SQLiteDatabase db;

	public RepositorioExec(Context ctx) {
		// Abre o banco de dados jï¿½ existente
		db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
	}

	protected RepositorioExec() {
		// Apenas para criar uma subclasse...
	}

	public long inserir(ContentValues valores, String tabela) {
		long id = db.insert(tabela, "", valores);
		return id;
	}

	public int deletar(String tabela, String where) {
		int count = db.delete(tabela, where, null);
		Log.i("delete", "Deletou [" + count + "] registros");
		return count;
	}

	public int deletarTodos(String tabela) {
		int count = db.delete(tabela, null, null);
		Log.i("delete", "Deletou [" + count + "] registros da tabela " + tabela);
		return count;
	}

	// Retorna um cursor com todos os carros
	public Cursor getCursorTodos(String tabela) {
		try {
			// select * from graduando
			return db.query(tabela, null, null, null, null, null, null, null);
		} catch (SQLException e) {
			Log.e("erro getcursor",
					"Erro ao buscar os clientes: " + e.toString());
			return null;
		}
	}

	public Cursor getCursorIndividual(String tabela, String where) {
		try {

			// select * from graduando
			return db.query(tabela, null, where, null, null, null, null, null);
		} catch (SQLException e) {
			Log.e("erro getcursor",
					"Erro ao buscar os clientes: " + e.toString());
			return null;
		}
	}

	public Cursor getCursorSql(String sql) {
		try {

			// select * from graduando
			return db.rawQuery(sql, null);
		} catch (SQLException e) {
			Log.e("erro getcursor",
					"Erro ao buscar os clientes: " + e.toString());
			return null;
		}
	}

	// Fecha o banco
	public void fechar() {
		// fecha o banco de dados
		if (db != null) {
			db.close();
		}
	}

	//fazer a validação do login utilziando isso
	public int verificaHistoricoEtapa(int id_os, int id_etapa) {				
		String sql = "select * from tb_r_os_etapa where id_os ="+id_os+" and id_etapa = "+id_etapa;		
	
		Log.i("Query, verifica Hist", sql);			
		Cursor c = getCursorSql(sql);			
		
		if(c.moveToFirst()) return 0; else return 1;
	}
	
}
