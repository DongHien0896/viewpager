package com.example.vuongtd.tablayout_viewpager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        setComponent();
    }

    private void setComponent() {
        FragmentManager manager = getSupportFragmentManager();
        PagerAdapter adapter = new PagerAdapter(manager);

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText(Constant.FIRST);
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_name, 0, 0);
        mTabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText(Constant.SECOND);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_name, 0, 0);
        mTabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText(Constant.THIRD);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_name, 0, 0);
        mTabLayout.getTabAt(2).setCustomView(tabThree);

        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor(String.valueOf(R.color.color_red)));
        mTabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        mTabLayout.setTabTextColors(Color.parseColor(String.valueOf(R.color.color_brown)),
                Color.parseColor(String.valueOf(R.color.color_white)));
    }

    private void init() {
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.viewpager);
    }
}
