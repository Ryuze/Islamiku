package com.example.islamiku.cerpen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamiku.R;
import com.example.islamiku.holder.MainHolder;
import com.example.islamiku.model.ModelCerpen;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainHolder> {

    public List<ModelCerpen> modelMainList;
    private Context mContext;
    private MainAdapter.onSelectData onSelectData;

    public interface onSelectData {
        void onSelected(ModelCerpen modelMain);
    }

    public MainAdapter(Context context, List<ModelCerpen> android, MainAdapter.onSelectData onSelectData) {
        this.mContext = context;
        this.modelMainList = android;
        this.onSelectData = onSelectData;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, viewGroup, false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(MainHolder viewHolder, int i) {

        final ModelCerpen mc = modelMainList.get(i);

        viewHolder.txtName.setText(mc.getName());
        viewHolder.cvList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectData.onSelected(mc);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelMainList.size();
    }

}
