package tatastrive.application.datepicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText date;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        // initiate the date picker and a button
        date = findViewById( R.id.date );

        // perform click event on edit text
        date.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get( Calendar.YEAR ); // current year
                int mMonth = c.get( Calendar.MONTH ); // current month
                int mDay = c.get( Calendar.DAY_OF_MONTH ); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog( MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText( dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year );

                            }
                        }, mYear, mMonth, mDay );
                datePickerDialog.show();
            }
        } );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //return super.onCreateOptionsMenu( menu );
        getMenuInflater().inflate( R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_setting:
                Intent intent=new Intent( Intent.ACTION_DIAL);
                startActivity( intent );
                break;
            case R.id.action_setting1:
            Intent intent1=new Intent( Settings.ACTION_SETTINGS);
            startActivity( intent1);
            break;
        }
        return super.onOptionsItemSelected( item );

    }
}



