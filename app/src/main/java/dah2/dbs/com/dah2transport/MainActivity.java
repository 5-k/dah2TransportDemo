package dah2.dbs.com.dah2transport;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        checkIfLoggedIn();
    }

    private void checkIfLoggedIn() {
        Bundle bundle =  getIntent().getExtras();
        if(null != bundle) {
            String value = bundle.getString("login");
            if(value.equals("success")) {
                init();
                return;
            }
        }
        Intent myIntent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(myIntent);
    }

    private void init() {
        CardView viewRoaster = findViewById(R.id.viewRoasterCard);
        viewRoaster.setOnClickListener(this);

        CardView trackRide =  findViewById(R.id.trackRideCard);
        trackRide.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.roasterView) {
            Intent mIntent = new Intent(this, RoasterActivity.class);
            startActivity(mIntent);

        } else if (id == R.id.adhocCab) {
            Intent mIntent = new Intent(this, AdhocActivity.class);
            startActivity(mIntent);
        } else if (id == R.id.cancelCab) {
            Intent mIntent = new Intent(this, RequestCancellation.class);
            startActivity(mIntent);
        } else if (id == R.id.trackRide) {
            Intent mIntent = new Intent(this, MapLocationActivity.class);
            startActivity(mIntent);
        }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewRoasterCard:
                Intent mIntent = new Intent(this, RoasterActivity.class);
                startActivity(mIntent);
                break;
            case R.id.trackRideCard:
                break;
        }
    }
    private void inflateTable() {
        List<String> userName  = new ArrayList<>();
        userName.add("Om Prakash ");
        userName.add("Sridhar Nair");
        userName.add("Ganga Devi");
        userName.add("Aditya Singh");
        userName.add("Ruchika Mahajan");
        userName.add("Sweta Gaur");
        userName.add("Srikant Sahu");
        userName.add("Kamal Bhatia");
        userName.add("Jagadeesh Posini");
        userName.add("Suman Sahu");
        userName.add("Rajat Sharma");
        userName.add("Suman Sahu");
        userName.add("Yogesh");
        userName.add("Suyog Jadhav");
        userName.add("Mudit");
        userName.add("Raman Singh");
        userName.add("Saikiran Ale");
        userName.add("Srihar Armeni");
        userName.add("Suman Sahu");
        userName.add("Harjot Bhatia");
        userName.add("Abhigyan Sahu");

        List<String> pickupPoints = new ArrayList<>();
        pickupPoints.add("RTO Office");
        pickupPoints.add("Shilpa Park");
        pickupPoints.add("Kondapur X Road");
        pickupPoints.add("Kothaguda Jn");
        pickupPoints.add("Keshav Reddy Sweets");
        pickupPoints.add("KFC Gachhibowli");

        List<String> time = new ArrayList<>();
        time.add("07:58");
        time.add("08:01");
        time.add("08:03");
        time.add("08:06");
        time.add("08:10");
        time.add("08:15");

        TableLayout stk =  findViewById(R.id.roasterTableLayout1);
        int j = 0;

        TableLayout.LayoutParams tableLayoutParams = new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT, 0.1f);
        tableLayoutParams.setMargins(8,16,8,0);

        TableRow.LayoutParams tableRowLayoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        tableRowLayoutParams.setMargins(8,8,8,0);
        for(int i = 0 ; i < 21; i++) {
            if(i % 3 == 0 && i !=0 & j<5) {
                j++;
            }
            String pickup = pickupPoints.get(j);
            String timepick = time.get(j);

            TableRow tableRow = new TableRow(this);

            TextView t1v = new TextView(this);
            t1v.setLayoutParams(tableRowLayoutParams);
            t1v.setText(userName.get(i));
            t1v.setGravity(Gravity.CENTER);
            tableRow.addView(t1v);


            TextView t2v = new TextView(this);
            t2v.setLayoutParams(tableRowLayoutParams);
            t2v.setText(pickup);
            t2v.setGravity(Gravity.CENTER);
            tableRow.addView(t2v);


            TextView t3v = new TextView(this);
            t3v.setLayoutParams(tableRowLayoutParams);
            t3v.setText(timepick);
            t3v.setGravity(Gravity.CENTER);
            tableRow.addView(t3v);

            tableRow.setLayoutParams(tableLayoutParams);
            stk.addView(tableRow);

        }

        stk.setVisibility(View.VISIBLE);

    }
}
