package com.example.ady.PhotonChallenge.Util;

/**
 * Created by Ady on 1/25/2018.
 */

public class SavingPath {
    int nextPath;
    int rowTraversed;
    String Completed;
    int sum;
    int count = 0;

    public SavingPath(int nextPath, int rowTraversed) {
        this.nextPath = nextPath;
        this.rowTraversed = rowTraversed;
        setSum(nextPath);
        count ++;
    }
    public SavingPath() {
    }
    public void setSum(int path){
        sum +=path;
    }

    public int getSum(){
        return sum;
    }
    public String getCompleted() {
        return Completed;
    }

    public void setCompleted(String completed) {
        Completed = completed;
    }

    public int getNextPath() {
        return nextPath;
    }

    public void setNextPath(int nextPath) {

        this.nextPath = nextPath;
        setSum(nextPath);
    }

    public int getRowTraversed() {
        return rowTraversed;
    }

    public void setRowTraversed(int rowTraversed) {
        this.rowTraversed = rowTraversed;
    }
}
