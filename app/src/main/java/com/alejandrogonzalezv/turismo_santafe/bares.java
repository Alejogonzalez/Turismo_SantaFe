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


public class bares extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bares);
        final Spinner listah = (Spinner) findViewById(R.id.listabares);
        final ImageView img1 = (ImageView) findViewById(R.id.img1);
        final ImageView img2 = (ImageView) findViewById(R.id.img2);
        final ImageView titulo = (ImageView)findViewById(R.id.imgtitulo);
        final TextView info = (TextView) findViewById(R.id.txinfo);



// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.bares_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        listah.setAdapter(adapter);

        listah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String hotel = String.valueOf(listah.getSelectedItem());

                if(position == 0){
                    titulo.setImageResource(R.drawable.bar1titulo);
                    img1.setImageResource(R.drawable.bar1img1);
                    img2.setImageResource(R.drawable.bar1img2);
                    info.setText(getResources().getString(R.string.bar1));
                }
                if(position==1){
                    titulo.setImageResource(R.drawable.bar2titulo);
                    img1.setImageResource(R.drawable.bar2img1);
                    img2.setImageResource(R.drawable.bar2img2);
                    info.setText(getResources().getString(R.string.bar2));
                }
                if(position==2){
                    titulo.setImageResource(R.drawable.bar3titulo);
                    img1.setImageResource(R.drawable.bar3img1);
                    img2.setImageResource(R.drawable.bar3img2);
                    info.setText(getResources().getString(R.string.bar3));
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
        getMenuInflater().inflate(R.menu.menu_bares, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if(id==R.id.actaboutus){
            Intent a = new Intent(this,AboutUs.class);
            startActivity(a);
            return true;
        }
        if(id==R.id.acthoteles){
            Intent h = new Intent(this,hoteles.class);
            startActivity(h);
            return true;
        }
        if(id==R.id.actmain){
            Intent m = new Intent(this,MainActivity.class);
            startActivity(m);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
