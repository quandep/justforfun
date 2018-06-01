package com.example.ttdat.justforfun;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity
        implements OnItemClickListener {
    TextView tvMsg;
    GridView gv;
    TextView tvSoloMsg;
    String flag1 = "";
    String flag2 = "";
    Button btnAction;
    int i = 0;
    //mảng lưu danh sách các id hình ảnh có sẵn
    Integer[] mThumbIds;
    //Adapter cho GridView
    MyImageAdapter adapter = null;
    //Vì không tạo thêm 1 Activity nên lấy luôn 2 Id ở bên solo_picture.xml
    ImageView ivSoloPicture;
    Button btnBack;
    //Lưu Bundle backup cho MainActivity
    Bundle myBackupBundle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Lưu savedInstanceState trước vào myBackupBundle
        myBackupBundle = savedInstanceState;
        setContentView(R.layout.activity_main);

        //gán mảng các Id hình ảnh cho mThumbIds
        mThumbIds = new Integer[]{R.drawable.image1, R.drawable.image1,
                R.drawable.image2, R.drawable.image2,
                R.drawable.image3, R.drawable.image3,
                R.drawable.image4, R.drawable.image4,
                R.drawable.image5, R.drawable.image5,
                R.drawable.image6, R.drawable.image6,
                R.drawable.image7, R.drawable.image7,
                R.drawable.image8, R.drawable.image8,
        };
        // shuffle Array
        shuffleArray(mThumbIds);
        gv = (GridView) findViewById(R.id.gridView1);
        //thiết lập Datasource cho Adapter
        adapter = new MyImageAdapter(this, mThumbIds);
        //gán Adapter vào Gridview
        gv.setAdapter(adapter);
        //thiết lập sự kiện để mở từng hình ảnh chitiết
        gv.setOnItemClickListener(this);
        //xu ly thoi gian\



    }

    /**
     * suffle array
     *
     * @param array
     */

    //ramdom
    private static void shuffleArray(Integer[] array) {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            if (index != i) {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }

    public void onItemClick(AdapterView<?> arg0,
                            View arg1, int arg2, long arg3) {
        //gọi hàm xem hình ảnh chi tiết tại ví trí thứ arg2
        //  showdetail(arg2);

        String name = getResources().getResourceEntryName(mThumbIds[arg2]);
//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        ImageView imageView =(ImageView)  arg1;
        String tmp = "R.drawable."+name;
//        imageView.setVisibility(View.INVISIBLE);
//        imageView.setImageResource(R.drawable.lifecycle);

        if (i == 0) {
            flag1 = name;
            i = 1;
        } else if (i == 1) {
            flag2 = name;
            if (flag1.equals(flag2)) {
//                imageView.setVisibility(View.INVISIBLE);
//                Toast.makeText(this,flag1, Toast.LENGTH_SHORT).show();

                Toast.makeText(this, "đúng", Toast.LENGTH_SHORT).show();
                i = 0;
            } else {
                Toast.makeText(this, "Sai", Toast.LENGTH_SHORT).show();
                i = 0;
            }

        }


    }

}