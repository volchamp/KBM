package com.example.xch.tbsfilebrowsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_fileBrowsing;
    private String fileName="TBS测试.docx";
    private String fileUrl="http://123.207.239.170/test.docx";//远程文档地址，如下载失败请验证此链接是否还可用（那个时候可能我养不住服务器了）

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_fileBrowsing=findViewById(R.id.btn_fileBrowsing);
        btn_fileBrowsing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_fileBrowsing:
                FileDisplayActivity.actionStart(MainActivity.this,fileUrl,fileName);
                break;
            default:
                break;
        }
    }
}
