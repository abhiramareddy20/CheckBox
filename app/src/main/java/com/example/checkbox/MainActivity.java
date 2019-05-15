package com.example.checkbox;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final String[] select_qualification = {
            "Live event filming", "Hotels & Resorts Filming", "Real Estates Filming", "Construction Sites Filming",
            "Highway and Road survey","Traffic Survey", "Powerline/Telecommunication Survey","Pipeline Survey","3D Mapping","3D Modelling",
            "LiDAR Survey","Orthophoto Projection","GIS Survey","Alignment Survey"};

    ArrayList<StateVO> listVOs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        for (int i = 0; i < select_qualification.length; i++) {
            StateVO stateVO = new StateVO();
            stateVO.setTitle(select_qualification[i]);
            stateVO.setSelected(false);
            listVOs.add(stateVO);
        }
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, 0,
                listVOs);
        spinner.setAdapter(myAdapter);
    }

}

