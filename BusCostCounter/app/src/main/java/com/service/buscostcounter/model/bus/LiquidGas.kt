package com.service.buscostcounter.model.bus

class LiquidGas(var liqDistance : Int = 0, var liqStationCount : Int = 0)
    : Bus(liqDistance, liqStationCount){

    override fun getFixedDistance(): Int {
        return 1000
    }

    override fun getHundredKmFuelCost(): Int {
        return 18
    }

    override fun getChargeTime(): Int {
        return 25
    }

    override fun airPollutionVolume(): Int {
        return 290
    }
}