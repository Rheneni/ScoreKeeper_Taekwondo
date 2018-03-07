package com.example.android.courtcounter.AttackTypes;

/**
 * Created by Lenovo on 05/03/2018.
 */

public class Punch extends Attack {
    static final Points POINTS = Points.PUNCH;
    static final EnergyLoss.OwnEnergyLoss OWN_ENERGY_LOSS = EnergyLoss.OwnEnergyLoss.PUNCH;
    static final EnergyLoss.OtherEnergyLoss OTHER_ENERGY_LOSS = EnergyLoss.OtherEnergyLoss.PUNCH;
    static final Fouls FOULS = Fouls.PUNCH;

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