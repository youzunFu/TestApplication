package nkfust.edu.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.Toast;

public class pageActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        tabhost_definition();
        page1btn1click();
        page2btn1click();
        page3btn1click();

        spinner = (Spinner) findViewById(R.id.airspinner);
        final ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource(this,R.array.abc,android.R.layout.simple_spinner_item);
        spinner.setAdapter(nAdapter);
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener(){
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,int position,long id)
                    {
                        Toast.makeText(pageActivity.this,nAdapter.getItem(position),Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent){

                    }
                }
        );
    }
    private void page1btn1click() {
        Button page1btn1 = (Button) findViewById(R.id.page1bt1);
        page1btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pageActivity.this,"Test Page 1",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void page2btn1click() {
        Button page2btn1 = (Button) findViewById(R.id.page2bt1);
        page2btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pageActivity.this,"Test Page 2",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void page3btn1click() {
        Button page3btn1 = (Button) findViewById(R.id.page3bt1);
        page3btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pageActivity.this,"Test Page 3",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void tabhost_definition() {
        TabHost tab = (TabHost) findViewById(R.id.tabHost);
        tab.setup();

        TabHost.TabSpec spec1 = tab.newTabSpec("Tab 1");
        spec1.setIndicator("Tab1");
        spec1.setContent(R.id.layout1);
        tab.addTab(spec1);

        TabHost.TabSpec spec2 =tab.newTabSpec("Tab 2");
        spec2.setIndicator("Tab 2");
        spec2.setContent(R.id.layout2);
        tab.addTab(spec2);

        TabHost.TabSpec spec3=tab.newTabSpec("Tab 3");
        spec3.setIndicator("Tab 3");
        spec3.setContent(R.id.layout3);
        tab.addTab(spec3);
    }


}
