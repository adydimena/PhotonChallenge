package com.example.ady.PhotonChallenge.View.main;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.example.ady.PhotonChallenge.Data.Remote.NewsDataSource;
import com.example.ady.PhotonChallenge.R;
import com.example.ady.PhotonChallenge.Util.SavingPath;
import com.example.ady.PhotonChallenge.Util.pojo.GetNews;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import javax.inject.Inject;

/**
 * Created by Ady on 1/14/2018.
 */

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;
    NewsDataSource newsDataSource;
    GetNews dummyGetnews = null;

    @Inject
    public MainPresenter(NewsDataSource newsDataSource){
        this.newsDataSource = newsDataSource;
    }

    public MainPresenter() {
        //
    }
    @Override
    public void attachView(MainContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }

    @Override
    public void getrowsANDcolumns(Context context) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();
        for (int i =1 ; i < 6 ; i++) {
            rows.add(i);
        }
        for (int i = 5; i <101 ; i++) {
            columns.add(i);
        }
        ArrayAdapter<Integer> rowadapter = new ArrayAdapter<Integer>(context,
                R.layout.support_simple_spinner_dropdown_item,rows);
        ArrayAdapter<Integer> columnadapter = new ArrayAdapter<Integer>(context,
                R.layout.support_simple_spinner_dropdown_item,columns);
        view.setrowsANDClomuns(rowadapter,columnadapter);
    }

    @Override
    public void getTableSetup(TableLayout table, Integer userRowChoice, Integer userColumnChoice, Context context) {

        TableRow tableRow;
        EditText[] etItem = new EditText[userColumnChoice];
        table.removeAllViews();
        for (int i = 0; i <userRowChoice ; i++) {
            tableRow = new TableRow(context);
            for (int j = 0; j <userColumnChoice ; j++) {
                TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                tableRow.setLayoutParams(lp);
                etItem[j] = new EditText(context);
                etItem[j].setWidth(250);
                etItem[j].setHeight(300);

                tableRow.addView(etItem[j]);

            }
            table.addView(tableRow,i);
        }
    }

    @Override
    public void getRandom(Integer userrowChoice, Integer column, TableLayout table, Context context) {
        TableRow row = new TableRow(context);
        EditText editText = new EditText(context);
        Random random = new Random();
        for (int i = 0; i < userrowChoice ; i++) {
            row = (TableRow) table.getChildAt(i);
            for (int j = 0; j <column ; j++) {
                editText = (EditText) row.getChildAt(j);
                editText.setBackgroundResource(R.color.white);
                editText.setText(""+random.nextInt(20));
            }
        }
    }

    @Override
    public void getMatrix(TableLayout table, Integer userRowChoice, Integer userColumnChoice, Context context) {
        TableRow row = new TableRow(context);
        EditText editText = new EditText(context);
        Integer[][] matrix = new Integer[userRowChoice][userColumnChoice];
        for (int i = 0; i < userRowChoice ; i++) {
            row = (TableRow) table.getChildAt(i);
            for (int j = 0; j <userColumnChoice ; j++) {
                editText = (EditText) row.getChildAt(j);
                matrix[i][j]=Integer.parseInt(editText.getText().toString());
            }
        }
        view.setMatrix(matrix);

    }

    @Override
    public void getComputeLowestCost(Integer[][] matrix, Integer userRowChoice, Integer userColumnChoice, Context context) {
        List<Integer> toCompare = new ArrayList<>();
        List<Integer> pathrow = new ArrayList<>();
        List<Integer> nextNum = new ArrayList<>();
        int sum = 0;
        int min = 0;
        int next = 0;
        int rowindex = 0;
        List<SavingPath> savingPaths = new ArrayList<>();
        String Complete = "YES";
        for (int i = 0; i <userColumnChoice ; i++) {
            for (int j = 0; j <userRowChoice ; j++) {
                toCompare.add(matrix[j][i]);
            }

            if(i==0) {
                min = toCompare.get(0);
                for (int j = 0; j < toCompare.size(); j++) {
                    if (min > toCompare.get(j)) {
                        min = toCompare.get(j);
                        rowindex = j;
                    }
                }
                next = min;
            }
            else {
                if (toCompare.size() > 3){

                    if (rowindex == 0) {
                        next = toCompare.get(0);
                        rowindex = 0;
                        if (next > toCompare.get(1)) {
                            next = toCompare.get(1);
                            rowindex = 1;
                        }
                        if (next > toCompare.get(toCompare.size() - 1)) {
                            next = toCompare.get(toCompare.size() - 1);
                            rowindex = toCompare.size() - 1;
                        }
                    } else if (rowindex == toCompare.size() - 1) {
                        next = toCompare.get(0);
                        rowindex = 0;
                        if (next > toCompare.get(toCompare.size() - 1)) {
                            next = toCompare.get(toCompare.size() - 1);
                            rowindex = toCompare.size() - 1;
                        }
                        if (next > toCompare.get(toCompare.size() - 2)) {
                            next = toCompare.get(toCompare.size() - 2);
                            rowindex = toCompare.size() - 2;
                        }
                    } else {
                        next = toCompare.get(rowindex - 1);
                        int k = rowindex-1;
                        rowindex -=1;
                        for (int j = k; j < k + 2; j++) {
                            if (next > toCompare.get(j)) {
                                next = toCompare.get(j);
                                rowindex = j;
                            }
                        }
                    }
            }else{
                    min = toCompare.get(0);
                    rowindex = 0;
                    for (int j = 0; j < toCompare.size(); j++) {
                        if (min > toCompare.get(j)) {
                            min = toCompare.get(j);
                            rowindex = j;
                        }
                    }
                    next = min;
                }
            }


            if(sum + next >= 50 ){
                Complete = "NO";
                break;
            }
            nextNum.add(next);
            sum += next;
            pathrow.add(rowindex);
            toCompare.clear();
            //Toast.makeText(this, "the min is "+ min
            //      , Toast.LENGTH_SHORT).show();

        }
        view.ColoringTable(nextNum,pathrow);
        view.setPathRow(pathrow);
        view.setSum(sum);
        view.setComplete(Complete);
        pathrow.clear();
    }


}
