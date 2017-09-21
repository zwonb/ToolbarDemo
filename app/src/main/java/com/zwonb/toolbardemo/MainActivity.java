package com.zwonb.toolbardemo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //开启返回键
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setTitle("这是标题");
        //设置标题跟返回按钮的间距
        toolbar.setContentInsetStartWithNavigation(0);
        //设置导航按钮图标
        toolbar.setNavigationIcon(R.mipmap.ic_toolbar_navigation);
        //导航按钮的点击监听
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了导航按钮", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //创建菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //对菜单进行修改
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.getItem(0).setIcon(R.mipmap.ic_photo);
        menu.getItem(1).setIcon(R.mipmap.ic_search);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //点击导航栏
//            case android.R.id.home:
//                Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.toolbar_menu1:
                Toast.makeText(this, "点击菜单1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_menu2:
                Toast.makeText(this, "点击菜单2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_menu3:
                Toast.makeText(this, "点击菜单3", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
