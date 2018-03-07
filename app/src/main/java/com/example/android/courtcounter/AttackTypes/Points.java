package com.example.android.courtcounter.AttackTypes;

/**
 * Created by Lenovo on 05/03/2018.
 */

public enum Points {
    PUNCH(1), TORSO_KICK(2), HEAD_KICK(3), ROUND_KICK(4), LOW_KICK(0), PUSH(-1);
    private int m_value;

    Points(int value) {
        this.m_value = value;
    }

    public int getValue() {
        return this.m_value;
    }
}
