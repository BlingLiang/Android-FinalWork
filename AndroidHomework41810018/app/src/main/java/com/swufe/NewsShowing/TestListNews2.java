package com.swufe.NewsShowing;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//爬取人民网财经新闻
public class TestListNews2 extends ListActivity implements Runnable, AdapterView.OnItemClickListener {

    Handler handler;
    private SimpleAdapter listItemAdapter; // 适配器


    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListView();
        this.setListAdapter(listItemAdapter);
        getListView().setOnItemClickListener(this);
        Thread t = new Thread(this);
        t.start();


        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what == 3) {
                    List<HashMap<String, String>> tList = (List<HashMap<String, String>>) msg.obj;

                    SimpleAdapter adapter = new SimpleAdapter(TestListNews2.this, tList, // listItems数据源
                            R.layout.test_list_item, // ListItem的XML布局实现
                            new String[]{"Title", "url"},
                            new int[]{R.id.Title, R.id.url});
                    setListAdapter(adapter);

                }
                super.handleMessage(msg);
            }
        };
    }

    private void initListView() {
        // 存放文字、图片信息
        ArrayList<HashMap<String, String>> listItems = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("Title", "title：" + i+"：新闻正在爬取，请稍后2s"); // 标题文字
            listItems.add(map);
        }
        // 生成适配器的Item和动态数组对应的元素
        listItemAdapter = new SimpleAdapter(this, listItems, // listItems数据源
                R.layout.test_list_item,
                new String[]{"Title", "url"},
                new int[]{R.id.Title, R.id.url}
        );
    }

    public void run() {

        Log.i("thread", "run... ");
        List<HashMap<String, String>> testList = new ArrayList<HashMap<String, String>>();
        try {
            Thread.sleep(3000);
            Document doc = Jsoup.connect("http://money.people.com.cn/GB/218900/index.html").get();
            Elements mains = doc.getElementsByClass("ej_list_box");
            Element main = mains.get(0);

            //获取链接
            Elements lis = doc.getElementsByTag("li");
            Elements spans = main.getElementsByTag("a");
            for (int j = 0; j <= 15; j++) {
                String content = lis.get(j).getElementsByTag("a").attr("href");
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("url", content);
                Element span = spans.get(j);
                String spanStr = span.html();
                map.put("Title", spanStr);
                testList.add(map);
            }

        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Message msg = handler.obtainMessage(3);
        msg.obj = testList;
        handler.sendMessage(msg);


    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
            //从ListView中获取选中数据
            HashMap<String, String> map = (HashMap<String, String>) getListView().getItemAtPosition(position);
            String ur = map.get("url");


            //打开新的页面
            Uri uri = Uri.parse(ur);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (Exception e) {
            return;
        }


    }


}

