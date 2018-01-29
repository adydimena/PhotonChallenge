package com.example.ady.PhotonChallenge;

import com.example.ady.PhotonChallenge.model.costCalculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is the test file. To run it please click the class the select run.
 */
public class PhotonChallengeTest {
    @Test
    public void costCalculator1() {
        Integer[][] matrix = new Integer[][]{
                { 3, 4, 1, 2, 8, 6 },
                { 6, 1, 8, 2, 7, 4 },
                { 5, 9, 3, 9, 9, 5 },
                { 8, 4, 1, 3, 2, 6 },
                { 3, 7, 2, 8, 6, 4 }
        };
        Integer userRowChoice = 5;
        Integer userColumnChoice = 6;
        costCalculator costCalculator = new costCalculator(matrix,userRowChoice,userColumnChoice);
        Integer expected = 16;
        Integer actutal = costCalculator.getSum();
        int delta = 2;
        assertEquals("The costCalculator1 Failed",expected, actutal,delta);
    }
    @Test
    public void costCalculator2() {
        Integer[][] matrix = new Integer[][]{
                { 3, 4, 1, 2, 8, 6 },
                { 6, 1, 8, 2, 7, 4 },
                { 5, 9, 3, 9, 9, 5 },
                { 8, 4, 1, 3, 2, 6 },
                { 3, 7, 2, 1, 2, 3 }
        };
        Integer userRowChoice = 5;
        Integer userColumnChoice = 6;
        costCalculator costCalculator = new costCalculator(matrix,userRowChoice,userColumnChoice);
        Integer expected = 11;
        Integer actutal = costCalculator.getSum();
        int delta = 2;
        assertEquals("The costCalculator2 Failed",expected, actutal,delta);
    }
    @Test
    public void costCalculator3() {
        Integer[][] matrix = new Integer[][]{
                { 19, 10, 19, 10, 19 },
                { 21, 23, 20, 19, 12 },
                { 20, 12, 20, 11, 10 }
        };
        Integer userRowChoice = 3;
        Integer userColumnChoice = 5;
        costCalculator costCalculator = new costCalculator(matrix,userRowChoice,userColumnChoice);
        Integer expected = 48;
        Integer actutal = costCalculator.getSum();
        int delta = 2;
        assertEquals("The costCalculator3 Failed",expected, actutal,delta);

    }
    @Test
    public void costCalculator4() {
        Integer[][] matrix = new Integer[][]{
                { 5, 8, 5, 3, 5 }
        };
        Integer userRowChoice = 1;
        Integer userColumnChoice = 5;
        costCalculator costCalculator = new costCalculator(matrix,userRowChoice,userColumnChoice);
        Integer expected = 26;
        Integer actutal = costCalculator.getSum();
        int delta = 2;
        assertEquals("The costCalculator4 Failed",expected, actutal,delta);

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
        costCalculator costCalculator = new costCalculator(matrix,userRowChoice,userColumnChoice);
        Integer expected = 3;
        Integer actutal = costCalculator.getSum();
        int delta = 2;
        assertEquals("The costCalculator5 Failed",expected, actutal,delta);
    }
    @Test
    public void costCalculator8() {
        Integer[][] matrix = new Integer[][]{
                { 69, 10, 19, 10, 19 },
                { 51, 23, 20, 19, 12 },
                { 60, 12, 20, 11, 10 }
        };
        Integer userRowChoice = 3;
        Integer userColumnChoice = 5;
        costCalculator costCalculator = new costCalculator(matrix,userRowChoice,userColumnChoice);
        Integer expected = 0;
        Integer actutal = costCalculator.getSum();
        int delta = 2;
        assertEquals("The costCalculator8 Failed",expected, actutal,delta);
    }
    @Test
    public void costCalculator9() {
        Integer[][] matrix = new Integer[][]{
                { 60, 3, 3, 6 },
                { 6, 3, 7, 9 },
                { 5, 6, 8, 3 }
        };
        Integer userRowChoice = 3;
        Integer userColumnChoice = 4;
        costCalculator costCalculator = new costCalculator(matrix,userRowChoice,userColumnChoice);
        Integer expected = 14;
        Integer actutal = costCalculator.getSum();
        int delta = 2;
        assertEquals("The costCalculator9 Failed",expected, actutal,delta);
    }
    @Test
    public void costCalculator10() {
        Integer[][] matrix = new Integer[][]{
                { 6, 3, -5, 9 },
                { -5, 2, 4, 10 },
                { 3, -2, 6, 10 },
                {6,-1,-2,10}
        };
        Integer userRowChoice = 4;
        Integer userColumnChoice = 4;
        costCalculator costCalculator = new costCalculator(matrix,userRowChoice,userColumnChoice);
        Integer expected = 0;
        Integer actutal = costCalculator.getSum();
        int delta = 2;
        assertEquals("The costCalculator10 Failed",expected, actutal,delta);
    }
    @Test
    public void costCalculator11() {
        Integer[][] matrix = new Integer[][]{
                { 6, 3, -5, 9 },
                { -5, 2, 4, 10 },
                { 3, -2, 6, 10 },
                {6,-1,-2,10}
        };
        Integer userRowChoice = 4;
        Integer userColumnChoice = 4;
        costCalculator costCalculator = new costCalculator(matrix,userRowChoice,userColumnChoice);
        Integer expected = 0;
        Integer actutal = costCalculator.getSum();
        int delta = 2;
        assertEquals("The costCalculator11 Failed",expected, actutal,delta);
    }
}