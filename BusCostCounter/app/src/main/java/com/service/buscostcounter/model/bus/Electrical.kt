package com.service.buscostcounter.model.bus

class Electrical(var elDistance : Int = 0, var elStationCount : Int = 0, var elAvaregeCountOfPssengers : Int = 0, var elOilCost : Int = 0)
    : Bus(elDistance, elStationCount, elAvaregeCountOfPssengers, elOilCost){

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