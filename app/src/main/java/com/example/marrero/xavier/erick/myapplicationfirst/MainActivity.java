package com.example.marrero.xavier.erick.myapplicationfirst;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

//    TextView campo_text;

    TextView text;
    EditText editText;
    Button boton1, boton2, boton3, boton4;

    ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        text = (TextView) findViewById(R.id.texto);
        editText = (EditText) findViewById(R.id.text1);
        boton1 = (Button) findViewById(R.id.boton);
        boton2 = (Button) findViewById(R.id.boton1);
        boton3 = (Button) findViewById(R.id.boton3);
        boton4 = (Button) findViewById(R.id.boton4);

        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
        boton4.setOnClickListener(this);
        //campo_text= (TextView) findViewById(R.id.texto);
        //campo_text.setText("Un cambio en el texto");


        Bandas bandas_data[] = new Bandas[]{
                new Bandas(R.drawable.ic_launcher, "Coldplay"),
                new Bandas(R.drawable.ic_launcher, "Foo Figthers"),
                new Bandas(R.drawable.ic_launcher, "The Killers"),
                new Bandas(R.drawable.ic_launcher, "Red Hot Chili"),
                new Bandas(R.drawable.ic_launcher, "Nirvana"),
                new Bandas(R.drawable.ic_launcher, "Pearl Jam"),
                new Bandas(R.drawable.ic_launcher, "Blink 182"),
                new Bandas(R.drawable.ic_launcher, "Asian Kung Fu Gen"),
                new Bandas(R.drawable.ic_launcher, "Foo Figthers"),
                new Bandas(R.drawable.ic_launcher, "The Killers"),
                new Bandas(R.drawable.ic_launcher, "Red Hot Chili"),
                new Bandas(R.drawable.ic_launcher, "Nirvana"),
                new Bandas(R.drawable.ic_launcher, "Pearl Jam"),
                new Bandas(R.drawable.ic_launcher, "Blink 182"),
        };

        BandasAdapter adapter = new BandasAdapter(this, R.layout.listview_item_row, bandas_data);

        lv= (ListView) findViewById(R.id.lv);

        View header = (View) getLayoutInflater().inflate(R.layout.list_header_row, null);
        lv.addHeaderView(header);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView) view.findViewById(R.id.tv);
                Toast.makeText(getApplicationContext(), v.getText(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton:
                String dato = editText.getText().toString();
                text.setText(dato);

                break;

            case R.id.boton1:

                text.setText("Presionaste el segundo boton");
                break;

            case R.id.boton3:
                Toast.makeText(getApplicationContext(), "Esto es un Toast", Toast.LENGTH_SHORT).show();
                break;

            case R.id.boton4:
                String datos = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("DATOS", datos);
                startActivity(intent);
                break;



        }
    }
}
