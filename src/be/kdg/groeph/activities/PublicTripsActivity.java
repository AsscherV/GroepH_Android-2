package be.kdg.groeph.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import be.kdg.groeph.controllers.NetworkController;
import be.kdg.groeph.model.Trip;
import be.kdg.groeph.model.TripUser;
import com.webcomrades.demo.concurrency.R;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * Date: 8/03/13
 * Time: 15:11
 */
public class PublicTripsActivity extends Activity {
    private final String path = "/rest/publicTrips"; // url path: value for 1EUR in USD.




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publictrips);

        initViews();
    }

    private void initViews() {

    }

    private void getData(final String path) {
        new AsyncTask<Void, Void, List<Trip>>() {

            private Exception exception = null;

            @Override
            protected void onPreExecute() {


                super.onPreExecute();
            }

            @Override
            protected List<Trip> doInBackground(Void... params) {
                List<Trip> trips = null;

                try {
                    trips = new NetworkController().getPublicTripsFromServer(path);
                } catch (Exception e) {
                    exception = e;
                }

                return trips;
            }

            @Override
            protected void onPostExecute(List<Trip> result) {

                /*
                if (exception == null && result != null) {

                    Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(i);
                    finish();
                    //TODO: Add the cookie to a session I guess


                } else if (result == null) {
                    Toast.makeText(getApplicationContext(), "Wrong credentials", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Oops. Something went wrong!", Toast.LENGTH_SHORT).show();

                }
                progressbar.setVisibility(View.GONE);
                  */

            }

        }.execute();
    }
}