package simone.russo.tesidilaurea.view;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import simone.russo.tesidilaurea.R;
import simone.russo.tesidilaurea.business.ProdottoBusiness;
import simone.russo.tesidilaurea.listener.MainActivityNavigationListener;
import simone.russo.tesidilaurea.model.CustomAdapterCatalogo;
import simone.russo.tesidilaurea.model.ProdottoModel;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    boolean drawerChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MainActivityNavigationListener navagationListener = new MainActivityNavigationListener(this);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.inflateMenu(R.menu.main_drawer_menu);
        navigationView.setNavigationItemSelectedListener(navagationListener);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        ArrayList<ProdottoModel> prodottoArrayList = new ArrayList<>();

        prodottoArrayList = ProdottoBusiness.getInstance().trovaTuttiIProdotti();

        CustomAdapterCatalogo adapter = new CustomAdapterCatalogo(prodottoArrayList, this);

        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.listViewProdotto);
        lView.setAdapter(adapter);



    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    public void setDrawerLayout(DrawerLayout drawerLayout) {
        this.drawerLayout = drawerLayout;
    }

    public NavigationView getNavigationView() {
        return navigationView;
    }

    public void setNavigationView(NavigationView navigationView) {
        this.navigationView = navigationView;
    }

    public boolean isDrawerChanged() {
        return drawerChanged;
    }

    public void setDrawerChanged(boolean drawerChanged) {
        this.drawerChanged = drawerChanged;
    }
}
