package com.afq.formum.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afq.formum.Model.User;
import com.afq.formum.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<User> mValues;
    private Context mContext;

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);

    }


    public RecyclerViewAdapter(ArrayList<User> mValues, Context mContext) {
        this.mValues = mValues;
        this.mContext = mContext;

    }

    public void OnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.txtDesc.setText(mValues.get(position).getDesc());
        holder.txtName.setText(mValues.get(position).getName());
        holder.txtRate.setText(String.valueOf(mValues.get(position).getRate()));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtDesc;
        TextView txtName;
        TextView txtRate;

        public ViewHolder(View view) {
            super(view);

            txtDesc = view.findViewById(R.id.txtDesc);
            txtName = view.findViewById(R.id.txtName);
            txtRate = view.findViewById(R.id.txtRate);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }

        @Override
        public String toString() {
            return super.toString() + " '";
        }
    }
}
