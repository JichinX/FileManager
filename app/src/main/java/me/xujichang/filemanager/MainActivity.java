package me.xujichang.filemanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvFileExplore;
    private TextView tvFileVideo;
    private TextView tvFilePicture;
    private TextView tvFileClassification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tvFileExplore = (TextView)findViewById(R.id.tv_file_explore);
        tvFileVideo = (TextView)findViewById(R.id.tv_file_video);
        tvFilePicture = (TextView)findViewById(R.id.tv_file_picture);
        tvFileClassification = (TextView)findViewById(R.id.tv_file_classification);

        tvFileExplore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //浏览全部文件
            }
        });
        tvFileVideo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //浏览视频文件
            }
        });
        tvFilePicture.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //浏览图片文件
            }
        });
        tvFileClassification.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //浏览分类文件
            }
        });
    }
}
