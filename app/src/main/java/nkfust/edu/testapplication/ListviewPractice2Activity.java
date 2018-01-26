package nkfust.edu.testapplication;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ListviewPractice2Activity extends Activity {
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_practice2);

        lv = (ListView)findViewById(R.id.mlistView);
        putDataToListView();

    }

    protected  void putDataToListView()
    {
        ArrayList<HashMap<String, Object>> Item = new ArrayList<HashMap<String , Object>>();

        // for(int i = 0 ; i<10; i++)
        //   {
        HashMap<String ,Object> map = new HashMap<String, Object>();
        map.put("ItemImage", R.drawable.plugon25);
        //map.put("ItemName", "PlugName");
        // map.put("ItemInfo", "PlugInfo");
        //map.put("ItemButton", "Just a Schedule");
        Item.add(map);
        Toast.makeText(this,"Finish Item.add(map)",Toast.LENGTH_SHORT).show();
        //  }*/
        lv_BtnAdapter Btnadapter = new lv_BtnAdapter(
                this,
                Item,
                R.layout.activity_listview_practice,
                new String[] {"ItemImage","ItemName","ItemInfo","ItemButton"},
                new int[] {R.id.ItemImage,R.id.ItemName,R.id.ItemInfo,R.id.ItemButton}
        );
        lv.setAdapter(Btnadapter);

    }






/*
    class lv_BtnAdapter extends BaseAdapter {

        private ArrayList<HashMap<String,Object>> mAppList;
        private LayoutInflater mInflater;
        private Context mContext;
        private String[] keyString;
        private  int[] valueViewID;

        private nkfust.edu.testapplication.ListviewPractice2Activity.lv_BtnAdapter.ItemView itemView;

        private class ItemView{
            ImageView ItemImage;
            TextView ItemName;
            TextView ItemInfo;
            Switch ItemSwitch;
            Button ItemButton;
        }

        public lv_BtnAdapter(Context c , ArrayList<HashMap<String,Object>> appList, int resource, String[] from, int[] to){
            mAppList = appList;
            mContext = c ;
            mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            keyString = new String[from.length];
            valueViewID = new int[to.length];
            System.arraycopy(from , 0 ,   keyString , 0 , from.length);
            System.arraycopy(to   , 0 ,valueViewID , 0 ,   to.length);
        }
        @Override
        public int getCount() {
            //  return 0;
            return mAppList.size();
        }

        @Override
        public Object getItem(int position) {
            //return null;
            return mAppList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView != null){
                itemView = (nkfust.edu.testapplication.ListviewPractice2Activity.lv_BtnAdapter.ItemView) convertView.getTag();
            } else {
                convertView = mInflater.inflate(R.layout.activity_listview_practice,null);
                itemView = new nkfust.edu.testapplication.ListviewPractice2Activity.lv_BtnAdapter.ItemView();
                itemView.ItemImage = (ImageView)convertView.findViewById(valueViewID[0]);
                itemView.ItemName = (TextView)convertView.findViewById(valueViewID[1]);
                itemView.ItemInfo = (TextView)convertView.findViewById(valueViewID[2]);
                itemView.ItemSwitch = (Switch)convertView.findViewById(valueViewID[3]);
                itemView.ItemButton = (Button)convertView.findViewById(valueViewID[4]);
                convertView.setTag(itemView);
            }

            HashMap<String, Object> appInfo = mAppList.get(position);
            if (appInfo != null) {
                int mid = (Integer)appInfo.get(keyString[0]);
                String name = (String) appInfo.get(keyString[1]);
                String info = (String) appInfo.get(keyString[2]);
                int bid = (Integer)appInfo.get(keyString[3]);
                itemView.ItemName.setText(name);
                itemView.ItemInfo.setText(info);
                // itemView.ItemImage.setImageDrawable(itemView.ItemImage.getResources().getDrawable(mid));
                //itemView.ItemButton.setBackgroundDrawable(itemView.ItemButton.getResources().getDrawable(bid));
                itemView.ItemButton.setOnClickListener(new nkfust.edu.testapplication.ListviewPractice2Activity.lv_BtnAdapter.ItemButton_Click(position));
            }
            return convertView;
        }

        class ItemButton_Click implements View.OnClickListener {
            private int position;
            ItemButton_Click(int pos) {
                position = pos ;
            }
            @Override
            public void onClick(View v){
                int vid =v.getId();
                if (vid == itemView.ItemButton.getId()) {
                    Log.v("ola_log",String.valueOf(position));
                  // Toast.makeText(ListviewPractice2Activity.this,position,Toast.LENGTH_SHORT).show();


                }


            }

        }

    }
*/

}

