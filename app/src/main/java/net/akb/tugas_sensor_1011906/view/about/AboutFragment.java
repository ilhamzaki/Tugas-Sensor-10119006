package net.akb.tugas_sensor_1011906.view.about;

// 10119006 - Ilham zaki - IF1

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import net.akb.tugas_sensor_1011906.R;
import net.akb.tugas_sensor_1011906.models.InformasiItemModel;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {
    ViewPager2 viewPager2;
    List<InformasiItemModel> informasiList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        viewPager2 = view.findViewById(R.id.viewpager);
        informasiList = new ArrayList<>();

        String[] judul = {"Version", "Tentang", "Dibuat Oleh"};
        String[] desc = {"1.0.0", "Aplikasi untuk mencari tempat makan favorit", "Ilham Zaki - 10119006"};

        for (int i = 0; i < judul.length; i++) {
            InformasiItemModel item = new InformasiItemModel(judul[i], desc[i]);
            informasiList.add(item);
        }

        ViewPagerInformasiAdapter adapter = new ViewPagerInformasiAdapter(informasiList);

        viewPager2.setAdapter(adapter);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);


        return view;
    }
}