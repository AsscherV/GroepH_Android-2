package be.kdg.groeph.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import be.kdg.groeph.controllers.NetworkController;
import be.kdg.groeph.model.Trip;
import be.kdg.groeph.model.TripUser;
import com.webcomrades.demo.concurrency.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * Date: 8/03/13
 * Time: 15:11
 */
public class PublicTripsActivity extends Activity {
    private final String path = "/rest/publicTrips"; // url path: value for 1EUR in USD.

    public List<Trip> publicTrips;
    ListView lv_publiceTrips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publictrips);

        getData(path);
        lv_publiceTrips = (ListView) findViewById(R.id.publicTripsListView);
        lv_publiceTrips.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Trip selectedTrip = publicTrips.get((int) l);
                Intent intent = new Intent(getApplicationContext(), publicTripMenuActivity.class);


                intent.putExtra("PublicTrip", selectedTrip);
                startActivity(intent);
                finish();

            }
        });

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

                publicTrips = trips;
                return trips;
            }

            @Override
            protected void onPostExecute(List<Trip> result) {

                //TODO: add the data to the list

                lv_publiceTrips = (ListView) findViewById(R.id.publicTripsListView);

                Trip[] lv_arr = {};
                lv_arr = publicTrips.toArray(new Trip[0]);
                lv_publiceTrips.setAdapter(new ArrayAdapter<Trip>(PublicTripsActivity.this, android.R.layout.simple_list_item_1, lv_arr));


            }

        }.execute();
    }
}