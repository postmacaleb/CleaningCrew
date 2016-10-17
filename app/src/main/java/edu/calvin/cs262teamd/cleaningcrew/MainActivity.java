package edu.calvin.cs262teamd.cleaningcrew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set title to "Housekeeping Log"
        setTitle("Housekeeping Log");
    }

    /**
     * Determines behavior of the options menu in the action bar
     * @param menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    /**
     * Handles the user selection of an item in the options menu
     * @param item
     * @return true if selection valid, else call superclass method
     */
    @Override 
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // go to the about page
            case R.id.about_page:
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                return true;
            // go to the employee contact page
            case R.id.employee_contact_page:
                startActivity(new Intent(getApplicationContext(), EmployeeContactActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
