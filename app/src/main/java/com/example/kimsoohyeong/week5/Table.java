package com.example.kimsoohyeong.week5;

import android.text.format.Time;

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
        this.enterTime = Time.getCurrentTimezone();
        this.spaCnt = this.pizCnt = this.membership = this.total = 0;
        this.isEmpty = true;
    }

    public void clear() {
        enterTime = Time.getCurrentTimezone();
        this.spaCnt = this.pizCnt = this.membership = this.total = 0;
        this.isEmpty = true;
    }

    public void setData(String name, String time, int spa, int piz, int mem) {
        tableName = name;
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
