package com.example.retrofitrxjava;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.retrofitrxjava.databinding.ActivityMainBinding;
import com.example.retrofitrxjava.retrofit.ApiInterface;
import com.example.retrofitrxjava.retrofit.ResponseData;
import com.example.retrofitrxjava.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private CompositeDisposable mCompositeDisposable;

    private ActivityMainBinding binding;

    private ResponseData responseData;

    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mCompositeDisposable = new CompositeDisposable();

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadJSON();
    }

    private void loadJSON() {

        mCompositeDisposable.add(apiInterface.getUserDetails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError));
    }

    private void handleResponse(ResponseData responseData) {
        binding.recyclerView.setAdapter(new DataAdapter(responseData));
    }

    private void handleError(Throwable error) {

        Toast.makeText(this, "Error " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }
}