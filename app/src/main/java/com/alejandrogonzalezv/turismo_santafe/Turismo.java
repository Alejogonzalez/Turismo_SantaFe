package com.alejandrogonzalezv.turismo_santafe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class Turismo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turismo);
        final Spinner listat = (Spinner) findViewById(R.id.listaturismo);
        final ImageView img1 = (ImageView) findViewById(R.id.img1);
        final ImageView img2 = (ImageView) findViewById(R.id.img2);
        final ImageView titulo = (ImageView)findViewById(R.id.imgtitulo);
        final TextView info = (TextView) findViewById(R.id.txinfo);



// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.turis_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        listat.setAdapter(adapter);

        listat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String turis = String.valueOf(listat.getSelectedItem());

                if(position == 0){
                    titulo.setImageResource(R.drawable.turis1titulo);
                    img1.setImageResource(R.drawable.turis1img1);
                    img2.setImageResource(R.drawable.turis1img2);
                    info.setText(getResources().getString(R.string.turis1));
                }
                if(position==1){
                    titulo.setImageResource(R.drawable.turis2titulo);
                    img1.setImageResource(R.drawable.turis2img1);
                    img2.setImageResource(R.drawable.turis2img2);
                    info.setText(getResources().getString(R.string.turis2));
                }
                if(position==2){
                    titulo.setImageResource(R.drawable.turis3titulo);
                    img1.setImageResource(R.drawable.turis3img1);
                    img2.setImageResource(R.drawable.turis3img2);
                    info.setText(getResources().getString(R.string.turis3));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_turismo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id==R.id.acthoteles){
            Intent h = new Intent(this,hoteles.class);
            startActivity(h);
            return true;
        }
        if(id==R.id.actaboutus){
            Intent a = new Intent(this,AboutUs.class);
            startActivity(a);
            return true;
        }
        if(id==R.id.actbares){
            Intent b = new Intent(this,bares.class);
            startActivity(b);
            return true;
        }
        if(id==R.id.actmain){
            Intent m = new Intent(this,MainActivity.class);
            startActivity(m);
            return true;
        }
        if(id==R.id.actinfo){
            Intent t = new Intent(this,informacion.class);
            startActivity(t);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
