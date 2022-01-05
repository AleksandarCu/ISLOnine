package com.islonline.mobile.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'testapplication' library on application startup.
    static {
        System.loadLibrary("testapplication");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView output = (TextView) findViewById(R.id.result);
        Button equals = (Button) findViewById(R.id.equals);

        EditText first = (EditText) findViewById(R.id.firstNumber);
        EditText second = (EditText) findViewById(R.id.secondNumber);

        equals.setOnClickListener(view -> {
            int num1 = 0;
            int num2 = 0;
            boolean error = false;

            try {
                num1 = Integer.parseInt(first.getText().toString());
            } catch (Exception e){
                error = true;
                first.setText("");
                first.setHint("Invalid number");
            }

            try {
                num2 = Integer.parseInt(second.getText().toString());
            } catch (Exception e){
                error = true;
                second.setText("");
                second.setHint("Invalid number");
            }

            if(!error){
                output.setText(String.valueOf(sumJNI(num1, num2)));
            }

        });
    }

    /**
     * A native method that is implemented by the 'testapplication' native library,
     * which is packaged with this application.
     */
    public native int sumJNI(int num1, int num2);

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
        if (id == R.id.action_sum) {
            return true;
        } else if (id == R.id.action_login){
            startActivity(new Intent(this, LoginActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}