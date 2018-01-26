package nkfust.edu.testapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class listview extends AppCompatActivity {

    private ArrayList<String> data = new ArrayList<String>();
    public int listPositon ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView lv = (ListView) findViewById(R.id.listview1);
        generateListContent();

        lv.setAdapter(new MyListAdapter(this, R.layout.listview, data));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(listview.this, "List item was clicked at" + position, Toast.LENGTH_SHORT).show();
                listPositon = position;
            }
        });

    }

    public void generateListContent() {
        for (int i = 0; i < 10; i++) {
            data.add("This is row number" + i);
        }
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//getMenuInflater().inflate(R.menu.main_menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id ==R.id.action_settings){


        }
        return super.onOptionsItemSelected(item);

    }
*/

    private class MyListAdapter extends ArrayAdapter<String> {
        private int layout;
        private List<String> brandInfoList;

        private MyListAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            // resource：ListView子項佈局的id;objects：資料
            layout = resource;
            brandInfoList = objects ;
        }
/*
        @Override
        public int getCount() {
            return brandInfoList.size();
        }

        @Override
        public Objects getItem(int i) {
            return null != brandInfoList?brandInfoList.get(i):null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }
*/

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
           ControlItem controlitem = getItem(listPositon);

            View view;
            ViewHolder viewHolder;

            if (null == convertView) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.listview, null);

                viewHolder = new ViewHolder();
                viewHolder.imagelistview1 = (ImageView) view.findViewById(R.id.imagelistview1);
                viewHolder.tvlistview1 = (TextView) view.findViewById(R.id.tvlistview1);
                viewHolder.btnlistview1 = (Button) view.findViewById(R.id.btnlistview1);

                //View view = LayoutInflater.from(getContext()).inflate(layout, null);

                final ViewHolder finalViewHolder = viewHolder;
                viewHolder.btnlistview1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ControlItem p = (ControlItem) finalViewHolder.imagelistview1.getTag();

                        int currentImageId;
                        if (p.getImageId() == R.drawable.plugon) {
                            finalViewHolder.imagelistview1
                                    .setImageResource(R.drawable.plugoff);
                            currentImageId = R.drawable.plugoff;
                        } else {
                            finalViewHolder.imagelistview1
                                    .setImageResource(R.drawable.plugon);
                            currentImageId = R.drawable.plugon;
                        }

                        p.setImageId(currentImageId);
                    }

                });
                view.setTag(viewHolder);
                viewHolder.btnlistview1.setTag(controlitem);
            }else{
                    view = convertView;
                    viewHolder = (ViewHolder) view.getTag();
                    viewHolder.btnlistview1.setTag(controlitem);
                }

                viewHolder.imagelistview1.setImageResource(controlitem.getImageId());
                viewHolder.tvlistview1.setText(controlitem.getName());
                viewHolder.btnlistview1.setText(controlitem.getBtnnum() + "");

                if (position < 3) {
                view.setBackgroundColor(0xFF0000FF);
                }

                return view;
            }
            /*
            ViewHolder viewHolder ;
            //ViewHolder mainViewHolder = null;


            if(convertView == null){
              //  convertView = super.getView(convertView,parent);

               // view = LayoutInflater.from(getContext()).inflate(R.layout.listview,null);
              //  convertView = view.inflate(layout,parent,false );

               viewHolder = new ViewHolder();
               /*
                viewHolder.imagelistview1 = (ImageView) view.findViewById(R.id.imagelistview1);
                viewHolder.tvlistview1 = (TextView) view.findViewById(R.id.tvlistview1);
                viewHolder.btnlistview1 = (Button) view.findViewById(R.id.btnlistview1);

                viewHolder.btnlistview1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //viewHolder.btnlistview1.setText((position));
                        Toast.makeText(getContext(),"Button was click for list item" + position,Toast.LENGTH_SHORT).show();
                    }
                });
                convertView.setTag(viewHolder);
            }
            else{
                viewHolder = (ViewHolder) convertView.getTag();
                viewHolder.tvlistview1.setText(getItem(position));
            }
            return convertView;
        }

        */


        class ViewHolder {
            ImageView imagelistview1;
            TextView tvlistview1;
            Button btnlistview1;
        }
    }

        public class ControlItem {
            private int imageId;
            private String name;
            private int btnnum;

            public ControlItem(int imageId, String name, int btnnum) {
                this.imageId = imageId;
                this.name = name;
                this.btnnum = btnnum;
            }

            public int getImageId() {
                return imageId;
            }

            public String getName() {
                return name;
            }

            public int getBtnnum() {
                return btnnum;
            }

            public void setImageId(int imageId) {
                this.imageId = imageId;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setBtnnum(int btnnum) {
                this.btnnum = btnnum;
            }

        }



}
