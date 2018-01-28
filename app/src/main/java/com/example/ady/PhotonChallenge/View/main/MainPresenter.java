/* Created by Ady
 * This is the Presenter. beacuse this project is simple the presenter does some (simple) computations. But in inorder to
 * compute the lowest cost it call the model( CostCalculator) to do the work and then it passes the result to the view.
 */
package com.example.ady.PhotonChallenge.View.main;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;


import com.example.ady.PhotonChallenge.R;
import com.example.ady.PhotonChallenge.Model.CostCalculator;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

/**
 * Created by Ady on 1/14/2018.
 */

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;



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
        CostCalculator costCalculator = new CostCalculator(matrix,userRowChoice,userColumnChoice);
        view.ColoringTable(costCalculator.getNextNum(),costCalculator.getPathrow());
        view.setPathRow(costCalculator.getPathrow());
        view.setSum(costCalculator.getSum());
        view.setComplete(costCalculator.getComplete());
        costCalculator.clear();
    }


}
