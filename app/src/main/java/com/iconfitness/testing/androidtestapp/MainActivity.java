package com.iconfitness.testing.androidtestapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    RelativeLayout motorTestButton;
    RelativeLayout bleTestButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        motorTestButton = (RelativeLayout) findViewById(R.id.motorTestLayout);
        motorTestButton.setOnClickListener(selectMotorTest);

        bleTestButton = (RelativeLayout) findViewById(R.id.bleTestLayout);
        bleTestButton.setOnClickListener(selectBLETest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        setTitle("Test Applications");
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

    View.OnClickListener selectMotorTest = new View.OnClickListener(){
        public void onClick(View v) {
            MessageBox("Motor Test");
            Intent intent = new Intent(MainActivity.this, Motor_Test_Screen.class);
            startActivity(intent);
        }
    };

    View.OnClickListener selectBLETest = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MessageBox("BLE Test");
            Intent intent = new Intent(MainActivity.this, BLE_Test_Screen.class);
            startActivity(intent);
        }
    };

    public void MessageBox(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

}