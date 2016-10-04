package com.sm.ufersa.appcolorsystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.InputFilter;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.sm.ufersa.systems.Color;
import com.sm.ufersa.systems.SystemBase;
import com.sm.ufersa.systems.SystemFactory;
import com.sm.ufersa.utils.InputFilterMinMax;
import com.sm.ufersa.utils.Watcher;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static ImageView backgroundImg;
    final static int[] valueR = {0};
    final static int[] valueG = {0};
    final static int[] valueB = {0};

    private ListView lista;
    private ArrayAdapter<String> arrayAdapter;

    private String[] constSC = new String[]{
            "CMY","XYZ","HSL","HSV","HSB","HSI","YCbCr","YIQ","YUV"
    };

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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Init empty list of conversion result
        initList();

        // Background ImageView
        backgroundImg = (ImageView) findViewById(R.id.imageViewColorResult);
        updateBackgroundImageView();

        // Spinner
        //final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ColorSystem_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        //spinner.setAdapter(adapter);

        // --------
        // SeekBars
        // --------

        SeekBar seekBarR = (SeekBar) findViewById(R.id.seekBarR);
        final EditText[] textViewR = {(EditText) findViewById(R.id.editTextR)};
        textViewR[0].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "255")});
        textViewR[0].setOnFocusChangeListener(new Watcher(textViewR[0],seekBarR));
        seekBarR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //currentValue = progress;
                valueR[0] = progress;
                textViewR[0].setText(Integer.toString(progress));
                updateBackgroundImageView();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        SeekBar seekBarG = (SeekBar) findViewById(R.id.seekBarG);
        final EditText[] textViewG = {(EditText) findViewById(R.id.editTextG)};
        textViewG[0].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "255")});
        textViewG[0].setOnFocusChangeListener(new Watcher(textViewG[0],seekBarG));
        seekBarG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //currentValue = progress;
                valueG[0] = progress;
                textViewG[0].setText(Integer.toString(progress));
                updateBackgroundImageView();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        SeekBar seekBarB = (SeekBar) findViewById(R.id.seekBarB);
        final EditText[] textViewB = {(EditText) findViewById(R.id.editTextB)};
        textViewB[0].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "255")});
        textViewB[0].setOnFocusChangeListener(new Watcher(textViewB[0],seekBarB));
        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                valueB[0] = progress;
                textViewB[0].setText(Integer.toString(progress));
                updateBackgroundImageView();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        // ------
        // Button
        // ------

        Button btnConvert = (Button) findViewById(R.id.buttonConvert);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Exibir todas as conversões.
                fillList();
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static void updateBackgroundImageView(){
        backgroundImg.setBackgroundColor(android.graphics.Color.rgb(valueR[0], valueG[0], valueB[0]));
        //backgroundImg.invalidate();
    }

    private void initList(){
        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        arrayAdapter = new ArrayAdapter<>(
                getBaseContext(),
                R.layout.content_list_result_systemcolor,
                R.id.resultConversion );

        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(arrayAdapter);
    }

    private void fillList(){
        arrayAdapter.clear();

        for (String sc : constSC) {

            String systemColorName = sc; //spinner.getSelectedItem().toString();
                    SystemBase systemColor = SystemFactory.getInstance(systemColorName);
            Color c = systemColor.convert(new Color(valueR[0], valueG[0], valueB[0]));

            arrayAdapter.add(systemColor.printResult(c));

            //AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            //builder.setMessage(systemColor.printResult(c))
            //        .setCancelable(false)
            //       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            //            public void onClick(DialogInterface dialog, int id) {
            //                //do things
            //            }
            //        });
            //AlertDialog alert = builder.create();
            //alert.show();
        }

        arrayAdapter.notifyDataSetChanged();
    }

}
