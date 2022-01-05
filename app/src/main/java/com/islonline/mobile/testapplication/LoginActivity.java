package com.islonline.mobile.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.islonline.mobile.testapplication.retrofit.APIClient;
import com.islonline.mobile.testapplication.retrofit.APIInterface;
import com.islonline.mobile.testapplication.retrofit.User;
import com.islonline.mobile.testapplication.retrofit.UserRes;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.login);

        TextView sid = (TextView) findViewById(R.id.sid);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        login.setOnClickListener(view -> {
            User user = new User(username.getText().toString(), password.getText().toString());

            Call<UserRes> call = apiInterface.getSid("utils/login/1", user);
            call.enqueue(new Callback<UserRes>() {
                @Override
                public void onResponse(Call<UserRes> call, Response<UserRes> response) {
                    Log.d("TAG",response.code()+"");
                    if (response.body() != null) {
                        if(response.body().getData() != null){
                            sid.setText(response.body().getData().getSid());
                        }else{
                            sid.setText("Incorrect username or password.");
                        }
                    }else{
                        sid.setText("Incorrect username or password.");
                    }
                }

                @Override
                public void onFailure(Call<UserRes> call, Throwable t) {
                    Log.d("TAG",t.toString()+"");
                    call.cancel();
                }
            });
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
        if (id == R.id.action_sum) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.action_login){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}