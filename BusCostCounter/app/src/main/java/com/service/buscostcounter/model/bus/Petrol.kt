package com.service.buscostcounter.model.bus

class Petrol(distance : Int = 0, stationCount : Int = 0, avaregeCountOfPssengers : Int = 0, oilPrice : Int = 0)
    : Bus(distance, stationCount, avaregeCountOfPssengers, oilPrice){

    override fun getFixedDistance(): Int {
        return 800
    }

    override fun getHundredKmFuelCost(): Float {
        return 16.toFloat()
    }

    override fun getChargeTime(): Int {
        return 10
    }

    override fun airPollutionVolume(): Int {
        return 380
    }

}