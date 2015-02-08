package com.android.example.kiwi.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ArrayList weekForecast = new ArrayList();
            weekForecast.add("Today - Sunny - 88/63");
            weekForecast.add("Tomorrow - Foggy - 70/46");
            weekForecast.add("Weds - Cloudy - 72/63");
            weekForecast.add("Thurs - Asteroids - 75/65");
            weekForecast.add("Fri - Heavy Rain - 65/56");
            weekForecast.add("Sat - Spain  - 35/28");
            weekForecast.add("Sun - End Times - -100/-163");

            ArrayAdapter<String> mForecastAdapter = new ArrayAdapter<String>(
                    getActivity(),
                    R.layout.list_item_forecast,
                    R.id.list_item_forecast_textview,
                    weekForecast
            );

            //traversing to the id in the tree
            ListView listview = (ListView) rootView.findViewById(R.id.listview_forecast);
            //Setting an adapter
            listview.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
