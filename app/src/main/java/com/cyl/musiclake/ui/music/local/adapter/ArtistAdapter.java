package com.cyl.musiclake.ui.music.local.adapter;

import android.os.Build;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cyl.musiclake.R;
import com.cyl.musiclake.api.GlideApp;
import com.cyl.musiclake.bean.Artist;
import com.cyl.musiclake.common.Constants;
import com.cyl.musiclake.utils.CoverLoader;

import java.util.List;

public class ArtistAdapter extends BaseQuickAdapter<Artist, BaseViewHolder> {

    public ArtistAdapter(List<Artist> artistList) {
        super(R.layout.item_playlist_grid, artistList);
    }

    @Override
    protected void convert(BaseViewHolder helper, Artist artist) {
        helper.setText(R.id.name, artist.getName());
        helper.setText(R.id.artist, artist.getCount() + "首歌");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            helper.getView(R.id.album).setTransitionName(Constants.TRANSTITION_ALBUM);
        }
        GlideApp.with(mContext)
                .load(CoverLoader.getInstance().getCoverUriByRandom())
                .error(CoverLoader.getInstance().getCoverUriByRandom())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into((ImageView) helper.getView(R.id.album));
    }

}