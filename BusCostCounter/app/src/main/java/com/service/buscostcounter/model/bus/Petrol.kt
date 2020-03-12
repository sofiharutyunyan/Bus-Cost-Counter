package com.service.buscostcounter.model.bus

class Petrol(var petDistance : Int = 0, var petStationCount : Int = 0, var petAvaregeCountOfPssengers : Int = 0, var petOilCost : Int = 0)
    : Bus(petDistance, petStationCount, petAvaregeCountOfPssengers, petOilCost){

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