package com.example.android.courtcounter.AttackTypes;

/**
 * Created by Lenovo on 05/03/2018.
 */

public abstract class Attack {
    public abstract Points getPoints();

    public abstract EnergyLoss.OwnEnergyLoss getOwnEnergyLoss();

    public abstract EnergyLoss.OtherEnergyLoss getOtherEnergyLoss();

    public abstract Fouls getFouls();
}
