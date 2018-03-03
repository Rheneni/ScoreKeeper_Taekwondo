package com.example.android.courtcounter;

/**
 * Created by Lenovo on 03/03/2018.
 */

public class Player {
    private int m_totalScore;
    private int m_fouls;
    private int m_energy;

    public Player() {
        m_totalScore = 0;
        m_fouls = 0;
        m_energy = 100;
    }
    public void addScore(int points) {
        m_totalScore += points;
    }

    public void setTotalScore(int totalScore) {
        m_totalScore = totalScore;
    }

    public void addFoul() {
        m_fouls++;
    }

    public void resetScore() {
        m_totalScore = 0;
        m_fouls = 0;
        m_energy = 100;    }


}
