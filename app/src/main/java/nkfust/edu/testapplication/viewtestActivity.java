package nkfust.edu.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class viewtestActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] func = {"餘額查詢","交易明細","最新消息","投資理財","離開"};
    int[] icons={R.drawable.func_balance,
            R.drawable.func_history,
            R.drawable.func_news,
            R.drawable.func_finance,
            R.drawable.func_exit};
    private ListView listView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtest);

        GridView grid = (GridView)findViewById(R.id.grid);
        //ArrayAdapter gAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,func);
        IconAdapter gAdapter = new IconAdapter();
        grid.setAdapter(gAdapter);
        grid.setOnItemClickListener(this);

        listviewListener();
        spinnerListener();
    }

    class IconAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return func.length;
        }

        @Override
        public Object getItem(int i) {
            return func[i];
        }

        @Override
        public long getItemId(int i) {
            return icons[i];
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View row = view;
            if(row == null){
                row = getLayoutInflater().inflate(R.layout.item_row,null);
                ImageView image = (ImageView) row.findViewById(R.id.item_image);
                TextView text = (TextView) row.findViewById(R.id.item_text);

                image.setImageResource(icons[i]);
                text.setText(func[i]);
            }
            return row;
        }
    }

    private void listviewListener() {
        listView = (ListView) findViewById(R.id.list);
        //final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.plug,R.layout.simple_list_item_1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.simple_list_item_1,R.id.text1
                ,func);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ItemList());
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
        switch((int)id){
            case R.drawable.func_balance:
                break;
            case R.drawable.func_history:
                break;
            case R.drawable.func_news:
                break;
            case R.drawable.func_finance:
                startActivity(new Intent(this,FinanceActivity.class));
                break;
            case R.drawable.func_exit:
                finish();
                break;
        }
    }

    class ItemList implements AdapterView.OnItemClickListener{
        @Override

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            ViewGroup vg = (ViewGroup)view;
            TextView tv = (TextView) vg.findViewById(R.id.text1);
            //Button Btn2 = (Button) vg.findViewById(R.id.button2);
           Toast.makeText(viewtestActivity.this,tv.getText().toString(),Toast.LENGTH_SHORT).show();
            //Toast.makeText(viewtestActivity.this,"View:"+view+"\ni:"+i+"\nlong:"+l,Toast.LENGTH_SHORT).show();
        }
    }
    private void spinnerListener() {
        spinner = (Spinner) findViewById(R.id.notify_spinner);
        final ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource(this,R.array.notify_array,android.R.layout.simple_spinner_item);
        nAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(nAdapter);
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener(){
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                    {
                       Toast.makeText(viewtestActivity.this,nAdapter.getItem(position),Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent){

                    }
                }
        );
    }
}
