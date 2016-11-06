package com.neumeng.dmgame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.neumeng.dmgame.R;
import com.neumeng.dmgame.entity.Article;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by koo on 2016/11/6.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {
    private List<Article> mRecordDatas;
    private Context mContext;
    OnClickListener mOnClickListener;

    public ArticleAdapter(Context context, List<Article> recordDatas) {
        mContext = context;
        mRecordDatas = recordDatas;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(mContext).inflate(R.layout.item_record_data, parent, false);
//        return new MyViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        RecordData recordData = mRecordDatas.get(position);
//        holder.desc.setText(recordData.desc.length() > 40 ? recordData.desc.substring(0, 40) + "..." : recordData.desc);
////        List<String> urls = recordData.images;
//        if (recordData.images != null && recordData.images.size() > 0) {
//            String url = recordData.images.get(0);
//            Glide.with(mContext).load(url + "?imageView2/0/w/72").into(holder.pic);
//        } else {
//            holder.pic.setImageResource(R.mipmap.ic_launcher);
//        }
    }

    @Override
    public int getItemCount() {
        return mRecordDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.pic)
        ImageView pic;
//        @BindView(R.id.desc)
        TextView desc;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (mOnClickListener != null) {
                    mOnClickListener.click(v,getAdapterPosition());
                }
            });
        }
    }

    public interface OnClickListener {
        void click(View view,int position);
    }
}

