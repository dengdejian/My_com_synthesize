package com.example.my_com_synthesize;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.my_com_synthesize.fragment.BaseFragment;
import com.example.my_com_synthesize.fragment.BlankFragment;
import com.example.my_com_synthesize.fragment.BlankFragment2;
import com.example.my_com_synthesize.fragment.BlankFragment3;
import com.example.my_com_synthesize.fragment.BlankFragment4;
import com.example.my_com_synthesize.fragment.RecyFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FrameLayout flFragment;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;
    private FragmentTransaction mFragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("仿网易严选");
        flFragment = (FrameLayout) findViewById(R.id.fl_fragment);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton) findViewById(R.id.radioButton5);

        RecyFragment recyFragment = new RecyFragment();

        BaseFragment blankFragment = new BaseFragment();
        BlankFragment2 blankFragment2 = new BlankFragment2();
        BlankFragment3 blankFragment3 = new BlankFragment3();
        BlankFragment4 blankFragment4 = new BlankFragment4();

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = supportFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fl_fragment, recyFragment).commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mFragmentTransaction = supportFragmentManager.beginTransaction();
                switch (checkedId) {
                    case R.id.radioButton1:
                        mFragmentTransaction.replace(R.id.fl_fragment, recyFragment);
                        break;
                    case R.id.radioButton2:
                        mFragmentTransaction.replace(R.id.fl_fragment, blankFragment);
                        break;
                    case R.id.radioButton3:
                        mFragmentTransaction.replace(R.id.fl_fragment, blankFragment2);
                        break;
                    case R.id.radioButton4:
                        mFragmentTransaction.replace(R.id.fl_fragment, blankFragment3);
                        break;
                    case R.id.radioButton5:
                        mFragmentTransaction.replace(R.id.fl_fragment, blankFragment4);
                        break;
                    default:
                        break;
                }
                mFragmentTransaction.commit();
            }
        });


    }
}