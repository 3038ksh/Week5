package com.example.kimsoohyeong.week5;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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
                    setData(0);
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
                    setData(1);
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
                    setData(2);
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
                    setData(3);
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum == -1) {
                    Toast.makeText(getContext(), "먼저 테이블을 선택해주세요", Toast.LENGTH_SHORT).show();
                    return ;
                }
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
                                setData(currentNum);
                                setTable(currentNum);
                                Snackbar.make(fragView, "정보가 입력되었습니다", Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum == -1) {
                    Toast.makeText(getContext(), "먼저 테이블을 선택해주세요", Toast.LENGTH_SHORT).show();
                    return ;
                }
                final View dialogView = inflater.inflate(R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(v.getContext());
                dlg.setTitle("주문내역 수정")
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
//                                r3 = (RadioButton)dialogView.findViewById(R.id.r3);

//                                e1.setText(table[currentNum].getSpaCnt());
//                                e2.setText(table[currentNum].getPizCnt());
//
//                                switch (table[currentNum].getMembership()) {
//                                    case 0:
//                                        r1.setChecked(true);
//                                        break;
//                                    case 1:
//                                        r2.setChecked(true);
//                                        break;
//                                    case 2:
//                                        r3.setChecked(true);
//                                        break;
//                                }

                                str1 = e1.getText().toString();
                                str2 = e2.getText().toString();

                                cnt1 = str1.equals("") ? 0 : Integer.parseInt(str1);
                                cnt2 = str2.equals("") ? 0 : Integer.parseInt(str2);

                                table[currentNum].setData(table[currentNum].getEnterTime(), cnt1, cnt2, r1.isChecked() ? 0 : r2.isChecked() ? 1 : 2);
                                setData(currentNum);
                                Snackbar.make(fragView, "수정되었습니다", Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum == -1) {
                    Toast.makeText(getContext(), "먼저 테이블을 선택해주세요", Toast.LENGTH_SHORT).show();
                    return ;
                }
                table[currentNum].clear();
                clearData(currentNum);
            }
        });
        return fragView;
    }

    private void setData(int idx) {
        t1.setText(table[idx].getTableName() + " 테이블");
        t2.setText(table[idx].getEnterTime());
        t3.setText(Integer.toString(table[idx].getSpaCnt()));
        t4.setText(Integer.toString(table[idx].getPizCnt()));
        t5.setText(membershipName[table[idx].getMembership()]);
        t6.setText(Integer.toString(table[idx].getTotal()));
    }

    private void setTable(int idx) {
        switch (idx) {
            case 0:
                b1.setText(tableName[idx] + " table");
                break;
            case 1:
                b2.setText(tableName[idx] + " table");
                break;
            case 2:
                b3.setText(tableName[idx] + " table");
                break;
            case 4:
                b4.setText(tableName[idx] + " table");
                break;
        }
    }
    private void clearData(int idx) {
        switch (idx) {
            case 0:
                b1.setText(tableName[idx] + " table(비어있음)");
                break;
            case 1:
                b2.setText(tableName[idx] + " table(비어있음)");
                break;
            case 2:
                b3.setText(tableName[idx] + " table(비어있음)");
                break;
            case 4:
                b4.setText(tableName[idx] + " table(비어있음)");
                break;
        }
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
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