package com.example.ady.PhotonChallenge;

import com.example.ady.PhotonChallenge.model.PathCalculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is the test file. To run it please click the class the select run.
 */
public class PhotonApplicationTest {
    int delta = 0;

    @Test
    public void costCalculator1IsCompleted() {
        Integer[][] matrix = new Integer[][]{
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 8, 6, 4}
        };
        Integer userRowChoice = 5;
        Integer userColumnChoice = 6;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        String expected = "YES";
        String actutal = PathCalculator.getComplete();

        assertEquals("The costCalculator1IsCompleted Failed", expected, actutal);
    }

    @Test
    public void costCalculator2() {
        Integer[][] matrix = new Integer[][]{
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 1, 2, 3}
        };
        Integer userRowChoice = 5;
        Integer userColumnChoice = 6;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        Integer expected = 11;
        Integer actutal = PathCalculator.getSum();

        assertEquals("The costCalculator2 Failed", expected, actutal, delta);
    }

    @Test
    public void costCalculator2IsCompleted() {
        Integer[][] matrix = new Integer[][]{
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 1, 2, 3}
        };
        Integer userRowChoice = 5;
        Integer userColumnChoice = 6;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        String expected = "YES";
        String actutal = PathCalculator.getComplete();
        assertEquals("The costCalculator2IsCompleted Failed", expected, actutal);
    }

    @Test
    public void costCalculator3IsCompleted() {
        Integer[][] matrix = new Integer[][]{
                {19, 10, 19, 10, 19},
                {21, 23, 20, 19, 12},
                {20, 12, 20, 11, 10}
        };
        Integer userRowChoice = 3;
        Integer userColumnChoice = 5;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        String expected = "NO";
        String actutal = PathCalculator.getComplete();
        assertEquals("The costCalculator3IsCompleted Failed", expected, actutal);

    }

    @Test
    public void costCalculator4() {
        Integer[][] matrix = new Integer[][]{
                {5, 8, 5, 3, 5}
        };
        Integer userRowChoice = 1;
        Integer userColumnChoice = 5;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        Integer expected = 26;
        Integer actutal = PathCalculator.getSum();

        assertEquals("The costCalculator4 Failed", expected, actutal, delta);

    }

    @Test
    public void costCalculator1() {
        Integer[][] matrix = new Integer[][]{
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 8, 6, 4}
        };
        Integer userRowChoice = 5;
        Integer userColumnChoice = 6;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        Integer expected = 16;
        Integer actutal = PathCalculator.getSum();

        assertEquals("The costCalculator1 Failed", expected, actutal, 1);
    }

    @Test
    public void costCalculator4IsCompleted() {
        Integer[][] matrix = new Integer[][]{
                {5, 8, 5, 3, 5}
        };
        Integer userRowChoice = 1;
        Integer userColumnChoice = 5;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        String expected = "YES";
        String actutal = PathCalculator.getComplete();
        assertEquals("The costCalculator4IsCompleted Failed", expected, actutal);

    }

    @Test
    public void costCalculator5() {
        Integer[][] matrix = new Integer[][]{
                {5},
                {8},
                {5},
                {3},
                {5}
        };
        Integer userRowChoice = 5;
        Integer userColumnChoice = 1;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        Integer expected = 3;
        Integer actutal = PathCalculator.getSum();

        assertEquals("The costCalculator5 Failed", expected, actutal, delta);
    }

    @Test
    public void costCalculator5IsCompleted() {
        Integer[][] matrix = new Integer[][]{
                {5},
                {8},
                {5},
                {3},
                {5}
        };
        Integer userRowChoice = 5;
        Integer userColumnChoice = 1;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        String expected = "YES";
        String actutal = PathCalculator.getComplete();
        assertEquals("The costCalculator5IsCompleted Failed", expected, actutal);
    }

    @Test
    public void costCalculator8() {
        Integer[][] matrix = new Integer[][]{
                {69, 10, 19, 10, 19},
                {51, 23, 20, 19, 12},
                {60, 12, 20, 11, 10}
        };
        Integer userRowChoice = 3;
        Integer userColumnChoice = 5;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        Integer expected = 0;
        Integer actutal = PathCalculator.getSum();

        assertEquals("The costCalculator8 Failed", expected, actutal, delta);
    }

    @Test
    public void costCalculator8IsCompleted() {
        Integer[][] matrix = new Integer[][]{
                {69, 10, 19, 10, 19},
                {51, 23, 20, 19, 12},
                {60, 12, 20, 11, 10}
        };
        Integer userRowChoice = 3;
        Integer userColumnChoice = 5;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        String expected = "NO";
        String actutal = PathCalculator.getComplete();
        assertEquals("The costCalculator8IsCompleted Failed", expected, actutal);
    }

    @Test
    public void costCalculator9() {
        Integer[][] matrix = new Integer[][]{
                {60, 3, 3, 6},
                {6, 3, 7, 9},
                {5, 6, 8, 3}
        };
        Integer userRowChoice = 3;
        Integer userColumnChoice = 4;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        Integer expected = 14;
        Integer actutal = PathCalculator.getSum();
        assertEquals("The costCalculator9 Failed", expected, actutal, delta);
    }

    @Test
    public void costCalculator9IsCompleted() {
        Integer[][] matrix = new Integer[][]{
                {60, 3, 3, 6},
                {6, 3, 7, 9},
                {5, 6, 8, 3}
        };
        Integer userRowChoice = 3;
        Integer userColumnChoice = 4;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        String expected = "YES";
        String actutal = PathCalculator.getComplete();
        assertEquals("The costCalculator9IsCompleted Failed", expected, actutal);
    }

    @Test
    public void costCalculator10isCompleted() {
        Integer[][] matrix = new Integer[][]{
                {6, 3, -5, 9},
                {-5, 2, 4, 10},
                {3, -2, 6, 10},
                {6, -1, -2, 10}
        };
        Integer userRowChoice = 4;
        Integer userColumnChoice = 4;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        String expected = "YES";
        String actutal = PathCalculator.getComplete();
        assertEquals("The costCalculator10IsCompleted Failed", expected, actutal);
    }

    @Test
    public void costCalculator11() {
        Integer[][] matrix = new Integer[][]{
                {51, 51},
                {0, 51},
                {51, 51},
                {5, 5}
        };
        Integer userRowChoice = 4;
        Integer userColumnChoice = 2;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        Integer expected = 10;
        Integer actutal = PathCalculator.getSum();

        assertEquals("The costCalculator11 Failed", expected, actutal, delta);
    }

    @Test
    public void costCalculator11Iscompleted() {
        Integer[][] matrix = new Integer[][]{
                {51, 51},
                {0, 51},
                {51, 51},
                {5, 5}
        };
        Integer userRowChoice = 4;
        Integer userColumnChoice = 2;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        String expected = "YES";
        String actutal = PathCalculator.getComplete();
        assertEquals("The costCalculator10IsCompleted Failed", expected, actutal);
    }

    @Test
    public void costCalculator12() {
        Integer[][] matrix = new Integer[][]{
                {51, 51, 51},
                {0, 51, 51},
                {51, 51, 51},
                {5, 5, 51}
        };
        Integer userRowChoice = 4;
        Integer userColumnChoice = 3;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        Integer expected = 10;
        Integer actutal = PathCalculator.getSum();

        assertEquals("The costCalculator11 Failed", expected, actutal, delta);
    }

    @Test
    public void costCalculator12IsCompleted() {
        Integer[][] matrix = new Integer[][]{
                {51, 51, 51},
                {0, 51, 51},
                {51, 51, 51},
                {5, 5, 51}
        };
        Integer userRowChoice = 4;
        Integer userColumnChoice = 3;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        String expected = "NO";
        String actutal = PathCalculator.getComplete();
        assertEquals("The costCalculator10IsCompleted Failed", expected, actutal);
    }

    @Test
    public void costCalculator13() {
        Integer[][] matrix = new Integer[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        Integer userRowChoice = 2;
        Integer userColumnChoice = 20;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        Integer expected = 20;
        Integer actutal = PathCalculator.getSum();

        assertEquals("The costCalculator11 Failed", expected, actutal, delta);
    }

    @Test
    public void costCalculator13IsCompleted() {
        Integer[][] matrix = new Integer[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        Integer userRowChoice = 2;
        Integer userColumnChoice = 20;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        String expected = "YES";
        String actutal = PathCalculator.getComplete();
        assertEquals("The costCalculator10IsCompleted Failed", expected, actutal);
    }
}