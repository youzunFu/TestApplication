package nkfust.edu.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class BundleTestActivity extends AppCompatActivity {
private String PlugNum,Equipment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle_test);

        TextView tvBundleTest = (TextView) findViewById(R.id.tvBundleTest);
        Bundle bundle = getIntent().getExtras();
        PlugNum = bundle.getString("PlugNum");
        Equipment = bundle.getString("Equipment");
        Toast.makeText(this, "插座編號 : "+PlugNum +"  "+"設備名稱 : "+ Equipment, Toast.LENGTH_LONG).show();

    }


}
