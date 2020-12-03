package com.example.efirpoliceversion;

import android.content.Context;
import android.icu.text.Transliterator;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataActivityAdapter extends  RecyclerView.Adapter<DataActivityAdapter.ViewHolder>  {

    private ArrayList<ComplainModel> mComplains;

    public DataActivityAdapter(ArrayList<ComplainModel> complains){
        mComplains = complains;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public RadioButton rbSolved;
        public TextView name;
        public TextView fatherName;
        public TextView District;
        public TextView Type;
        public TextView Description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rbSolved = (RadioButton) itemView.findViewById(R.id.rbSolved);
            name = (TextView)itemView.findViewById(R.id.name);
            fatherName = (TextView)itemView.findViewById(R.id.fName);
            District = (TextView)itemView.findViewById(R.id.district);
            Type = (TextView)itemView.findViewById(R.id.type);
            Description = (TextView)itemView.findViewById(R.id.desc);

            rbSolved.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View complainView = inflater.inflate(R.layout.item_data_row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(complainView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ComplainModel complain = mComplains.get(position);

        TextView textViewName = holder.name;
        textViewName.setText(complain.name);

        TextView textViewFathersName = holder.fatherName;
        textViewFathersName.setText(complain.fatherName);

        TextView textViewType = holder.Type;
        textViewType.setText(complain.type);

        TextView textViewDistrict = holder.District;
        textViewDistrict.setText(complain.district);

        TextView textViewDesc = holder.Description;
        textViewDesc.setText(complain.description);
    }

    @Override
    public int getItemCount() {
        return mComplains.size();
    }

}
