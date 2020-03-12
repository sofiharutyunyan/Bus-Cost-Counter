package com.service.buscostcounter.model.result

class Favorable : BaseBustCosts() {

    override var fuelConsumption: Int = 0

    override var fuelCost: Float = 0.toFloat()

    override var ticketPrice: Int = 0

    override var airPollution: Int = 0

}