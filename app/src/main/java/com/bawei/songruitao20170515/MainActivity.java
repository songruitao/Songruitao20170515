package com.bawei.songruitao20170515;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private List<Map<String, Object>> mData;
    MyAdapter adapter = null;
    public ImageView img;
    private ListView lv;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listview3listview);

        button = (Button) findViewById(R.id.button);
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"跳转成功",Toast.LENGTH_LONG).show();
                finish();
            }
        });*/

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"跳转成功",Toast.LENGTH_LONG).show();
                finish();
            }
        });

        mData = getData();
        adapter = new MyAdapter(this);
        lv.setAdapter(adapter);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "G1");
        map.put("info", "google 1");
        map.put("img", R.drawable.i1);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G2");
        map.put("info", "google 2");
        map.put("img", R.drawable.i2);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G3");
        map.put("info", "google 3");
        map.put("img", R.drawable.i3);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G4");
        map.put("info", "google 4");
        map.put("img", R.drawable.i4);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G5");
        map.put("info", "google 5");
        map.put("img", R.drawable.i5);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G6");
        map.put("info", "google 6");
        map.put("img", R.drawable.i6);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G7");
        map.put("info", "google 7");
        map.put("img", R.drawable.i7);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G8");
        map.put("info", "google 8");
        map.put("img", R.drawable.i8);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G9");
        map.put("info", "google 9");
        map.put("img", R.drawable.i9);
        list.add(map);

        return list;
    }

    // listview中点击按键弹出对话框
    public void showInfo(final int position) {
        new AlertDialog.Builder(this).setTitle("我的提示").setMessage("确定要删除吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mData.remove(position);
                        // 通过程序我们知道删除了，但是怎么刷新ListView呢？
                        // 只需要重新设置一下adapter
                        lv.setAdapter(adapter);
                    }
                }).show();
    }
    public final class ViewHolder {
        public ImageView img;
        public TextView title;
        public TextView info;
        public Button viewBtn;
    }

    public class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public MyAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int arg0) {
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView,
                            ViewGroup parent) {

            // 通过Log.i()可以发现这个会多次调用，容易理解

            ViewHolder holder = null;
            if (convertView == null) {

                holder = new ViewHolder();

                convertView = mInflater.inflate(R.layout.listitem3, null);
                holder.img = (ImageView) convertView
                        .findViewById(R.id.listitem3imageview);
                holder.title = (TextView) convertView
                        .findViewById(R.id.listitem3ItemTitle);
                holder.info = (TextView) convertView
                        .findViewById(R.id.listitem3ItemText);
                holder.viewBtn = (Button) convertView
                        .findViewById(R.id.listitem3button);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.img.setBackgroundResource((Integer) mData.get(position).get("img"));
            holder.title.setText((String) mData.get(position).get("title"));
            holder.info.setText((String) mData.get(position).get("info"));
            holder.viewBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showInfo(position);
                }
            });
            return convertView;
        }
    }
}