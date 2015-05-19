package com.example.slayer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity  {
	
	private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Log.e("Banana","onCreate!"); 
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    
    @Override
    protected void onResume() {
    	Log.e("Pickle", "onResume"); 
    	mediaPlayer = MediaPlayer.create(this, R.raw.southofheaven);
    	mediaPlayer.start();
    	
    	super.onResume();
    }
    
    @Override
    protected void onPause() {
    	Log.e("Pickle", "onPause"); 
    	mediaPlayer.stop(); 
    	mediaPlayer.release(); 
    	super.onPause();
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


	
	public void openSlayerPage(View v){
		Log.i(DISPLAY_SERVICE, "Button clicked : " + v.getId());
		
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.slayer.net/us/home"));
		startActivity(browserIntent);

	}
	
}


