package net.akb.tugas_sensor_1011906;

// 10119006 - Ilham zaki - IF1

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import net.akb.tugas_sensor_1011906.view.profile.ProfileFragment;
import net.akb.tugas_sensor_1011906.view.favorite.FavoriteFragment;
import net.akb.tugas_sensor_1011906.view.about.AboutFragment;
import net.akb.tugas_sensor_1011906.view.locate.LocateFragment;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Navigation Logic
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar ab = getSupportActionBar();

        if (ab != null)  ab.setTitle("Profile");
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.container, new ProfileFragment())
                .commit();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menu_open, R.string.menu_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_profile:
                        if (ab != null) ab.setTitle("Profile Mahasiswa");
                        fm.beginTransaction()
                                .replace(R.id.container, new ProfileFragment())
                                .commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_favorite:
                        if (ab != null) ab.setTitle("Tempat Favorit");
                        fm.beginTransaction()
                                .replace(R.id.container, new FavoriteFragment())
                                .commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_locate:
                        if (ab != null) ab.setTitle("Lokasi Saya");
                        fm.beginTransaction()
                                .replace(R.id.container, new LocateFragment())
                                .commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_about:
                        if (ab != null)  ab.setTitle("Tentang Aplikasi");
                        fm.beginTransaction()
                                .replace(R.id.container, new AboutFragment())
                                .commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return false;
            }
        });
    }
}