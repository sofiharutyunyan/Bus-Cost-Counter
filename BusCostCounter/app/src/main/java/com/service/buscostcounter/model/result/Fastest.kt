package com.service.buscostcounter.model.result

class Fastest : BaseBustCosts() {

    override var fuelConsumption: Int
        get() = fuelConsumption
        set(value) {
            fuelConsumption = value
        }
    override var fuelCost: Float
        get() = fuelCost
        set(value) {
            fuelCost = value
        }
    override var ticketPrice: Int
        get() = ticketPrice
        set(value) {
            ticketPrice = value
        }
    override var airPollution: Int
        get() = airPollution
        set(value) {
            airPollution = value
        }


}