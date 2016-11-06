package com.neumeng.dmgame.activity;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.neumeng.dmgame.R;
import com.neumeng.dmgame.fragment.ArticleFragment;
import com.neumeng.dmgame.fragment.ForumFragment;
import com.neumeng.dmgame.fragment.GameFragment;
import com.neumeng.dmgame.fragment.VideoFragment;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.content_container)
    FrameLayout mContainer;

    @BindView(R.id.bottom_navi_view)
    BottomNavigationView mBottomNaviView;

    ArticleFragment mArticleFragment;
    ForumFragment mForumFragment;
    GameFragment mGameFragment;
    VideoFragment mVideoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolbar();
        initFragment();
        initBottomNaviView();
    }

    private void initFragment() {
        if (mArticleFragment==null){
            mArticleFragment = ArticleFragment.newInstance("","");
        }
        showFragment(mArticleFragment,"文章");
    }

    private void initBottomNaviView() {
        mBottomNaviView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.article:
                    if (mArticleFragment==null){
                        mArticleFragment = ArticleFragment.newInstance("","");
                    }
                    showFragment(mArticleFragment,"文章");
                    break;
                case R.id.video:
                    if (mVideoFragment==null){
                        mVideoFragment = VideoFragment.newInstance("","");
                    }
                    showFragment(mVideoFragment,"视频");
                    break;
                case R.id.forum:
                    if (mForumFragment==null){
                        mForumFragment = ForumFragment.newInstance("","");
                    }
                    showFragment(mForumFragment,"论坛");
                    break;
                case R.id.game:
                    if (mGameFragment==null){
                        mGameFragment = GameFragment.newInstance("","");
                    }
                    showFragment(mGameFragment,"游戏");
                    break;
            }
            return true;
        });
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        setTitle("3DmGame");
    }

    private void showFragment(Fragment fragment,String title) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.content_container, fragment);
        transaction.commit();
        setTitle(title);
    }


}
