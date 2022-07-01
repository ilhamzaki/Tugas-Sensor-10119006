package net.akb.tugas_sensor_1011906.view.about;

// 10119006 - Ilham zaki - IF1

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.akb.tugas_sensor_1011906.models.InformasiItemModel;
import net.akb.tugas_sensor_1011906.R;

import java.util.List;

public class ViewPagerInformasiAdapter extends RecyclerView.Adapter<ViewPagerInformasiAdapter.ViewHolder>{
    List<InformasiItemModel> informasiList;

    public ViewPagerInformasiAdapter(List<InformasiItemModel> informasiList) {
        this.informasiList = informasiList;
    }


    @NonNull
    @Override
    public ViewPagerInformasiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewpager_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerInformasiAdapter.ViewHolder holder, int position) {
        InformasiItemModel informasiItem = informasiList.get(position);
        holder.title.setText(informasiItem.title);
        holder.desc.setText(informasiItem.desc);
    }

    @Override
    public int getItemCount() {
        if(informasiList != null) return informasiList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, desc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_informasi);
            desc = itemView.findViewById(R.id.desc_informasi);
        }
    }
}
