/* Created by Ady
 * This is my View on my MVP. This gets the result from the Presenter and sets up the views. It does some simple logic
 * such as traversing the matrix
 */
package com.example.ady.PhotonChallenge.View.main;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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
    Integer userRowChoice =1  ,userCloumnChoice=5 ;
    TableLayout table;
    TextView displayYesNo,displaySum,displayPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PhotonChallenge.get(this).getMainComponent().inject(this);
        mainPresenter.attachView(this);
        // any operation after this....
        bindSpinners();
        mainPresenter.getrowsANDcolumns(this);
        getRowandColomnbyChooseByUser();
        table = findViewById(R.id.table);
       // mainPresenter.getTableSetup(table,userRowChoice,userCloumnChoice,this);
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
    public void setrowsANDClomuns(ArrayAdapter<Integer> row, ArrayAdapter<Integer> column) {
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
    public void ColoringTable(List<Integer> nextNum, List<Integer> rowPath) {
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
                if (Integer.parseInt(editText.getText().toString()) == nextNum.get(k) && !isfound && j >=i){
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

        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 1){
                    userRowChoice = msg.arg1;
                }
                if(msg.what == 2){
                    userCloumnChoice = msg.arg1;
                }
                if (table != null) {
                    mainPresenter.getTableSetup(table, userRowChoice, userCloumnChoice, MainActivity.this);
                }

            }
        };

    public void generateRandom(View view) {
        mainPresenter.getRandom(userRowChoice,userCloumnChoice,table,this);
    }

    public void run(View view) {
        mainPresenter.getMatrix(table,userRowChoice,userCloumnChoice,this);
        /*
        String Complete = "YES";
        TableRow row = new TableRow(this);
        EditText editText = new EditText(this);
        Integer[][] matrix = new Integer[userRowChoice][userCloumnChoice];
        List<Integer> toCompare = new ArrayList<>();
        List<Integer> pathrow = new ArrayList<>();
        displayPath.setText(" ");
        for (int i = 0; i < userRowChoice ; i++) {
            row = (TableRow) table.getChildAt(i);
            for (int j = 0; j <userCloumnChoice ; j++) {
                editText = (EditText) row.getChildAt(j);
                matrix[i][j]=Integer.parseInt(editText.getText().toString());
            }
        }
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                //Toast.makeText(this, ""+matrix[i][j], Toast.LENGTH_SHORT).show();
            }
        }
        int sum = 0;
        int min = 0;
        int k = 0;
        pathrow.clear();
        for (int i = 0; i <userCloumnChoice ; i++) {
            for (int j = 0; j <userRowChoice ; j++) {
              // Toast.makeText(this, ""+matrix[j][i], Toast.LENGTH_SHORT).show();
               toCompare.add(matrix[j][i]);
            }
            min = toCompare.get(0);
            int rowindex = 0;
            for (int j = 0; j <toCompare.size() ; j++) {
                if (min > toCompare.get(j)){
                    min = toCompare.get(j);
                    rowindex = j;
                }
            }
            if(sum + min >= 50 ){
                Complete = "NO";
                break;
            }
            sum += min;
            pathrow.add(rowindex);
            toCompare.clear();
            //Toast.makeText(this, "the min is "+ min
              //      , Toast.LENGTH_SHORT).show();

        }
        for (int j = 0; j <pathrow.size() ; j++) {
            displayPath.append(""+ pathrow.get(j));
        }
        displaySum.setText(""+sum);
        displayYesNo.setText(Complete);
        */

    }
}