package com.geekbrains.weather;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WeatherFragment extends BaseFragment implements /*Observer,*/ CreateActionFragment.OnHeadlineSelectedListener {


    private static final String ARG_COUNTRY = "ARG_COUNTRY";
    private String country;
    private TextView textView;
    private boolean isCheckedNotification = false;
    private boolean isCheckedUpdates = false;



    public WeatherFragment() {
    }

    public static WeatherFragment newInstance(String country) {
        Bundle args = new Bundle();
        args.putString(ARG_COUNTRY, country);


        WeatherFragment fragment = new WeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            country = getArguments().getString(ARG_COUNTRY);

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(getContext(), "onAttachWeather", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getContext(), "onDetachWeather", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.weather_layout, container, false);
    }

    @Override
    protected void initLayout(View view, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        textView = view.findViewById(R.id.tv_country);
        if (textView != null) {
            Log.d(ARG_COUNTRY, "NOTnull!!");
        }
        if (country != null && country.length() > 0) {
            Log.d(ARG_COUNTRY, "IN");
            textView.setVisibility(View.VISIBLE);
            textView.setText(country);
        } else {
            Log.d(ARG_COUNTRY, "ELSE");
            textView.setVisibility(View.GONE);
        }
    }

    @Override
    public BaseActivity getBaseActivity() {
        return super.getBaseActivity();
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), "onStartWeather", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "onResumeWeather", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getContext(), "onPauseWeather", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getContext(), "onStopWeather", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(), "onDestroyWeather", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void updateText(String text) {
//        country = text;
//        Log.d(ARG_COUNTRY, country);
//        if (textView == null) {
//            Log.d(ARG_COUNTRY, "null");
//        }
//    }

    @Override
    public void onArticleSelected(ArrayList<String> citiesList) {
        textView.setVisibility(View.VISIBLE);
        String cities = citiesList.toString();
        textView.setText(cities.substring(cities.indexOf("[") + 1, cities.indexOf("]")));
    }
    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.base, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_add:
                return true;
            case R.id.auto_updates:
                if (isCheckedUpdates) {
                    isCheckedUpdates = false;
                    item.setChecked(isCheckedUpdates);
                } else {
                    isCheckedUpdates = true;
                    item.setChecked(isCheckedUpdates);
                }
                return true;

            case R.id.action_notifications:
                if (isCheckedNotification) {
                    isCheckedNotification = false;
                    item.setChecked(isCheckedNotification);
                } else {
                    isCheckedNotification = true;
                    item.setChecked(isCheckedNotification);
                }
                return true;
            case R.id.simple_view:
                item.setChecked(true);
                return true;
            case R.id.popular_view:
                item.setChecked(true);
                return true;
            case R.id.custom_view:
                item.setChecked(true);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

}
