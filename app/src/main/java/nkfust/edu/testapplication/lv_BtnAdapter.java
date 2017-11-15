package nkfust.edu.testapplication;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;

public class lv_BtnAdapter extends BaseAdapter {

    private ArrayList<HashMap<String,Object>> mAppList;
    private LayoutInflater mInflater;
    private Context mContext;
    private String[] keyString;
    private  int[] valueViewID;

    private ItemView itemView;

    private class ItemView{
        ImageView ItemImage;
        TextView ItemName;
        TextView ItemInfo;
        Switch ItemSwitch;
        Button ItemButton;
    }

    public lv_BtnAdapter(Context c, ArrayList<HashMap<String, Object>> appList, int resource, String[] from, int[] to) {
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
           itemView = (ItemView) convertView.getTag();
       } else {
           convertView = mInflater.inflate(R.layout.simple_list_item_1,null);
           itemView = new ItemView();
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
            itemView.ItemButton.setOnClickListener(new ItemButton_Click(position));
        }
        return convertView;
    }

    class ItemButton_Click implements AdapterView.OnClickListener {
        private int position;
        ItemButton_Click(int pos) {
            position = pos ;
        }
        @Override
        public void onClick(View v){
            int vid =v.getId();
            itemView.ItemButton.setText(position);
           // Toast.makeText(lv_BtnAdapter.ItemButton_Click.this,"按鈕"+position,Toast.LENGTH_SHORT).show();
            if (vid == itemView.ItemButton.getId()) {
                Log.v("ola_log",String.valueOf(position));

            }


        }

    }

}
