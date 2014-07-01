package com.example.lab3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);

		
		
		
	       
	       Button button = (Button) findViewById(R.id.button1);
	         
	       Button button1 = (Button) findViewById(R.id.button2);
	       
	       Button button2 = (Button) findViewById(R.id.button3);
	       
	       Button button3 = (Button) findViewById(R.id.button4);
	    
	       
	        button.setOnClickListener(new View.OnClickListener() {
	        	
	        	@Override
	            public void onClick(View v) {
	                 
	        		  EditText et = (EditText) findViewById(R.id.editText1);
	        	   		EditText et1 = (EditText) findViewById(R.id.editText2);
	        	   		String theText = et.getText().toString();
	        	   		String theText1 = et1.getText().toString();
	        		url = "http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbaseCreate/"+theText+"/"+theText1;
	        		
	            	//Toast.makeText(getBaseContext(), theText, Toast.LENGTH_SHORT).show();
	            	Intent intent = new Intent(Intent.ACTION_VIEW); 
	       			     intent.setData(Uri.parse(url));
	       			startActivity(intent);
	            	
	            }
	        });
	       
	       button1.setOnClickListener(new View.OnClickListener() {
	        	
	        	@Override
	            public void onClick(View v) {
	                 
	        		  EditText et = (EditText) findViewById(R.id.editText1);
	        	   		EditText et1 = (EditText) findViewById(R.id.editText2);
	        	   		String theText = et.getText().toString();
	        	   		String theText1 = et1.getText().toString();
	        		url = "http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbaseInsert/"+theText+"/-home-group6-sensor.txt/"+theText1;
	        		
	            	//Toast.makeText(getBaseContext(), theText, Toast.LENGTH_SHORT).show();
	            	Intent intent = new Intent(Intent.ACTION_VIEW); 
	       			     intent.setData(Uri.parse(url));
	       			startActivity(intent);
	            	
	            }
	        });
	       
	       button2.setOnClickListener(new View.OnClickListener() {
	        	
	        	@Override
	            public void onClick(View v) {
	                 
	        		  EditText et = (EditText) findViewById(R.id.editText3);
	        	   		//EditText et1 = (EditText) findViewById(R.id.editText2);
	        	   		String theText = et.getText().toString();
	        	   		//String theText1 = et1.getText().toString();
	        		url = "http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbaseRetrieveAll/"+theText;
	        		
	            	//Toast.makeText(getBaseContext(), theText, Toast.LENGTH_SHORT).show();
	            	Intent intent = new Intent(Intent.ACTION_VIEW); 
	       			     intent.setData(Uri.parse(url));
	       			startActivity(intent);
	            	
	            }
	        });
	       
	       button3.setOnClickListener(new View.OnClickListener() {
	        	
	        	@Override
	            public void onClick(View v) {
	                 
	        		  EditText et = (EditText) findViewById(R.id.editText3);
	        	   		//EditText et1 = (EditText) findViewById(R.id.editText2);
	        	   		String theText = et.getText().toString();
	        	   		//String theText1 = et1.getText().toString();
	        		url = "http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbasedeletel/"+theText;
	        		
	            	//Toast.makeText(getBaseContext(), theText, Toast.LENGTH_SHORT).show();
	            	Intent intent = new Intent(Intent.ACTION_VIEW); 
	       			     intent.setData(Uri.parse(url));
	       			startActivity(intent);
	            	
	            }
	        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
