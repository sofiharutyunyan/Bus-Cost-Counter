package com.service.buscostcounter.model.result

open abstract class BaseBustCosts {

    abstract var fuelConsumption: Int
    abstract var fuelCost: Float
    abstract var ticketPrice: Int
    abstract var airPollution: Int
}