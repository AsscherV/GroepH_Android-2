package be.kdg.groeph.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import be.kdg.groeph.model.Trip;
import com.webcomrades.demo.concurrency.R;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * Date: 11/03/13
 * Time: 14:20
 */
public class publicTripMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publictripmenu);
        initViews();

    }
    private void initViews() {

    }
}
