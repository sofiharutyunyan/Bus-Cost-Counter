package com.service.buscostcounter.model.bus

class Electrical(distance : Int = 0, stationCount : Int = 0, avaregeCountOfPssengers : Int = 0, oilPrice : Int = 0)
    : Bus(distance, stationCount, avaregeCountOfPssengers, oilPrice){

    override fun getFixedDistance(): Int {
        return 600
    }

    override fun getHundredKmFuelCost(): Float {
        return 60.toFloat()
    }

    override fun getChargeTime(): Int {
        return 40
    }

    override fun airPollutionVolume(): Int {
        return 0
    }

}