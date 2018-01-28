/* Created by Ady
 * This is the model. It computes the lower path cost of a martix. the presenter can get any results
 * by calling the getters to get the cost, the row number and the element of the matrix.
 */
package com.example.ady.PhotonChallenge.Model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ady on 1/25/2018.
 * This is my model From my MVP. This class takes a matrix, the number of Column and Row and computes the lower path cost,
 * the actual wor and the element it passes through.
 */

public class CostCalculator {
    List<Integer> toCompare = new ArrayList<>();
    List<Integer> pathrow = new ArrayList<>();
    List<Integer> nextNum = new ArrayList<>();
    int sum = 0;
    int min = 0;
    int next = 0;
    int rowindex = 0;
    String Complete;

    public CostCalculator(Integer[][] matrix, Integer userRowChoice, Integer userColumnChoice) {
        this.Complete="YES";
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
                this.Complete = "NO";
                break;
            }
            this.nextNum.add(next);
            this.sum += next;
            this.pathrow.add(rowindex);
            toCompare.clear();
            //Toast.makeText(this, "the min is "+ min
            //      , Toast.LENGTH_SHORT).show();
        }
    }
    public CostCalculator() {
    }

    public List<Integer> getPathrow() {
        return pathrow;
    }

    public List<Integer> getNextNum() {
        return nextNum;
    }

    public int getSum() {
        return sum;
    }

    public String getComplete() {
        return Complete;
    }
    public void clear (){
        this.getPathrow().clear();
    }
}
