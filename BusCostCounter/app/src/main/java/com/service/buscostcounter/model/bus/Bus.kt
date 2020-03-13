package com.service.buscostcounter.model.bus

abstract class Bus(
    private var distance: Int = 0,
    private var stationCount: Int = 0,
    private var avaregeCountOfPssengers: Int = 0,
    var oilPrise: Int = 0
) {

    protected abstract fun getFixedDistance(): Int
    protected abstract fun getHundredKmFuelCost(): Float
    protected abstract fun getChargeTime(): Int
    protected abstract fun airPollutionVolume(): Int

    private fun getOneStationCost(): Float {
        return (getFixedDistance() * 0.8 / 100).toFloat()
    }

    private fun getFuelCostForOneKm(): Float {
        return getHundredKmFuelCost() / 100
    }

    fun getChargeTotalTime(): Int {
        return distance / getFixedDistance() * getChargeTime()
    }

    private fun getTotalCostByStation(): Float {
        return getOneStationCost() * stationCount
    }

    fun getTotalCostByFuel(): Float {
        return getFuelCostForOneKm() * distance
    }

    fun getTotalFuelCost(): Float {
        return getTotalCostByFuel() + getTotalCostByStation()
    }

    fun getTotalAirPollutionVolume(): Int {
        return distance * airPollutionVolume()
    }

    fun getTicketPrice(): Int {
        return (getTotalFuelCost() / avaregeCountOfPssengers).toInt()
    }
}