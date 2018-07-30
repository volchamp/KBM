package com.example.xch.tbsfilebrowsing;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                //动态权限申请
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{ Manifest.permission. WRITE_EXTERNAL_STORAGE }, 1);
                } else {
                    FileDisplayActivity.actionStart(MainActivity.this,fileUrl,fileName);
                }

                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    FileDisplayActivity.actionStart(MainActivity.this,fileUrl,fileName);
                } else {
                    Toast.makeText(this, "你拒绝了权限申请，可能无法下载文件到本地哟！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}
