package br.newm.repague;

import br.newm.repage.R;
import br.newm.repage.R.layout;
import br.newm.repage.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class RegistrarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registrar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registrar, menu);
		return true;
	}

}
