package com.example.ady.PhotonChallenge;

import android.test.suitebuilder.annotation.SmallTest;

import com.example.ady.PhotonChallenge.model.PathCalculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.nio.file.Path;

import static org.junit.Assert.*;

/**
 * This is the test file. To run it please click the class the select run.
 */

@SmallTest
public class PhotonApplicationTest {
    int delta;
    Integer actualInt;
    String actual;
    Integer expectedInt;
    String expected;

    @Before
    public void preWork(){
        delta = 0;
    }

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
        PathCalculator pathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        expected = "YES";
        actual = pathCalculator.getComplete();
        assertEquals("The costCalculator1IsCompleted Failed", expected, actual);
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
        expectedInt = 11;
        actualInt = PathCalculator.getSum();
        assertEquals("The costCalculator2 Failed", expectedInt, actualInt, delta);
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
        expected = "YES";
        actual = PathCalculator.getComplete();
        assertEquals("The costCalculator2IsCompleted Failed", expected, actual);
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
        expected = "NO";
        actual = PathCalculator.getComplete();
        assertEquals("The costCalculator3IsCompleted Failed", expected, actual);
    }

    @Test
    public void costCalculator4() {
        Integer[][] matrix = new Integer[][]{
                {5, 8, 5, 3, 5}
        };
        Integer userRowChoice = 1;
        Integer userColumnChoice = 5;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        expectedInt = 26;
        actualInt = PathCalculator.getSum();

        assertEquals("The costCalculator4 Failed", expectedInt, actualInt, delta);

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
        expectedInt = 16;
        actualInt = PathCalculator.getSum();

        assertEquals("The costCalculator1 Failed", expectedInt, actualInt, 1);
    }

    @Test
    public void costCalculator4IsCompleted() {
        Integer[][] matrix = new Integer[][]{
                {5, 8, 5, 3, 5}
        };
        Integer userRowChoice = 1;
        Integer userColumnChoice = 5;
        PathCalculator PathCalculator = new PathCalculator(matrix, userRowChoice, userColumnChoice);
        expected = "YES";
        actual = PathCalculator.getComplete();
        assertEquals("The costCalculator4IsCompleted Failed", expected, actual);
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
        expectedInt = 3;
        actualInt = PathCalculator.getSum();
        assertEquals("The costCalculator5 Failed", expectedInt, actualInt, delta);
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
        expected = "YES";
        actual = PathCalculator.getComplete();
        assertEquals("The costCalculator5IsCompleted Failed", expected, actual);
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
        expectedInt = 0;
        actualInt = PathCalculator.getSum();
        assertEquals("The costCalculator8 Failed", expectedInt, actualInt, delta);
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
        expected = "NO";
        actual = PathCalculator.getComplete();
        assertEquals("The costCalculator8IsCompleted Failed", expected, actual);
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
        expectedInt = 14;
        actualInt = PathCalculator.getSum();
        assertEquals("The costCalculator9 Failed", expectedInt, actualInt, delta);
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
        expected = "YES";
        actual = PathCalculator.getComplete();
        assertEquals("The costCalculator9IsCompleted Failed", expected, actual);
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
        expected = "YES";
        actual = PathCalculator.getComplete();
        assertEquals("The costCalculator10IsCompleted Failed", expected, actual);
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
        expectedInt = 10;
        actualInt = PathCalculator.getSum();
        assertEquals("The costCalculator11 Failed", expectedInt, actualInt, delta);
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
        expected = "YES";
        actual = PathCalculator.getComplete();
        assertEquals("The costCalculator10IsCompleted Failed", expected, actual);
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
        Integer actual = PathCalculator.getSum();

        assertEquals("The costCalculator11 Failed", expected, actual, delta);
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
        String actual = PathCalculator.getComplete();
        assertEquals("The costCalculator10IsCompleted Failed", expected, actual);
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
        Integer actual = PathCalculator.getSum();

        assertEquals("The costCalculator11 Failed", expected, actual, delta);
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
        String actual = PathCalculator.getComplete();
        assertEquals("The costCalculator10IsCompleted Failed", expected, actual);
    }
}