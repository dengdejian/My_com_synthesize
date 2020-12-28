package com.example.my_com_huanxin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hyphenate.EMContactListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import java.util.List;

public class FixendListActivity extends AppCompatActivity {

    private Button search;
    private EditText unsrname;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixend_list2);
        initView();
    }

    private void initView() {
        search = (Button) findViewById(R.id.search);
        unsrname = (EditText) findViewById(R.id.unsrname);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = unsrname.getText().toString();
                if (name!=null){
                    initAddstr();
                }
            }
        });
    }

    private void initAddstr() {

        //参数为要添加的好友的username和添加理由
        try {
            EMClient.getInstance().contactManager().addContact(name, "想他");
            Log.i("TAG", ": " + name + "请求添加为好友");

            EMClient.getInstance().contactManager().setContactListener(new EMContactListener() {
                @Override
                public void onContactInvited(String username, String reason) {
                    //收到好友邀请
//                    Toast.makeText(FixendListActivity.this, "收到了一条好友申请", Toast.LENGTH_SHORT).show();
                    Log.i("TAG", "收到了一条好友申请: " + username);
                    Intent intent = new Intent(FixendListActivity.this, AddActivity2.class);
                    startActivity(intent);
                    try {
                        //同意好友申请
                        EMClient.getInstance().contactManager().acceptInvitation(username);
                        //跳转到好友界面
                    } catch (HyphenateException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFriendRequestAccepted(String username) {
                    try {
                        EMClient.getInstance().contactManager().acceptInvitation(username);

//                        Toast.makeText(FixendListActivity.this, "接收", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(FixendListActivity.this, AddActivity2.class);
                        startActivity(intent);

                    } catch (HyphenateException e) {
                        e.printStackTrace();

                    }

                }

                @Override
                public void onFriendRequestDeclined(String username) {

                    Toast.makeText(FixendListActivity.this, "应朋友要求拒绝", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onContactDeleted(String username) {
                    //被删除时回调此方法

                }


                @Override
                public void onContactAdded(String username) {
                    //增加了联系人时回调此方法
//                    Toast.makeText(FixendListActivity.this, "接收", Toast.LENGTH_SHORT).show();
                    try {
                        EMClient.getInstance().contactManager().acceptInvitation(username);



                        Intent intent = new Intent(FixendListActivity.this, AddActivity2.class);
                        startActivity(intent);
                        Toast.makeText(FixendListActivity.this, "成为好友", Toast.LENGTH_SHORT).show();
                    } catch (HyphenateException e) {
                        e.printStackTrace();
                    }
                }
            });


        } catch (HyphenateException e) {
            e.printStackTrace();
        }

    }
}