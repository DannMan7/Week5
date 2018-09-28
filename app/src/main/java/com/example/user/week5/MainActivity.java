package com.example.user.week5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final static String LOG_TAG=MainActivity.class.getName().toString();

    String[] mClasses;
    List<String> lstClasses;
    TextView mTv;
    LinearLayout mLinearLayout;
    ListView mLv;
    Button mBtn;
    ArrayAdapter<String> adapter;
    String str="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mClasses=getResources().getStringArray(R.array.fsc_bcs_classes);
        lstClasses = new ArrayList<String>(Arrays.asList(mClasses));
        mTv=(TextView)findViewById(R.id.tv1);
        mLinearLayout=(LinearLayout)findViewById(R.id.main_layout_id);

        mBtn = new Button(this);
        mLv = new ListView(this);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, lstClasses);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lstClasses.remove(position);
                adapter.notifyDataSetChanged();
                mLv.invalidateViews();
            }
        });

        mLv.setAdapter(adapter);
        mLinearLayout.addView(mLv);




        Log.i(LOG_TAG, "This activity is onCreate" + mClasses.toString());

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(LOG_TAG, "OnStart Called");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(LOG_TAG, "OnStop Called");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(LOG_TAG, "OnPause Called");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(LOG_TAG, "OnResume Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MYTAG", "OnDestroy Called");
    }


    public void change_name(View view)
    {
        mTv.setText("Daniel Giris 4221");
    }
    @Override
    public void onClick(View view)
    {
        mTv.setText("Dan Giris 333");
    }
}
