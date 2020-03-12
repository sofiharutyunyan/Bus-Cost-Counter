package com.service.buscostcounter.model.bus

class Electrical(var elDistance : Int = 0, var elStationCount : Int = 0)
    : Bus(elDistance, elStationCount){

    override fun getFixedDistance(): Int {
        return 600
    }

    override fun getHundredKmFuelCost(): Int {
        return 60
    }

    override fun getChargeTime(): Int {
        return 40
    }

    override fun airPolutionVolume(): Int {
        return 0
    }

}