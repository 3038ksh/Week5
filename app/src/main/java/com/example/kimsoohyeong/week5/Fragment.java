package com.example.kimsoohyeong.week5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by KimSooHyeong on 2017. 3. 30..
 */

public class Fragment extends android.support.v4.app.Fragment {
    final String tableName[] = {"사과", "포도", "키위", "자몽"};
    final String membershipName[] = {"없습니다", "기본멤버쉽", "VIP멤버쉽"};
    Table table[] = new Table[4];
    Button b1, b2, b3, b4, b5, b6, b7;
    TextView t1, t2, t3, t4, t5, t6;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragView = inflater.inflate(R.layout.fragment, container, false);

        init(fragView);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (table[0].isEmpty()) {
                    Toast.makeText(v.getContext(), "비어있는 테이블입니다", Toast.LENGTH_SHORT).show();
                } else {
                    t1.setText(table[0].getTableName() + " 테이블");
                    t2.setText(table[0].getEnterTime());
                    t3.setText(table[0].getSpaCnt());
                    t4.setText(table[0].getPizCnt());
                    t5.setText(membershipName[table[0].getMembership()]);
                    t6.setText(table[0].getTotal());
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (table[1].isEmpty()) {
                    Toast.makeText(v.getContext(), "비어있는 테이블입니다", Toast.LENGTH_SHORT).show();
                } else {
                    t1.setText(table[1].getTableName() + " 테이블");
                    t2.setText(table[1].getEnterTime());
                    t3.setText(table[1].getSpaCnt());
                    t4.setText(table[1].getPizCnt());
                    t5.setText(membershipName[table[1].getMembership()]);
                    t6.setText(table[1].getTotal());
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (table[2].isEmpty()) {
                    Toast.makeText(v.getContext(), "비어있는 테이블입니다", Toast.LENGTH_SHORT).show();
                } else {
                    t1.setText(table[2].getTableName() + " 테이블");
                    t2.setText(table[2].getEnterTime());
                    t3.setText(table[2].getSpaCnt());
                    t4.setText(table[2].getPizCnt());
                    t5.setText(membershipName[table[2].getMembership()]);
                    t6.setText(table[2].getTotal());
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (table[3].isEmpty()) {
                    Toast.makeText(v.getContext(), "비어있는 테이블입니다", Toast.LENGTH_SHORT).show();
                } else {
                    t1.setText(table[3].getTableName() + " 테이블");
                    t2.setText(table[3].getEnterTime());
                    t3.setText(table[3].getSpaCnt());
                    t4.setText(table[3].getPizCnt());
                    t5.setText(membershipName[table[3].getMembership()]);
                    t6.setText(table[3].getTotal());
                }
            }
        });
        return fragView;
    }

    private void init(View v) {
        b1 = (Button)v.findViewById(R.id.b1);
        b2 = (Button)v.findViewById(R.id.b2);
        b3 = (Button)v.findViewById(R.id.b3);
        b4 = (Button)v.findViewById(R.id.b4);
        b5 = (Button)v.findViewById(R.id.b5);
        b6 = (Button)v.findViewById(R.id.b6);
        b7 = (Button)v.findViewById(R.id.b7);
        t1 = (TextView)v.findViewById(R.id.t1);
        t2 = (TextView)v.findViewById(R.id.t2);
        t3 = (TextView)v.findViewById(R.id.t3);
        t4 = (TextView)v.findViewById(R.id.t4);
        t5 = (TextView)v.findViewById(R.id.t5);
        t6 = (TextView)v.findViewById(R.id.t6);

        for (int i = 0; i < 4; i++)
            table[i] = new Table(tableName[i]);
    }
}