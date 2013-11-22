package br.newm.repague.database;

import org.json.JSONArray;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils.StringSplitter;
import android.util.Log;

/**
 * Implementacao de SQLiteOpenHelper
 * 
 * Classe utilitï¿½ria para abrir, criar, e atualizar o banco de dados
 * 
 * @author ricardo
 */
class SQLiteHelper extends SQLiteOpenHelper {

	private static final String CATEGORIA = "repague";

	private String[] scriptSQLCreate;
	private JSONArray scriptSQLUpdate;

	/**
	 * Cria uma instï¿½ncia de SQLiteHelper
	 * 
	 * @param context
	 * @param nomeBanco
	 *            nome do banco de dados
	 * @param versaoBanco
	 *            versï¿½o do banco de dados (se for diferente ï¿½ para
	 *            atualizar)
	 * @param scriptSQLCreate
	 *            SQL com o create table..
	 * @param scriptSQLDelete
	 *            SQL com o drop table...
	 */
	SQLiteHelper(Context context, String nomeBanco, int versaoBanco,
			String[] scriptSQLCreate, JSONArray scriptSQLUpdate) {
		super(context, nomeBanco, null, versaoBanco);
		this.scriptSQLCreate = scriptSQLCreate;
		this.scriptSQLUpdate = scriptSQLUpdate;
	}

	@Override
	// Criar novo banco...
	public void onCreate(SQLiteDatabase db) {
		Log.i(CATEGORIA, "Criando banco com sql");
		int qtdeScripts = scriptSQLCreate.length;

		// Executa cada sql passado como parï¿½metro
		for (int i = 0; i < qtdeScripts; i++) {
			String sql = scriptSQLCreate[i];
			Log.i(CATEGORIA, sql);
			// Cria o banco de dados executando o script de criaï¿½ï¿½o
			db.execSQL(sql);
		}

		onUpgrade(db, 0, 0);
	}

	@Override
	// Mudou a versï¿½o...
	public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int novaVersao) {

		Log.w(CATEGORIA, "Atualizando da versão " + versaoAntiga + " para "
				+ novaVersao + ". Todos os registros serãoo atualizados.");

		// Log.i(CATEGORIA, scriptSQLDelete.length);
		try {
			for (int i = 0; i < scriptSQLUpdate.length(); i++) {

				if (versaoAntiga == 0 && novaVersao == 0) {

					String sql = scriptSQLUpdate.getJSONObject(i)
							.getString("alteracao");

					// Log.i(CATEGORIA, sql);
					// Cria o banco de dados executando o script de
					// criaï¿½ï¿½o
					db.execSQL(sql);
					
				} else {
 
					int versao = scriptSQLUpdate.getJSONObject(i).getInt(
							"versao");

					if (versao == novaVersao) {
						String sql = scriptSQLUpdate.getJSONObject(i)
								.getString("alteracao");

						// Log.i(CATEGORIA, sql);
						// Cria o banco de dados executando o script de
						// criaï¿½ï¿½o
						db.execSQL(sql);
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}