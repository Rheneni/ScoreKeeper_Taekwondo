package com.example.android.courtcounter.AttackTypes;

/**
 * Created by Lenovo on 06/03/2018.
 */

public class TorsoKick extends Attack {
    static final Points POINTS = Points.TORSO_KICK;
    static final EnergyLoss.OwnEnergyLoss OWN_ENERGY_LOSS = EnergyLoss.OwnEnergyLoss.TORSO_KICK;
    static final EnergyLoss.OtherEnergyLoss OTHER_ENERGY_LOSS = EnergyLoss.OtherEnergyLoss.TORSO_KICK;
    static final Fouls FOULS = Fouls.TORSO_KICK;

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
