package com.service.buscostcounter.model.bus

open abstract class Bus (var distance : Int = 0, var stationCount : Int = 0, var avaregeCountOfPssengers : Int = 0, var oilCost : Int = 0){

    protected abstract fun getFixedDistance() : Int
    protected abstract fun getHundredKmFuelCost() : Float
    protected abstract fun getChargeTime() : Int
    protected abstract fun airPollutionVolume() : Int

    protected fun getOneStationCost() : Float{
       return (getFixedDistance() * 0.8 / 100).toFloat()
    }

    fun getFuelCostForOneKm() : Float{
        return getHundredKmFuelCost() / 100
    }

    fun getChargeTotalTime() : Int{
        return distance / getFixedDistance() * getChargeTime()
    }

    fun getTotalCostByStation() : Float{
        return getOneStationCost() * stationCount
    }

    fun getTotalCostByFuel() : Float {
        return getFuelCostForOneKm() * distance
    }

    fun getTotalFuelCost() : Float{
        return getTotalCostByFuel() + getTotalCostByStation()
    }

    fun getTotalAirPollutionVolume() : Int {
        return distance * airPollutionVolume()
    }

    fun getTicketPrice() : Int {
        return (getTotalFuelCost() / avaregeCountOfPssengers).toInt()
    }
}