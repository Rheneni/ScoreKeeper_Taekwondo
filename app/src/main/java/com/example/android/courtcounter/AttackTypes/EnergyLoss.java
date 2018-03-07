package com.example.android.courtcounter.AttackTypes;

/**
 * Created by Lenovo on 06/03/2018.
 */

public class EnergyLoss {
    public enum OwnEnergyLoss {
        PUNCH(5), TORSO_KICK(10), HEAD_KICK(15), ROUND_KICK(20), LOW_KICK(10), PUSH(5);
        private int m_value;

        OwnEnergyLoss(int value) {
            this.m_value = value;
        }

        public int getValue() {
            return this.m_value;
        }
    }

    public enum OtherEnergyLoss {
        PUNCH(1), TORSO_KICK(2), HEAD_KICK(3), ROUND_KICK(4), LOW_KICK(20), PUSH(10);
        private int m_value;

        OtherEnergyLoss(int value) {
            this.m_value = value;
        }

        public int getValue() {
            return this.m_value;
        }
    }
}
