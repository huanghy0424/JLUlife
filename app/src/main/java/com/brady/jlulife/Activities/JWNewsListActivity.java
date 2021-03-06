package com.brady.jlulife.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.brady.jlulife.Fragments.News.JWNewsListFragment;
import com.brady.jlulife.R;

/**
 * Created by brady on 15-11-30.
 */
public class JWNewsListActivity extends BaseActivity{
    @Override
    public void initFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_container, JWNewsListFragment.getInstance());
        transaction.commit();
    }
}
