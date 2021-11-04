package simone.russo.tesidilaurea.listener;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;

import com.google.android.material.navigation.NavigationView;

import simone.russo.tesidilaurea.R;
import simone.russo.tesidilaurea.view.LoginActivity;
import simone.russo.tesidilaurea.view.MainActivity;
import simone.russo.tesidilaurea.view.RegistrazioneActivity;

public class MainActivityNavigationListener implements NavigationView.OnNavigationItemSelectedListener {
    MainActivity activity;
    public MainActivityNavigationListener(MainActivity activity) {
        this.activity=activity;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;
        NavigationView navigationView =  activity.getNavigationView();
        Menu menu;
        switch (menuItem.getItemId()){
            case R.id.nav_login:
                intent = new Intent(activity.getApplicationContext(), LoginActivity.class);
                activity.getDrawerLayout().closeDrawer(GravityCompat.START);
                activity.startActivity(intent);
                activity.finish();
                break;
            case R.id.nav_registrati:
                intent = new Intent(activity.getApplicationContext(), RegistrazioneActivity.class);
                activity.getDrawerLayout().closeDrawer(GravityCompat.START);
                activity.startActivity(intent);
                activity.finish();
                break;
        }
        return true;
    }
}
