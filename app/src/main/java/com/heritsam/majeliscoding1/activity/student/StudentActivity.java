package com.heritsam.majeliscoding1.activity.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.heritsam.majeliscoding1.MainActivity;
import com.heritsam.majeliscoding1.R;
import com.heritsam.majeliscoding1.activity.student.add.AddStudentActivity;
import com.heritsam.majeliscoding1.adapter.StudentEntityAdapter;
import com.heritsam.majeliscoding1.database.DataHelper;
import com.heritsam.majeliscoding1.helper.DataConfig;
import com.heritsam.majeliscoding1.model.Student;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StudentActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.buttonLogout)
    MaterialButton buttonLogout;
    @BindView(R.id.buttonTambah)
    MaterialButton buttonTambah;
    private Student student;
    private ArrayList<Student> list;
    private Intent intent;

    private DataHelper dataHelper;
    private StudentEntityAdapter studentEntityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        ButterKnife.bind(this);
    }


    @Override
    protected void onResume() {
        super.onResume();

        dataHelper = Room.databaseBuilder(this, DataHelper.class, "school")
                .allowMainThreadQueries()
                .build();

        studentEntityAdapter = new StudentEntityAdapter(this, dataHelper.studentDao().select());

        recyclerView.setAdapter(studentEntityAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @OnClick({R.id.buttonLogout, R.id.buttonTambah})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonLogout:
                DataConfig.setLogout(this);
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.buttonTambah:
                startActivity(new Intent(this, AddStudentActivity.class));
                break;
        }
    }
}
