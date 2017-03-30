package com.example.kimsoohyeong.week5;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by KimSooHyeong on 2017. 3. 30..
 */

public class Fragment extends android.support.v4.app.Fragment {
    final String tableName[] = {"사과", "포도", "키위", "자몽"};
    final String membershipName[] = {"없습니다", "기본멤버쉽", "VIP멤버쉽"};
    Table table[] = new Table[4];
    Button b1, b2, b3, b4, b5, b6, b7;
    TextView t1, t2, t3, t4, t5, t6;
    int currentNum;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragView = inflater.inflate(R.layout.fragment, container, false);

        init(fragView);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum = 0;
                if (table[0].isEmpty()) {
                    Toast.makeText(v.getContext(), "비어있는 테이블입니다", Toast.LENGTH_SHORT).show();
                } else {
                    t1.setText(table[0].getTableName() + " 테이블");
                    t2.setText(table[0].getEnterTime());
                    t3.setText(Integer.toString(table[0].getSpaCnt()));
                    t4.setText(Integer.toString(table[0].getPizCnt()));
                    t5.setText(membershipName[table[0].getMembership()]);
                    t6.setText(Integer.toString(table[0].getTotal()));
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum = 1;
                if (table[1].isEmpty()) {
                    Toast.makeText(v.getContext(), "비어있는 테이블입니다", Toast.LENGTH_SHORT).show();
                } else {
                    t1.setText(table[1].getTableName() + " 테이블");
                    t2.setText(table[1].getEnterTime());
                    t3.setText(Integer.toString(table[1].getSpaCnt()));
                    t4.setText(Integer.toString(table[1].getPizCnt()));
                    t5.setText(membershipName[table[1].getMembership()]);
                    t6.setText(Integer.toString(table[1].getTotal()));
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum = 2;
                if (table[2].isEmpty()) {
                    Toast.makeText(v.getContext(), "비어있는 테이블입니다", Toast.LENGTH_SHORT).show();
                } else {
                    t1.setText(table[2].getTableName() + " 테이블");
                    t2.setText(table[2].getEnterTime());
                    t3.setText(Integer.toString(table[2].getSpaCnt()));
                    t4.setText(Integer.toString(table[2].getPizCnt()));
                    t5.setText(membershipName[table[2].getMembership()]);
                    t6.setText(Integer.toString(table[2].getTotal()));
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum = 3;
                if (table[3].isEmpty()) {
                    Toast.makeText(v.getContext(), "비어있는 테이블입니다", Toast.LENGTH_SHORT).show();
                } else {
                    t1.setText(table[3].getTableName() + " 테이블");
                    t2.setText(table[3].getEnterTime());
                    t3.setText(Integer.toString(table[3].getSpaCnt()));
                    t4.setText(Integer.toString(table[3].getPizCnt()));
                    t5.setText(membershipName[table[3].getMembership()]);
                    t6.setText(Integer.toString(table[3].getTotal()));
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View dialogView = inflater.inflate(R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(v.getContext());
                dlg.setTitle("주문을 해주세요")
                        .setView(dialogView)
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("취소", null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String str1, str2;
                                int cnt1, cnt2;
                                EditText e1, e2;
                                RadioButton r1, r2, r3;

                                e1 = (EditText)dialogView.findViewById(R.id.e1);
                                e2 = (EditText)dialogView.findViewById(R.id.e2);
                                r1 = (RadioButton)dialogView.findViewById(R.id.r1);
                                r2 = (RadioButton)dialogView.findViewById(R.id.r2);

                                str1 = e1.getText().toString();
                                str2 = e2.getText().toString();

                                cnt1 = str1.equals("") ? 0 : Integer.parseInt(str1);
                                cnt2 = str2.equals("") ? 0 : Integer.parseInt(str2);

                                SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd HH:mm");
                                String strTime = time.format(new Date());

                                table[currentNum].setData(strTime, cnt1, cnt2, r1.isChecked() ? 0 : r2.isChecked() ? 1 : 2);
                                Snackbar.make(fragView, "정보가 입력되었습니다", Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .show();
                String str1, str2, str3, str4, str5, str6;
                if (currentNum == 0) {

                } else if (currentNum == 1) {

                } else if (currentNum == 2) {

                } else if (currentNum == 3) {

                } else {

                }
            }
        });
        return fragView;
    }

    private void init(View v) {
        currentNum = -1;

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