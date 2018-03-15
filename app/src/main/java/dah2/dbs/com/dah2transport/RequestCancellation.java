package dah2.dbs.com.dah2transport;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

/**
 * Created by Prateek on 16-03-2018.
 */

public class RequestCancellation extends AppCompatActivity implements View.OnClickListener {
    DatePicker dp ,dp2;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancellation);
         dp =  (DatePicker)this.findViewById(R.id.datePicker2);
        dp.init(2018, 3, 19, null);

         dp2 =  (DatePicker)this.findViewById(R.id.datePicker2);
        dp2.init(2018, 3, 22, null);

        button = findViewById(R.id.cancellationButton);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String text  = "Transport cancelled from " + dp.getYear()+"-"+dp.getMonth()+"-"+dp.getDayOfMonth()+"" +
                " to " + dp2.getYear()+"-"+dp2.getMonth()+"-"+dp2.getDayOfMonth();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(text);
        builder.setCancelable(true);
        builder.show();
        Toast.makeText(this,  text, Toast.LENGTH_LONG);

    }
}
