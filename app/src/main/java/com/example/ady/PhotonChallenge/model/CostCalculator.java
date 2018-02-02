/* Created by Ady
 * This is the model. It computes the lower path cost of a martix. the presenter can get any results
 * by calling the getters to get the cost, the row number and the element of the matrix.
 */
package com.example.ady.PhotonChallenge.model;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Ady.
 * This is my model From my MVP. This class takes a matrix, the number of Column and Row and computes the lower path cost,
 * the actual wor and the element it passes through.
 */
public class CostCalculator {
    public static final String TAG = CostCalculator.class.getSimpleName();
    List<List<Integer>> pathRow ;
    List<List<Integer>> nextNum ;
    List<String> complete = new ArrayList<>();
    List<Integer> sum = new ArrayList<>();
    //  dummy variables
    List<Integer> toCompare = new ArrayList<>();
    List<Integer> firstColumn = new ArrayList<>();
    List<Integer> simplePathRow ;
    List<Integer> simpleNextNum ;
    public CostCalculator(Integer[][] matrix, Integer userRowChoice, Integer userColumnChoice) {
        int somation =0 ;
        int min = 0;
        int next =0;
        int rowIndex = 0;
        int dummyCounter = 101;
        pathRow = new ArrayList<>();
        nextNum = new ArrayList<>();
        for (int j = 0; j < userRowChoice; j++) {
            firstColumn.add(matrix[j][0]); // getting the first column
        }
        for (int p = 0; p < userRowChoice; p++) {// most outter loop. iteration = 1complete path
            this.complete.add("YES");
            simpleNextNum = new ArrayList<>();
            simplePathRow = new ArrayList<>();
            somation =0;
            inneerLoop:
            for (int i = 0; i < userColumnChoice; i++) {
                for (int j = 0; j < userRowChoice; j++) { // getting the next Column, saving in toCompare.
                    toCompare.add(matrix[j][i]); // getting the column
                }
                if (p != dummyCounter) { // if this is the first column or next Column
                    dummyCounter = p;
                    min = firstColumn.get(p);
                    rowIndex = p;
                    next = min;
                } else { // not the first ccolumn
                    if (toCompare.size() > 3) { // if there are more then 3 rows, analize only the row you are,
                        // the row above and the row bellow
                        if (rowIndex == 0) { // the matrix is adj. so look to the last row
                            next = toCompare.get(0); // assuming the element in front is the best choice
                            rowIndex = 0; // assuming the next row will be the element in front
                            if (next > toCompare.get(1)) { // however if the element above is smaller, go there
                                next = toCompare.get(1);
                                rowIndex = 1;
                            }
                            if (next > toCompare.get(toCompare.size() - 1)) { // checking the last row
                                next = toCompare.get(toCompare.size() - 1);
                                rowIndex = toCompare.size() - 1;
                            }
                        } else if (rowIndex == toCompare.size() - 1) { // the matrix is Adj, so look to first row
                            next = toCompare.get(0); // assuming this is the best choice, for the next number
                            rowIndex = 0; // assuming this is the next row
                            if (next > toCompare.get(toCompare.size() - 1)) {
                                next = toCompare.get(toCompare.size() - 1);
                                rowIndex = toCompare.size() - 1;
                            }
                            if (next > toCompare.get(toCompare.size() - 2)) {
                                next = toCompare.get(toCompare.size() - 2);
                                rowIndex = toCompare.size() - 2;
                            }
                        } else { // not in the first or last row
                            next = toCompare.get(rowIndex - 1);
                            int k = rowIndex - 1;
                            rowIndex -= 1;
                            for (int j = k; j < k + 2; j++) {
                                if (next > toCompare.get(j)) {
                                    next = toCompare.get(j);
                                    rowIndex = j;
                                }
                            }
                        }
                    } else { // there is 3 or fewer rows. can analize the entire column
                        min = toCompare.get(0);
                        rowIndex = 0;
                        for (int j = 0; j < toCompare.size(); j++) {
                            if (min > toCompare.get(j)) {
                                min = toCompare.get(j);
                                rowIndex = j;
                            }
                        }
                        next = min;
                    }
                }
                if (somation + next >= 50) { // stop if sum is more than 50
                    this.complete.set(p,"NO");
                    break ;
                }
                somation += next;
                this.simplePathRow.add(rowIndex);
                this.simpleNextNum.add(next);
                this.toCompare.clear();
            }
            this.sum.add(somation);
            this.nextNum.add(simpleNextNum);
            this.pathRow.add(simplePathRow);
        }
    }
    public CostCalculator() {
    }
    public List<Integer> getPathRow() {
        return this.pathRow.get(getLowestCostIndex());
    }
    public List<Integer> getNextNum() {

        return nextNum.get(getLowestCostIndex());
    }
    public int getSum() {

        return sum.get(getLowestCostIndex());
    }
    public String getComplete() {

        return complete.get(getLowestCostIndex());
    }
    public void clear (){
        this.nextNum.clear();
        this.pathRow.clear();
    }
    public int getLowestCostIndex(){
        int index=0;
        int min = 0;
        min = this.sum.get(0);
        for (int i = 0; i <this.sum.size() ; i++) {
           if (min == 0){
        min = this.sum.get(i);
                index = i;
            }
        }
        for (int i = 0; i <this.sum.size() ; i++) {
                if (min > this.sum.get(i) && this.sum.get(i) != 0) {
                    min = this.sum.get(i);
                    index = i;
                }
        }
        return index;
    }
}