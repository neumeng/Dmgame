package com.neumeng.dmgame.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neumeng.dmgame.R;
import com.neumeng.dmgame.adapter.DetailAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArticleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArticleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TITLE = "title";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mTitle;
    private String mParam2;

    @BindView(R.id.tabs)
    TabLayout mTabs;
    @BindView(R.id.pager)
    ViewPager mPager;

    private List<Fragment> mFragments;
    private DetailAdapter mAdapter;
    public ArticleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title  Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ArticleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArticleFragment newInstance(String title, String param2) {
        ArticleFragment fragment = new ArticleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_TITLE);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        DetailFragment fragment1 = DetailFragment.newInstance("","");
        DetailFragment fragment2 = DetailFragment.newInstance("","");
        DetailFragment fragment3 = DetailFragment.newInstance("","");
        DetailFragment fragment4 = DetailFragment.newInstance("","");
        DetailFragment fragment5 = DetailFragment.newInstance("","");
        DetailFragment fragment6 = DetailFragment.newInstance("","");
        DetailFragment fragment7 = DetailFragment.newInstance("","");
        DetailFragment fragment8 = DetailFragment.newInstance("","");


        mAdapter = new DetailAdapter(getActivity().getSupportFragmentManager());
        mAdapter.addFragment(fragment1,"新闻");
        mAdapter.addFragment(fragment2,"杂谈");
        mAdapter.addFragment(fragment3,"测评");
        mAdapter.addFragment(fragment4,"前瞻");
        mAdapter.addFragment(fragment5,"原创");
        mAdapter.addFragment(fragment6,"盘点");
        mAdapter.addFragment(fragment7,"硬件");
        mAdapter.addFragment(fragment8,"时事");
        mPager.setAdapter(mAdapter);
        mTabs.setupWithViewPager(mPager);
    }

}
