package com.example.android.courtcounter;

import com.example.android.courtcounter.AttackTypes.Attack;

import java.util.Random;

/**
 * Created by Lenovo on 03/03/2018.
 */

public class Player {
    static final int PERCENT_100 = 100;
    static final int MIN_ENERGY = 10;
    private int m_totalScore;
    private int m_fouls;
    private int m_energy;

    public Player() {
        m_totalScore = 0;
        m_fouls = 0;
        m_energy = 100;
    }

    public int addScore(int points) {
        m_totalScore += points;
        return m_totalScore;
    }

    public int getTotalScore() {
        return m_totalScore;
    }

    public void setTotalScore(int totalScore) {
        m_totalScore = totalScore;
    }

    public int addFoul() {
        return ++m_fouls;
    }

    public int addFoul(int fouls) {
        return m_fouls += fouls;
    }

    public int getFouls() {
        return m_fouls;
    }

    public int addEnergy(int energy) {
        return m_energy += energy;
    }

    public int getEnergy() {
        return m_energy;
    }

    public void setEnergy(int energy) {
        m_energy = energy;
    }

    public int loseEnergy(int energy) {
        return m_energy -= energy;
    }

    //returns scored value
    public <T extends Attack> int updatePlayer(T attack, Player otherPlayer) {
        float chance = calculateChance(otherPlayer);
        Random rand = new Random();
        float randNum = rand.nextInt(PERCENT_100 + 1);
        int scored = 0;
        if (randNum <= chance) {
            this.m_totalScore += scored = attack.getPoints().getValue();
            this.m_fouls = addFoul(attack.getFouls().getValue());
        }
        this.m_energy = loseEnergy(attack.getOwnEnergyLoss().getValue());
        if (this.m_energy < MIN_ENERGY) {
            this.m_energy = MIN_ENERGY;
        }

        otherPlayer.loseEnergy(attack.getOtherEnergyLoss().getValue());
        if (otherPlayer.getEnergy() < MIN_ENERGY) {
            otherPlayer.setEnergy(MIN_ENERGY);
        }

        return scored;
    }

    private float calculateChance(Player otherPlayer) {
        return 100 * this.m_energy / (this.m_energy + otherPlayer.getEnergy());
    }

    public void resetScore() {
        m_totalScore = 0;
        m_fouls = 0;
        m_energy = 100;    }
}
