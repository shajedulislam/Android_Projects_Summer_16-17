package com.example.dx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Launcher extends Activity implements View.OnClickListener {
	
	Button btnlnc;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		
		btnCast();
        btnlnc.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		if(v.getId()==R.id.btnLnc)
		{			
			
			setContentView(new GamePlay(this));
		}
		
	}
	
	public void btnCast()
    {
    	// = (TextView) findViewById(R.id.display);
    	btnlnc = (Button) findViewById(R.id.btnLnc);
    }
}
