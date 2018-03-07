package com.example.android.courtcounter.AttackTypes;

/**
 * Created by Lenovo on 06/03/2018.
 */

public class HeadKick extends Attack {
    static final Points POINTS = Points.HEAD_KICK;
    static final EnergyLoss.OwnEnergyLoss OWN_ENERGY_LOSS = EnergyLoss.OwnEnergyLoss.HEAD_KICK;
    static final EnergyLoss.OtherEnergyLoss OTHER_ENERGY_LOSS = EnergyLoss.OtherEnergyLoss.HEAD_KICK;
    static final Fouls FOULS = Fouls.HEAD_KICK;

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