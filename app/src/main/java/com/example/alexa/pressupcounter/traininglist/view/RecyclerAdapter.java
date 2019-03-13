package com.example.alexa.pressupcounter.traininglist.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexa.pressupcounter.PressUp;
import com.example.alexa.pressupcounter.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>  {

    private List<PressUp> mPressUps;

    public RecyclerAdapter() {
    }

    public List<PressUp> getPressUps() {
        return mPressUps;
    }

    public void setPressUps(List<PressUp> pressUps) {
        mPressUps = pressUps;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mId.setText(String.valueOf(mPressUps.get(position).getId()));

        holder.mId.setText(String.valueOf(mPressUps.get(position).getFirstRepetition()));
        holder.mId.setText(String.valueOf(mPressUps.get(position).getSecondRepetition()));
        holder.mId.setText(String.valueOf(mPressUps.get(position).getThirdRepetition()));
        holder.mId.setText(String.valueOf(mPressUps.get(position).getFourthRepetition()));
        holder.mId.setText(String.valueOf(mPressUps.get(position).getFifthRepetition()));
    }

    @Override
    public int getItemCount() {
        return mPressUps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mId;

        private TextView mFirstRepetition;
        private TextView mSecondRepetition;
        private TextView mThirdRepetition;
        private TextView mFourthRepetition;
        private TextView mFifthRepetition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mId = (TextView) itemView.findViewById(R.id.id_text_view);

            mFirstRepetition = (TextView) itemView.findViewById(R.id.first_repetition_counter);
            mSecondRepetition = (TextView) itemView.findViewById(R.id.second_repetition_counter);
            mThirdRepetition = (TextView) itemView.findViewById(R.id.third_repetition_counter);
            mFourthRepetition = (TextView) itemView.findViewById(R.id.fourth_repetition_counter);
            mFifthRepetition = (TextView) itemView.findViewById(R.id.fifth_repetition_counter);
        }
    }
}
