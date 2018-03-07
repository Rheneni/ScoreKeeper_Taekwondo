package com.example.android.courtcounter.AttackTypes;

/**
 * Created by Lenovo on 06/03/2018.
 */

public class RoundKick extends Attack {
    static final Points POINTS = Points.ROUND_KICK;
    static final EnergyLoss.OwnEnergyLoss OWN_ENERGY_LOSS = EnergyLoss.OwnEnergyLoss.ROUND_KICK;
    static final EnergyLoss.OtherEnergyLoss OTHER_ENERGY_LOSS = EnergyLoss.OtherEnergyLoss.ROUND_KICK;
    static final Fouls FOULS = Fouls.ROUND_KICK;

    public Points getPoints() {
        return POINTS;
    }

    public EnergyLoss.OwnEnergyLoss getOwnEnergyLoss() {
        return OWN_ENERGY_LOSS;
    }

    public EnergyLoss.OtherEnergyLoss getOtherEnergyLoss() {
        return OTHER_ENERGY_LOSS;
    }

    public Fouls getFouls() {
        return FOULS;
    }
}