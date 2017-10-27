package me.xujichang.xfilemanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;

/**
 * Created by xjc on 2017/10/24。
 */

public class FileManagerMainActivity extends AppCompatActivity {

    private CardView cvPicture;
    private CardView cvVideo;
    private CardView cvDocument;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_maganer_main);

        cvPicture = (CardView)findViewById(R.id.cv_picture);
        cvVideo = (CardView)findViewById(R.id.cv_video);
        cvDocument = (CardView)findViewById(R.id.cv_document);
    }
}
