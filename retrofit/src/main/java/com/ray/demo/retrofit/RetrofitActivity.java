package com.ray.demo.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ray on 16/3/10.
 */
public class RetrofitActivity extends AppCompatActivity {
    Retrofit retrofit;

    EditText inputEdt;

    TextView consoleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_sample);
        inputEdt = (EditText) findViewById(R.id.input);
        consoleTv = (TextView) findViewById(R.id.console_tv);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        findViewById(R.id.fire).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GitAPI service = retrofit.create(GitAPI.class);
                Call<GitModel> call = service.getFeed(inputEdt.getText().toString());

                call.enqueue(new Callback<GitModel>() {
                    @Override
                    public void onResponse(Call<GitModel> call, Response<GitModel> response) {
                        String content = new Gson().toJson(response.body());
                        consoleTv.setText(content);
                        Log.d("", content);
                    }

                    @Override
                    public void onFailure(Call<GitModel> call, Throwable t) {

                    }
                });
            }
        });
    }
}
