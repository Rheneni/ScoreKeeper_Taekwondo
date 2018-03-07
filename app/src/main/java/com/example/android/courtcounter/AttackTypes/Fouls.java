package com.example.android.courtcounter.AttackTypes;

/**
 * Created by Lenovo on 06/03/2018.
 */

public enum Fouls {
    PUNCH(0), TORSO_KICK(0), HEAD_KICK(0), ROUND_KICK(0), LOW_KICK(1), PUSH(0);
    private int m_value;

    Fouls(int value) {
        this.m_value = value;
    }

    public int getValue() {
        return this.m_value;
    }
}
