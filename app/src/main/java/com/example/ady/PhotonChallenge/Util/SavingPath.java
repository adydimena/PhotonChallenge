package com.example.ady.PhotonChallenge.Util;

/**
 * Created by Ady on 1/25/2018.
 */

public class SavingPath {
    int nextPath;
    int rowTraversed;

    public SavingPath(int nextPath, int rowTraversed) {
        this.nextPath = nextPath;
        this.rowTraversed = rowTraversed;
    }

    public int getNextPath() {
        return nextPath;
    }

    public void setNextPath(int nextPath) {
        this.nextPath = nextPath;
    }

    public int getRowTraversed() {
        return rowTraversed;
    }

    public void setRowTraversed(int rowTraversed) {
        this.rowTraversed = rowTraversed;
    }
}
