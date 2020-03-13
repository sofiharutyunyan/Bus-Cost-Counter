package com.service.buscostcounter.model.bus

class LiquidGas(var liqDistance : Int = 0, var liqStationCount : Int = 0, var liqAvaregeCountOfPssengers : Int = 0, var liqOilPrice : Int = 0)
    : Bus(liqDistance, liqStationCount, liqAvaregeCountOfPssengers, liqOilPrice){

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