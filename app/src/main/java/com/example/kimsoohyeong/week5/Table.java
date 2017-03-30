package com.example.kimsoohyeong.week5;

import android.text.format.Time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by KimSooHyeong on 2017. 3. 30..
 */

public class Table {
    private String tableName;
    private String enterTime;
    private int spaCnt;
    private int pizCnt;
    private int membership;
    private int total;
    private boolean isEmpty;

    public Table(String tableName) {
        this.tableName = tableName;
        SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd HH:mm");
        enterTime = time.format(new Date());
        spaCnt = pizCnt = membership = total = 0;
        isEmpty = true;
    }

    public void clear() {
        SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd HH:mm");
        enterTime = time.format(new Date());
        spaCnt = pizCnt = membership = total = 0;
        isEmpty = true;
    }

    public void setData(String time, int spa, int piz, int mem) {
        enterTime = time;
        spaCnt = spa;
        pizCnt = piz;
        membership = mem;

        total = spa * 10000 + piz * 12000;
        if (mem == 1) total = total / 10 * 9;
        else if (mem == 2) total = total / 10 * 7;

        isEmpty = false;
    }

    public String getTableName() {
        return tableName;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public int getSpaCnt() {
        return spaCnt;
    }

    public int getPizCnt() {
        return pizCnt;
    }

    public int getMembership() {
        return membership;
    }

    public int getTotal() {
        return total;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
