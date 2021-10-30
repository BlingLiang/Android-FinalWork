package com.swufe.NewsShowing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
// http://www.mrcj88.cn                            每日财经网      TestListNews1
// http://money.people.com.cn/GB/218900/index.html 人民网财经新闻  TestListNews2
// http://news.baidu.com/finance                   百度财经新闻    TestListNews3
// http://stock.10jqka.com.cn/bkfy_list/           同花顺         TestListNews4
// https://finance.eastmoney.com                   东方财富       TestListNews5
// https://www.caijing.com.cn                      中国财经新闻网  TestListNews6
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.t1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestListNews1.class));
                //通过上面的代码可以实现点击按钮跳转到另一个页面
                //通过上面的代码可以实现点击按钮跳转网页
            }
        });
        findViewById(R.id.t2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestListNews2.class));
                //通过上面的代码可以实现点击按钮跳转到另一个页面
                //通过上面的代码可以实现点击按钮跳转网页
            }
        });
        findViewById(R.id.t3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestListNews3.class));
                //通过上面的代码可以实现点击按钮跳转到另一个页面
                //通过上面的代码可以实现点击按钮跳转网页
            }
        });
        findViewById(R.id.t4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestListNews4.class));
                //通过上面的代码可以实现点击按钮跳转到另一个页面
                //通过上面的代码可以实现点击按钮跳转网页
            }
        });
        findViewById(R.id.t5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestListNews5.class));
                //通过上面的代码可以实现点击按钮跳转到另一个页面
                //通过上面的代码可以实现点击按钮跳转网页
            }
        });
        findViewById(R.id.t6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestListNews6.class));
                //通过上面的代码可以实现点击按钮跳转到另一个页面
                //通过上面的代码可以实现点击按钮跳转网页
            }
        });
    }
}