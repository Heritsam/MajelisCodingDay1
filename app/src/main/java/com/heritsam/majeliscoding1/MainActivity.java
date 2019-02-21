package com.heritsam.majeliscoding1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.heritsam.majeliscoding1.activity.student.StudentActivity;
import com.heritsam.majeliscoding1.helper.DataConfig;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.inputEmail)
    TextInputEditText inputEmail;
    @BindView(R.id.inputPassword)
    TextInputEditText inputPassword;
    @BindView(R.id.buttonSignIn)
    Button buttonSignIn;
    @BindView(R.id.layoutEmail)
    TextInputLayout layoutEmail;
    @BindView(R.id.layoutPassword)
    TextInputLayout layoutPassword;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonSignIn)
    public void onViewClicked() {
        DataConfig.setLogin(this);
        intent = new Intent(this, StudentActivity.class);
        startActivity(intent);
    }
}
