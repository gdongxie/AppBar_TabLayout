package com.example.appbar_tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.appbar_tablayout.fragments.AuthorInfoFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    private Fragment[]  mfragments=new Fragment[3];
    private String[]   mtabTitles=new String[3];
  //  @Bind(R.id.toolbar)
    private Toolbar mtoolbar;
  //  @Bind(R.id.tabs)
    private TabLayout mTabLayout;
 //   @Bind(R.id.viewpager)
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // ButterKnife.bind(this);
        mtoolbar= (Toolbar) findViewById(R.id.toolbar);
        mTabLayout= (TabLayout) findViewById(R.id.tabs);
        mViewPager= (ViewPager) findViewById(R.id.viewpager);

        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mtabTitles[0]="政府网";
        mtabTitles[1]="招商网";
        mtabTitles[2]="书记县长";

        mfragments[0]= AuthorInfoFragment.newInstance();
        mfragments[1]=AuthorInfoFragment.newInstance();
        mfragments[2]=AuthorInfoFragment.newInstance();

        PagerAdapter pagerAdapter=new AuthorPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);

        //增加Tab,同时关联viewPager
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(pagerAdapter);


    }

    private class AuthorPagerAdapter extends FragmentPagerAdapter {

        public AuthorPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mfragments[position];
        }

        @Override
        public int getCount() {
            return mfragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mtabTitles[position];
        }
    }
}
