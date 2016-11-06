package com.neumeng.dmgame.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neumeng.dmgame.R;
import com.neumeng.dmgame.adapter.ArticleAdapter;
import com.neumeng.dmgame.api.ApiFactory;
import com.neumeng.dmgame.entity.Article;
import com.neumeng.dmgame.service.GameService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private GameService gameService = ApiFactory.getGameServiceSingleton();

    private String mType;//类型

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe)
    SwipeRefreshLayout mSwipe;

    ArticleAdapter mAdapter;
    List<Article> mRecordDatas;

    private boolean mIsLoadingMore = false;//是否是在加载更多
    private int mCurrentPage = 1;//当前页

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this,view);
        loadData(true);
        return view;
    }

    private void loadData(boolean clean) {
        mSwipe.setRefreshing(true);
//        if (clean) {
//            mRecordDatas.clear();
//            mCurrentPage = 1;
//        }
        Log.e("tag","start");
        ////http://www.3dmgame.com/sitemap/api.php?row=10&typeid=1&paging=1&page=%s
        gameService.getArticle(10,1,1,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> Log.e("tag",s));
//                .getRecords(mType, mCurrentPage)
//                .subscribeOn(Schedulers.io())
//                .map(recordResult -> recordResult.results)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(recordDatas -> {
//                    mRecordDatas.addAll(recordDatas);
//                    mAdapter.notifyDataSetChanged();
//                    mCurrentPage++;
//                    setRefresh(false);
//                });
        Log.e("tag","end");
    }
}
