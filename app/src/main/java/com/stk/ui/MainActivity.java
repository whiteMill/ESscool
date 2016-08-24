package com.stk.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.example.admin.esscool.R;
import com.stk.fragment.NoteFragment;
import com.stk.fragment.SchoolFragment;
import com.stk.fragment.StudentFragment;
import com.stk.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment noteFragment;
    private Fragment schooleFragment;
    private Fragment studentFragment;
    private Fragment userFragment;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private RadioButton noteManage;
    private RadioButton schoolManage;
    private RadioButton studentManage;
    private RadioButton userCenter;
    private ViewPager myViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
        init();
    }

    private void init() {
        myViewPager = (ViewPager) findViewById(R.id.viewPager);

        noteManage = (RadioButton) findViewById(R.id.noteManage);
        schoolManage = (RadioButton) findViewById(R.id.schoolManage);
        studentManage = (RadioButton) findViewById(R.id.studentManage);
        userCenter = (RadioButton) findViewById(R.id.userCenter);

        noteManage.setOnClickListener(this);
        schoolManage.setOnClickListener(this);
        studentManage.setOnClickListener(this);
        userCenter.setOnClickListener(this);

        noteFragment = new NoteFragment();
        schooleFragment = new SchoolFragment();
        studentFragment = new StudentFragment();
        userFragment = new UserFragment();

        fragmentList.add(noteFragment);
        fragmentList.add(studentFragment);
        fragmentList.add(schooleFragment);
        fragmentList.add(userFragment);

        myViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                change(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    private void change(int index) {
        switch (index) {
            case 0:
                noteManage.setChecked(true);
                schoolManage.setChecked(false);
                studentManage.setChecked(false);
                studentManage.setChecked(false);
                break;
            case 1:
                noteManage.setChecked(false);
                schoolManage.setChecked(true);
                studentManage.setChecked(false);
                studentManage.setChecked(false);
                break;
            case 2:
                noteManage.setChecked(false);
                schoolManage.setChecked(false);
                studentManage.setChecked(true);
                studentManage.setChecked(false);
                break;
            case 3:
                noteManage.setChecked(false);
                schoolManage.setChecked(false);
                studentManage.setChecked(false);
                studentManage.setChecked(true);
                break;


        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.noteManage:
                myViewPager.setCurrentItem(0);
                change(0);
                break;
            case R.id.studentManage:
                myViewPager.setCurrentItem(1);
                change(1);
                break;
            case R.id.schoolManage:
                myViewPager.setCurrentItem(2);
                change(2);
                break;
            case R.id.userCenter:
                myViewPager.setCurrentItem(3);
                change(3);
                break;


        }
    }
}
