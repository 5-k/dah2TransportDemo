package dah2.dbs.com.dah2transport;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prateek on 11-03-2018.
 */

public class RoasterActivity extends AppCompatActivity {


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roaster);



        inflateTable();
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
