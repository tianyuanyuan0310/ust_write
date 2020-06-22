package com.example.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<all_star> all_starList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL); //瀑布流
        //GridLayoutManager layoutManager = new GridLayoutManager(this,5);  //网格排列
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);  //垂直排列
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);   //加了横向排列
        recyclerView.setLayoutManager(layoutManager);
        all_starAdapter adapter = new all_starAdapter(all_starList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            all_star hd = new all_star(getRandomLengthName("H D"), R.drawable.hd);
            all_starList.add(hd);
            all_star jinitaimei = new all_star(getRandomLengthName("yes"), R.drawable.jinitaimei);
            all_starList.add(jinitaimei);
            all_star kaomianjin = new all_star(getRandomLengthName("烤面筋"), R.drawable.kaomianjin);
            all_starList.add(kaomianjin);
            all_star houyanwuchi = new all_star(getRandomLengthName("厚颜无耻之人"), R.drawable.houyanwuchi);
            all_starList.add(houyanwuchi);
            all_star yuanshou = new all_star(getRandomLengthName("厚元首的蛋蛋"), R.drawable.yuanshou);
            all_starList.add(yuanshou);
            all_star lbw = new all_star(getRandomLengthName("我卢本伟没开挂"), R.drawable.lbw);
            all_starList.add(lbw);
            all_star xiangjiaojun = new all_star(getRandomLengthName("香蕉君"), R.drawable.xiangjiaojun);
            all_starList.add(xiangjiaojun);
            all_star mht = new all_star(getRandomLengthName("再充5W"), R.drawable.mht);
            all_starList.add(mht);
            all_star aoligei = new all_star(getRandomLengthName("奥利给"), R.drawable.aoligei);
            all_starList.add(aoligei);
            all_star bili = new all_star(getRandomLengthName("比利王"), R.drawable.bili);
            all_starList.add(bili);
        }
    }
    private String getRandomLengthName(String name){
        Random random = new Random();
        int length= random.nextInt(20)+1;  // 产生1-20的随机数
        StringBuilder builder = new StringBuilder();
        for (int i =0;i<length;i++){
            builder.append(name);
        }
        return  builder.toString();
    }

}
