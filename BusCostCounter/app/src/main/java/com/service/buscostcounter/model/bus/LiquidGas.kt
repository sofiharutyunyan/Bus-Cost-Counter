package com.service.buscostcounter.model.bus

class LiquidGas(distance : Int = 0, stationCount : Int = 0, averageCountOfPassenger : Int = 0, oilPrice : Int = 0)
    : Bus(distance, stationCount, averageCountOfPassenger, oilPrice){

    override fun getFixedDistance(): Int {
        return 1000
    }

    override fun getHundredKmFuelCost(): Float {
        return 18.toFloat()
    }

    override fun getChargeTime(): Int {
        return 25
    }

    override fun airPollutionVolume(): Int {
        return 290
    }
}