package com.service.buscostcounter.model.bus

class Petrol(var petDistance : Int = 0, var petStationCount : Int = 0)
    : Bus(petDistance, petStationCount){

    override fun getFixedDistance(): Int {
        return 800
    }

    override fun getHundredKmFuelCost(): Int {
        return 16
    }

    override fun getChargeTime(): Int {
        return 10
    }

    override fun airPolutionVolume(): Int {
        return 380
    }

}