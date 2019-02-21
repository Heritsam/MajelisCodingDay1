package com.heritsam.majeliscoding1.activity.student.add;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.heritsam.majeliscoding1.R;
import com.heritsam.majeliscoding1.database.DataHelper;
import com.heritsam.majeliscoding1.database.table.StudentEntity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddStudentActivity extends AppCompatActivity {

    @BindView(R.id.inputNis)
    TextInputEditText inputNis;
    @BindView(R.id.layoutNis)
    TextInputLayout layoutNis;
    @BindView(R.id.inputName)
    TextInputEditText inputName;
    @BindView(R.id.layoutName)
    TextInputLayout layoutName;
    @BindView(R.id.buttonTambah)
    MaterialButton buttonTambah;

    private DataHelper dataHelper;
    private StudentEntity studentEntity, datas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);
        ButterKnife.bind(this);

        dataHelper = Room.databaseBuilder(this, DataHelper.class, "school")
                .allowMainThreadQueries()
                .build();

        datas = (StudentEntity) getIntent().getSerializableExtra("datas");

        if (datas != null) {
            inputNis.setText(datas.getNis());
            inputName.setText(datas.getName());

            buttonTambah.setText("Update");
        }
    }

    @OnClick(R.id.buttonTambah)
    public void onViewClicked() {

        String nis = inputNis.getText().toString();
        String name = inputName.getText().toString();
        if (nis.isEmpty()) {
            layoutNis.setError("Required");
            return;
        }

        if (name.isEmpty()) {
            layoutName.setError("Required");
            return;
        }

        if (datas != null) {

            datas.setNis(inputNis.getText().toString());
            datas.setName(inputName.getText().toString());

            dataHelper.studentDao().update(datas);
        } else {

            studentEntity = new StudentEntity();

            studentEntity.setNis(nis);
            studentEntity.setName(name);

            dataHelper.studentDao().insert(studentEntity);
        }

        Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();

        finish();
    }
}
