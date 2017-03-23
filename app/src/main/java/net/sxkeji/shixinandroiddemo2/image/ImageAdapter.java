package net.sxkeji.shixinandroiddemo2.image;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.dom.WXImageQuality;

/**
 * <br/> Description: Weex 需要自己实现图片加载
 * <p>
 * <br/> Created by shixinzhang on 17/3/23.
 * <p>
 * <br/> Email: shixinzhang2016@gmail.com
 * <p>
 * <a  href="https://about.me/shixinzhang">About me</a>
 */

public class ImageAdapter implements IWXImgLoaderAdapter {

    private static class SingleHolder {
        private static final ImageAdapter INSTANCE = new ImageAdapter();
    }

    private ImageAdapter() {
    }

    public static ImageAdapter getInstance() {
        return SingleHolder.INSTANCE;
    }


    @Override
    public void setImage(String url, ImageView view, WXImageQuality quality, WXImageStrategy strategy) {
//        Picasso.
    }
}
