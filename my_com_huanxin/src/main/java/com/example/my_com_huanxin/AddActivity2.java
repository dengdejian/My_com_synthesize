package com.example.my_com_huanxin;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_com_huanxin.adapter.RecyAdapter;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import java.util.List;

public class AddActivity2 extends AppCompatActivity {

    private TextView txName;
    private TextView tx_dwp;
    private String s;
    private RecyclerView recy;

    private RecyAdapter recyAdapter;
    private List<String> selfIds;
    private List<String> usernames;
    private String string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base2);

        initView();
        //a获取好友列表
        //发送消息
        new Thread(new Runnable() {


            @Override
            public void run() {
                try {
                    selfIds = EMClient.getInstance().contactManager().getSelfIdsOnOtherPlatform();
                    string = selfIds.toString();
                    Log.i("TAG--", "我的好友列表: " + selfIds);
//                    tx_dwp.setText(string);

                    usernames = EMClient.getInstance().contactManager().getAllContactsFromServer();
                    Log.i("TAG--", "run: " + usernames);

                    for (int i = 0; i < usernames.size(); i++) {
                        s = usernames.get(i);
                        Log.i("TAG--", "我的好友列表: " + s);
                    }


                } catch (HyphenateException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void initView() {
        txName = (TextView) findViewById(R.id.tx_name);
        tx_dwp = (TextView) findViewById(R.id.tx_dwp);
        recy = (RecyclerView) findViewById(R.id.recy);

        txName.setText(string);
        tx_dwp.setText(s);
//        if (usernames != null && usernames.size() > 0) {
//            recyAdapter = new RecyAdapter(AddActivity2.this, usernames);
//            recy.addItemDecoration(new DividerItemDecoration(AddActivity2.this, DividerItemDecoration.HORIZONTAL));
//            recy.setLayoutManager(new LinearLayoutManager(AddActivity2.this));
//            recy.setAdapter(recyAdapter);
//            recyAdapter.notifyDataSetChanged();
//        }

    }
}