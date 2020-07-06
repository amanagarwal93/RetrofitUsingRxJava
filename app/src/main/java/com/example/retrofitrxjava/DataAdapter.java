package com.example.retrofitrxjava;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitrxjava.databinding.RecyclerRowBinding;
import com.example.retrofitrxjava.retrofit.ResponseData;

import org.jetbrains.annotations.NotNull;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ResponseData responseData;

    public DataAdapter(ResponseData data) {
        responseData = data;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {

        RecyclerRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_row, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResponseData.UserData userData = responseData.getData().get(position);
        holder.binding.employeeId.setText(userData.getId());
        holder.binding.employeeName.setText(userData.getEmployeeName());
        holder.binding.employeeAge.setText(userData.getEmployeeAge());
    }

    @Override
    public int getItemCount() {
        return responseData.getData().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public RecyclerRowBinding binding;

        public ViewHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
