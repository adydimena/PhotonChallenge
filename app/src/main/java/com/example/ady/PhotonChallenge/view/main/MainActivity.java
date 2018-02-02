/* Created by Ady
 * This is my View on my MVP. This gets the result from the Presenter and sets up the views. It does some simple logic
 * such as traversing the matrix
 */
package com.example.ady.PhotonChallenge.view.main;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ady.PhotonChallenge.PhotonChallenge;
import com.example.ady.PhotonChallenge.R;

import java.util.List;

import javax.inject.Inject;
public class MainActivity extends AppCompatActivity implements MainContract.View, AdapterView.OnItemClickListener {
    @Inject
    MainPresenter mainPresenter;
    public static final String TAG = MainActivity.class.getSimpleName();
    Spinner rowOption, columnOption;
    Integer userRowChoice ;
    Integer userCloumnChoice ;
    TableLayout table;
    TextView displayYesNo,displaySum,displayPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PhotonChallenge.get(this).getMainComponent().inject(this);
        mainPresenter.attachView(this);
        bindSpinners();
        mainPresenter.getRowAndColumn(this);
        getRowandColomnbyChooseByUser();
        table = findViewById(R.id.table);
        BindResultViews();
    }
    private void BindResultViews() {
        displayYesNo = findViewById(R.id.displayYesNo);
        displaySum = findViewById(R.id.DisplaySum);
        displayPath = findViewById(R.id.DisplayPath);
    }
    private void getRowandColomnbyChooseByUser() {
        rowOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                userRowChoice = (Integer)(adapterView.getItemAtPosition(i)) ;
                Message message = handler.obtainMessage();
                message.what =1;
                message.arg1 = userRowChoice;
                handler.sendMessage(message);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        columnOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                userCloumnChoice = (Integer) (adapterView.getItemAtPosition(i)) ;
                Message message = handler.obtainMessage();
                message.what =2;
                message.arg1 = userCloumnChoice;
                handler.sendMessage(message);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    private void bindSpinners() {
        rowOption = findViewById(R.id.spinnerRow);
        columnOption = findViewById(R.id.spinnerColumn);
    }
    @Override
    public void ShowError(String messagee) {
        Toast.makeText(this, "ERROR " + messagee, Toast.LENGTH_LONG).show();
    }
    @Override
    public void setRowAndColmun(ArrayAdapter<Integer> row, ArrayAdapter<Integer> column) {
        rowOption.setAdapter(row);
        columnOption.setAdapter(column);
    }
    @Override
    public void setMatrix(Integer[][] matrix) {
        mainPresenter.getComputeLowestCost(matrix,userRowChoice,userCloumnChoice,this);
    }
    @Override
    public void setPathRow(List<Integer> pathrow) {
        displayPath.setText(" ");
        for (int j = 0; j <pathrow.size() ; j++) {
            displayPath.append(""+ pathrow.get(j));
        }
    }
    @Override
    public void setSum(Integer sum) {
        displaySum.setText(""+sum);
    }
    @Override
    public void setComplete(String Complete) {
        displayYesNo.setText(Complete);
    }
    @Override
    public void coloringTable(List<Integer> nextNum, List<Integer> rowPath) {
        EditText editText = new EditText(this);
        TableRow row = new TableRow(this);
        int k = 0;
        boolean isfound = false;
        for (int i = 0; i < userRowChoice ; i++) {
            row = (TableRow) table.getChildAt(i);
            for (int j = 0; j <userCloumnChoice ; j++) {
                editText = (EditText) row.getChildAt(j);
                editText.setBackgroundResource(R.color.white);
            }
        }
        for (int i = 0; i <rowPath.size() ; i++) {
            row = (TableRow) table.getChildAt(rowPath.get(i));
            isfound = false;
            for (int j = 0; j <userCloumnChoice ; j++) {
              editText = (EditText) row.getChildAt(j);
                if (Integer.parseInt(editText.getText().toString()) == nextNum.get(k)
                        && !isfound && j >=i){
                    editText.setBackgroundResource(R.color.Green);
                    isfound = true;
                }
            }
            k++;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "this", Toast.LENGTH_SHORT).show();
    }

    public void generateRandom(View view) {
        mainPresenter.getRandom(userRowChoice,userCloumnChoice,table,this);
    }
    public void run(View view) {
        boolean atLeatOneElementIsEmpty = false;
        TableRow row = new TableRow(this);
        EditText editText = new EditText(this);
        for (int i = 0; i < userRowChoice ; i++) {
            row = (TableRow) table.getChildAt(i);
            for (int j = 0; j <userCloumnChoice ; j++) {
                editText = (EditText) row.getChildAt(j);
                String dumyEditText = editText.getText().toString();
                if (dumyEditText.matches("")){
                    atLeatOneElementIsEmpty = true;
                }
            }
        }
        if (atLeatOneElementIsEmpty)
            Toast.makeText(this,"Make Sure You filled out the All fields of the matrix ", Toast.LENGTH_LONG ).show();
        if(!atLeatOneElementIsEmpty)
            mainPresenter.getMatrix(table, userRowChoice, userCloumnChoice, this);
    }


      static Handler  handler; // todo changed this to a different class

    {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    userRowChoice = msg.arg1;
                }
                if (msg.what == 2) {
                    userCloumnChoice = msg.arg1;
                }
                mainPresenter.getTableSetup(table, userRowChoice, userCloumnChoice, MainActivity.this);
            }
        };
    }


}