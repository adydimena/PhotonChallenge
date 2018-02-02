/* Created by Ady
 * This is the Main Contractor. It sets up the interfaces that allow communication between presenter and view.
 */
package com.example.ady.PhotonChallenge.view.main;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;

import com.example.ady.PhotonChallenge.util.view.BasePresenter;
import com.example.ady.PhotonChallenge.util.view.BaseView;

import java.util.List;

public interface PhotonContract {
    // methods for the main Activity
    interface View extends BaseView {
        void setRowAndColmun(ArrayAdapter<Integer> row, ArrayAdapter<Integer> column);

        void setMatrix(Integer[][] matrix);

        void setPathRow(List<Integer> pathrow);

        void setSum(Integer sum);

        void setComplete(String Complete);

        void coloringTable(List<Integer> nextNum, List<Integer> rowPath);
    }

    interface Presenter extends BasePresenter<View> {
        void getRowAndColumn(Context context);

        void getTableSetup(TableLayout table, Integer userRowChoice, Integer userColumnChoice, Context context);

        void getRandom(Integer row, Integer column, TableLayout table, Context context);

        void getMatrix(TableLayout table, Integer userRowChoice, Integer userColumnChoice, Context context);

        void getComputeLowestCost(Integer[][] matrix, Integer userRowChoice, Integer userColumnChoice, Context context);
    }
}