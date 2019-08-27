package com.lighttest.guildwarspicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {


    int[] primeNumbers =  {2, 3, 5, 7, 11, 13};

    TextView textView;
    ImageView imageView;
    Spinner dropdown;
    Button nowButton;
    Button addButton;
    Button removeButton;
    ListView listView;

    List<String> list;
    Random r = new Random();
    int n = 10;


    public void addButton (View view){
        String choice = dropdown.getSelectedItem().toString();

        list.add(choice);
        n = n + 1;


        Toast.makeText(this, "Added " + choice + " " + Integer.toString(n), Toast.LENGTH_SHORT).show();
        textView.setText(list.toString());
    }

    public void removeButton (View view){
        String choice = dropdown.getSelectedItem().toString();

        list.remove(choice);
        n = n - 1;



        Toast.makeText(this, "Removed " + choice + " " + Integer.toString(n), Toast.LENGTH_SHORT).show();
        textView.setText(list.toString());
    }


    public void nowButton(View view){
        int random = r.nextInt(n);

       // Toast.makeText(this, "" + list.get(random).toString() + " (" + Integer.toString(random)+ ")", Toast.LENGTH_SHORT).show();

       // textView.setText(" " + Integer.toString(random));
        textView.setText(" " + list.get(random).toString());

        if( list.get(random).toString() == "Fractals" ){ // fractals 0
            imageView.setImageResource(R.drawable.fractals);
        } else if ( list.get(random).toString() == "Dungeons"  ) { // dungeons  1
            imageView.setImageResource(R.drawable.dungeons);
        } else if ( list.get(random).toString() == "World Bosses" ) { // world bosses  2
            imageView.setImageResource(R.drawable.worldbosses);
        } else if ( list.get(random).toString() == "Masteries" ) { // masteries  3
            imageView.setImageResource(R.drawable.masteries);
        } else if ( list.get(random).toString() == "PvP" ) { // PvP  4
            imageView.setImageResource(R.drawable.pvp);
        } else  if ( list.get(random).toString() == "WvW" ){ // WvW  5
            imageView.setImageResource(R.drawable.wvw);
        } else if ( list.get(random).toString() == "Raids" ) { // raids  6
            imageView.setImageResource(R.drawable.raids);
        } else if ( list.get(random).toString() == "Collections" ) { // collections 7
            imageView.setImageResource(R.drawable.collections);
        } else if ( list.get(random).toString() == "Hero Points" ) {  // hero points 8
            imageView.setImageResource(R.drawable.heropoints);
        } else if ( list.get(random).toString() == "Map Completion" ) {  // worldcompletion 9
            imageView.setImageResource(R.drawable.worldcompletion);
        }


        addButton.setVisibility(View.INVISIBLE);
        removeButton.setVisibility(View.INVISIBLE);
        dropdown.setVisibility(View.INVISIBLE);

    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        nowButton = (Button) findViewById(R.id.nowButton);
        addButton = (Button) findViewById(R.id.addButton);
        removeButton = (Button) findViewById(R.id.removeButton);
        dropdown = (Spinner) findViewById(R.id.spinnerChoice);
        listView = (ListView) findViewById(R.id.listChoice);


        String[] picks = new String[]{
                "Fractals",
                "Dungeons",
                "World Bosses",
                "Masteries",
                "PvP",
                "WvW",
                "Raids",
                "Collections",
                "Hero Points",
                "Map Completion"
        };


        // instead of making arraylist and adding them list.add one by one, used an array "picks", put them all in the spinner, and made "choice" be removed/added using list.add/remove
        list = new  ArrayList<>(Arrays.asList(picks));


        //create a list of items for the spinner.
            //  String[] items = new String[]{"\"Fractals\"", "\"Dungeons\"","\"World Bosses\"", "\"Masteries\"", "\"PvP\"", "\"WvW\"", "Raids", "\"Collections\"", "\"Hero Points\"", "\"Map Completion\""};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, picks);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        listView.setAdapter(adapter);


        /**
        Boolean Fractals = true;
        Boolean Dungeons = true;
        Boolean Masteries = true;
        Boolean PvP = true;
        Boolean WvW = true;
        Boolean Raids = true;
        Boolean Collections = true;
        Boolean HeroPoints = true;
        Boolean MapCompletion = true;
        **/

        /**
         list.add("Fractals"); // 0
         list.add("Dungeons"); // 1
         list.add("World Bosses"); // 2
         list.add("Masteries"); // 3
         list.add("PvP"); // 4
         list.add("WvW"); // 5
         list.add("Raids"); // 6
         list.add("Collections"); // 7
         list.add("Hero Points"); // 8
         list.add("Map Completion"); // 9
         **/




        Toast.makeText(this, "" + list.toString(), Toast.LENGTH_SHORT).show();

    }
}
