package br.newm.repague.database;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;

public class RepositorioScript extends RepositorioExec {

	// private static final String[] SCRIPT_DATABASE_DELETE = new String[] {
	// "DROP TABLE IF EXISTS tb_usuario;", };

	private static final String[] SCRIPT_DATABASE_CREATE = new String[] {
			" CREATE TABLE tb_usuarios (id_usuario, nome, email, senha, id_perfil); ",
			" CREATE TABLE tb_perfil (id_perfil, descricao);",
			" CREATE TABLE tb_republicas (id_republica, nome, id_faculdade);",
			" CREATE TABLE tb_republicas_usuario (id_usuario, id_republica);",
			" CREATE TABLE tb_cidades (id_cidade, nome);",
			" CREATE TABLE tb_faculdades (id_faculdade, nome, id_cidade);",
			" CREATE TABLE tb_dividas (id_divida, de, para, comentario, data, valor, conta_fixa);",
			" CREATE TABLE tb_solicitacoes (id_solicitacao, id_usuario, id_republica);",
			" insert into tb_usuarios (id_perfil, descricao) values (1,'teste')",
			" insert into tb_usuarios (nome, email, senha, id_perfil) values ('teste', 'teste', 'teste', 1)",

	};

	// STRING/QUERY DE ALTERAÇÃO
	// private static final String[] SCRIPT_DATABASE_UPDATE = new String[] { " "
	// };
	private JSONArray script_database_update = new JSONArray();

	// OBJ AUXILIAR PARA ENVIAR OS DADOS DE ALTERAÇÃO
	private JSONObject script_database_update_aux = new JSONObject();

	private static final String NOME_BANCO = "repague";

	private static final int VERSAO_BANCO = 1;

	private SQLiteHelper dbHelper;

	public RepositorioScript(Context ctx) throws Exception{
		// --------------
		script_database_update_aux.put("alteracao",
				" ALTER TABLE tb_usuario add hahaha varchar(10) ;");
					
		script_database_update_aux.put("versao", 2);
		
		script_database_update.put(script_database_update_aux);
		

		// --------------
		script_database_update_aux = new JSONObject();

		script_database_update_aux.put("alteracao",
				" ALTER TABLE tb_usuario add hehehe varchar(10) ;");
					
		script_database_update_aux.put("versao", 3);

		script_database_update.put(script_database_update_aux);
		
		script_database_update_aux = new JSONObject();

		script_database_update_aux.put("alteracao",
				" ALTER TABLE tb_perfil add hehehe varchar(10) ;");
					
		script_database_update_aux.put("versao", 3);

		script_database_update.put(script_database_update_aux);

		// --------------
		
		dbHelper = new SQLiteHelper(ctx, RepositorioScript.NOME_BANCO,
				RepositorioScript.VERSAO_BANCO,
				RepositorioScript.SCRIPT_DATABASE_CREATE,
				script_database_update);

		if (dbHelper != null) {
			db = dbHelper.getWritableDatabase();
		}
	}

	@Override
	public void fechar() {
		super.fechar();

		if (dbHelper != null) {
			dbHelper.close();
		}
	}

}