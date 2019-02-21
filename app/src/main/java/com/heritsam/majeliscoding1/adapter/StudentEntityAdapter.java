package com.heritsam.majeliscoding1.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.heritsam.majeliscoding1.R;
import com.heritsam.majeliscoding1.activity.student.StudentActivity;
import com.heritsam.majeliscoding1.activity.student.add.AddStudentActivity;
import com.heritsam.majeliscoding1.database.DataHelper;
import com.heritsam.majeliscoding1.database.table.StudentEntity;

import java.io.Serializable;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentEntityAdapter extends RecyclerView.Adapter<StudentEntityAdapter.ViewHolder> {

    private List<StudentEntity> list;
    private Context context;
    private DataHelper dataHelper;

    public StudentEntityAdapter(Context context, List<StudentEntity> list) {
        this.context = context;
        this.list = list;

        dataHelper = Room.databaseBuilder(context, DataHelper.class, "school")
                .allowMainThreadQueries()
                .build();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_student, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textNis.setText(list.get(position).getNis());
        holder.textName.setText(list.get(position).getName());
        holder.contentLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Warning")
                        .setMessage("Apakah anda yakin ingin menghapusnya?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dataHelper.studentDao().delete(list.get(position));
                                list.remove(position);
                                notifyItemRemoved(position);
                                notifyItemRangeRemoved(position, getItemCount() - 1);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();

                return false;
            }
        });

        holder.contentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddStudentActivity.class);
                intent.putExtra("datas", list.get(position));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textNis)
        TextView textNis;
        @BindView(R.id.textName)
        TextView textName;
        @BindView(R.id.contentLayout)
        LinearLayout contentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}