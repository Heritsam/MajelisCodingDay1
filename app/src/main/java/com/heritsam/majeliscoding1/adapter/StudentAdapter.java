//package com.heritsam.majeliscoding1.adapter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.heritsam.majeliscoding1.R;
//import com.heritsam.majeliscoding1.model.Student;
//
//import java.util.ArrayList;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
//
//    private ArrayList<Student> list;
//
//    public StudentAdapter(ArrayList<Student> list) {
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_student, parent, false);
//        return new ViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.textName.setText(list.get(position).getNama());
//        holder.textReligion.setText(list.get(position).getAgama());
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        @BindView(R.id.textName)
//        TextView textName;
//        @BindView(R.id.textReligion)
//        TextView textReligion;
//        @BindView(R.id.contentLayout)
//        RelativeLayout contentLayout;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//        }
//    }
//}