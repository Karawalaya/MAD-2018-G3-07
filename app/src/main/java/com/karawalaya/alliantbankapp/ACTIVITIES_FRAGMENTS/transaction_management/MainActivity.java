package com.karawalaya.alliantbankapp.ACTIVITIES_FRAGMENTS.transaction_management;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.karawalaya.alliantbankapp.ACTIVITIES_FRAGMENTS.user_management.UpdateDetails;
import com.karawalaya.alliantbankapp.POJO_MODEL.transaction_management.Customer;
import com.karawalaya.alliantbankapp.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar mainActionBar;
    private DrawerLayout mainDrawerLayout;
    private HomePage homePage;
    private AccountInformation accountInformation;
    private UpdateDetails updateDetails;
    private Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Kara", "onCreate MainActivity");
        setContentView(R.layout.activity_main);

        customer = (Customer) getIntent().getSerializableExtra("customer");

        //Action bar is set
        mainActionBar = findViewById(R.id.main_action_bar);
        setSupportActionBar(mainActionBar);

        //Drawer layout is set
        mainDrawerLayout = findViewById(R.id.main_drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        //three line drawer toggl
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mainDrawerLayout, mainActionBar, R.string.string_id_navigation_drawer_open, R.string.string_id_navigation_drawer_close);
        mainDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


        accountInformation = new AccountInformation();
        updateDetails = new UpdateDetails();

        if(savedInstanceState == null) {
            /*FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, new HomePage());
            transaction.addToBackStack(null);
            transaction.commit();*/

            homePage = HomePage.newInstance(customer);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homePage).addToBackStack("Home").commit();
            getSupportActionBar().setSubtitle("HomePage");
            /*FragmentManager fragManager = getSupportFragmentManager();
            FragmentTransaction fragTransact = fragManager.beginTransaction();
            fragTransact.replace(R.id.fragment_container, new HomePage());
            fragTransact.addToBackStack(null);
            fragTransact.commit();*/


        }
    }

    @Override
    public void onBackPressed() {
        if (mainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mainDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.important_menu_option_01:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homePage, "Homepage").commit();
                getSupportActionBar().setSubtitle("HomePage");
                break;

            case R.id.nav_drawer_menu_id_option_01:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, accountInformation, "AccountInformation").commit();
                getSupportActionBar().setSubtitle("Account Information");
                menuItem.setCheckable(true);
//                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                break;

            case R.id.nav_drawer_menu_id_option_02:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, updateDetails, "UpdateDetails").commit();
                getSupportActionBar().setSubtitle("Update Details");
                menuItem.setCheckable(true);
//                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                break;

            case R.id.nav_drawer_menu_id_option_03:
                Toast.makeText(this, "Account Balance", Toast.LENGTH_LONG).show();
                getSupportActionBar().setSubtitle("Account Balance");
                menuItem.setCheckable(true);
                break;

            case R.id.nav_drawer_menu_id_option_04:
                Toast.makeText(this, "Transaction History", Toast.LENGTH_LONG).show();
                getSupportActionBar().setSubtitle("Transaction History");
                menuItem.setCheckable(true);
                break;

            case R.id.nav_drawer_menu_id_option_05:
                Toast.makeText(this, "Make a Transaction", Toast.LENGTH_LONG).show();
                getSupportActionBar().setSubtitle("Make a Transaction");
                menuItem.setCheckable(true);
                break;

            case R.id.nav_drawer_menu_id_option_06:
                Toast.makeText(this, "Apply For Loan", Toast.LENGTH_LONG).show();
                getSupportActionBar().setSubtitle("Apply for Loan");
                menuItem.setCheckable(true);
                break;

            case R.id.nav_drawer_menu_id_option_07:
                Toast.makeText(this, "Lodge A Complaint", Toast.LENGTH_LONG).show();
                getSupportActionBar().setSubtitle("Lodge a Complaint");
                menuItem.setCheckable(true);
                break;
        }
        mainDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);

        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*switch (item.getItemId()) {
            case R.id.important_menu_option_01:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomePage()).commit();
                break;
        }
        mainDrawerLayout.closeDrawer(GravityCompat.START);
        return true;*/

        onNavigationItemSelected(item);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Kara", "onStart MainActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Kara", "onResume MainActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Kara", "onRestart MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Kara", "onPause MainActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Kara", "onStop MainActivity");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("Kara", "onSaveInstanceState MainActivity");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("Kara", "onRestoreInstanceState MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Kara", "onDestroy MainActivity");
    }
}
