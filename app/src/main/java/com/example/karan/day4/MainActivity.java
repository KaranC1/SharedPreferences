package com.example.karan.day4;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.karan.day4.R;

public class MainActivity extends AppCompatActivity {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences mSettings;
        mSettings = getSharedPreferences("View", 0);
        a = mSettings.getInt("Red", a);
        b = mSettings.getInt("Yellow", b);
        c = mSettings.getInt("Blue", c);
        d = mSettings.getInt("Green", d);

        final SharedPreferences.Editor editor = mSettings.edit();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Counters have been Reset.", Toast.LENGTH_SHORT).show();
                a=0;
                b=0;
                c=0;
                d=0;
                editor.putInt("Red",0);
                editor.apply();
                editor.putInt("Blue",0);
                editor.apply();
                editor.putInt("Yellow",0);
                editor.apply();
                editor.putInt("Green",0);
                editor.apply();
                }
        });

        View tl = findViewById(R.id.topleft);
        tl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                a++;
                if(a==1)
                    Toast.makeText(MainActivity.this, "Red View Pressed " + a + " Time", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Red View Pressed " + a + " Times", Toast.LENGTH_SHORT).show();
                Log.i("onCreate", "Red View Pressed" + a + " Times");
                editor.putInt("Red", a);
                editor.apply();
            }
        });

        View tr = findViewById(R.id.topright);
        tr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                b++;
                if(b==1)
                    Toast.makeText(MainActivity.this, "Yellow View Pressed " + b + " Time", Toast.LENGTH_SHORT).show();
                else
                Toast.makeText(MainActivity.this, "Yellow View Pressed " + b + " Times", Toast.LENGTH_SHORT).show();
                Log.i("onCreate", "Yellow View Pressed" + b + " Time(s)");
                editor.putInt("Yellow", b);
                editor.apply();
            }
        });

        View bl = findViewById(R.id.botleft);
        bl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c++;
                if(c==1)
                    Toast.makeText(MainActivity.this, "Blue View Pressed " + c + " Time", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Blue View Pressed " + c + " Times", Toast.LENGTH_SHORT).show();
                Log.i("onCreate", "Blue View Pressed " + c + " Time(s)");
                editor.putInt("Blue", c);
                editor.apply();
            }
        });

        View br = findViewById(R.id.botright);
        br.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                d++;
                if(d==1)
                    Toast.makeText(MainActivity.this, "Green View Pressed " + d + " Time", Toast.LENGTH_SHORT).show();
                else
                Toast.makeText(MainActivity.this, "Green View Pressed " + d + " Times", Toast.LENGTH_SHORT).show();
                Log.i("onCreate", "Green View Pressed " + d + " Time(s)");
                editor.putInt("Green", d);
                editor.apply();
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



}
