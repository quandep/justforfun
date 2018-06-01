package com.example.ttdat.justforfun;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Class dùng để hiển thị từng hình ảnh riêng lẻ
 *
 * @author drthanh
 */
public class MyImageAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] mThumbIds;

    public MyImageAdapter(Context c) {
        mContext = c;
    }

    public MyImageAdapter(Context c, Integer[] arrIds) {
        mContext = c;
        mThumbIds = arrIds;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int arg0) {
        return 0;
    }

    /**
     * Cần override lại hàm này để hiển thị hình ảnh
     */
    public View getView(int arg0, View convertView, ViewGroup arg2) {
        ImageView imgView;
        if (convertView == null) {
            imgView = new ImageView(mContext);
            //can chỉnh lại hình cho đẹp
            imgView.setLayoutParams(new GridView.LayoutParams(120, 120));
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgView.setPadding(1, 1, 1, 1);
//            imgView.setVisibility(View.INVISIBLE);
        } else {
            imgView = (ImageView) convertView;
        }
        //lấy đúng vị trí hình ảnh được chọn
        //gán lại ImageResource
        imgView.setImageResource(mThumbIds[arg0]);
        return imgView;
    }
}