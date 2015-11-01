package com.example.akant.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class ShowMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);

        /*this is a way of obtaining the intent that started this activity.*/
        /*We first get a reference to the Intent that resulted in this activity
        being started by the Android framework.*/
        Intent in = getIntent();

        /*From the Intent we retrieve the message that was sent from MainActivity
        Note the use of the same key, "message", to retrieve the message*/
        String message = in.getStringExtra("message");

        // get a reference to the TextView on the UI
        TextView textMessage = (TextView) findViewById(R.id.textMessage);

        //get hour of the day and then set the text of the TextView to display the incoming greeting message
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour < 12){
            textMessage.setText("Good Morning "+message+"!");
        }
        else if (hour >= 12 && hour < 17){
            textMessage.setText("Good Afternoon "+message+"!");
        }
        else if (hour >= 17 && hour < 21) {
            textMessage.setText("Good Evening " + message + "!");
        }
        else if (hour >= 21 || hour < 6 ){
            textMessage.setText("Good Night " + message + "!");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_message, menu);
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
}
