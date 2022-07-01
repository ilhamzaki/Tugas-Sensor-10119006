package net.akb.tugas_sensor_1011906.view.favorite;

// 10119006 - Ilham zaki - IF1

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import net.akb.tugas_sensor_1011906.R;

public class FavoriteFragment extends Fragment implements OnMapReadyCallback{
    private GoogleMap mMap;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        SupportMapFragment mMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.favoritemap);
        mMapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng chago_korean_bbq = new LatLng(-6.967241381109193, 107.7576708092224);
        LatLng seblak_bunda = new LatLng(-6.964607136177394, 107.75957186389842);
        LatLng baso_ceu_kokom = new LatLng(-6.963230192730877, 107.75623446052163);
        LatLng break_tea = new LatLng(-6.965945309755242, 107.75499093531093);
        LatLng sono_cafe = new LatLng(-6.967230384395237, 107.75816211160996);

        mMap.addMarker(new MarkerOptions().position(chago_korean_bbq).title("Chago Korean BBQ All You Can Eat Rancaekek"));
        mMap.addMarker(new MarkerOptions().position(seblak_bunda).title("Seblak Bunda Raziel"));
        mMap.addMarker(new MarkerOptions().position(baso_ceu_kokom).title("Baso Ceu Kokom"));
        mMap.addMarker(new MarkerOptions().position(break_tea).title("Break Tea"));
        mMap.addMarker(new MarkerOptions().position(sono_cafe).title("Sono Cafe"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chago_korean_bbq, 16));

    }
}