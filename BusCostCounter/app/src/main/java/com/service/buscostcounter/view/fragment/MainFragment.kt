package com.service.buscostcounter.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.service.buscostcounter.R
import com.service.buscostcounter.databinding.FragmentMainBinding
import com.service.buscostcounter.model.bus.BusTypes
import com.service.buscostcounter.model.bus.Electrical
import com.service.buscostcounter.model.bus.LiquidGas
import com.service.buscostcounter.model.bus.Petrol
import com.service.buscostcounter.utils.InputTextValidation
import com.service.buscostcounter.view.fragment.base.BaseFragmentWithViewModel
import com.service.buscostcounter.viewmodel.MainViewModel

class MainFragment : BaseFragmentWithViewModel<FragmentMainBinding, MainViewModel>() {

    override fun getLayoutResource(): Int {
        return R.layout.fragment_main
    }

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
    }

    fun onCheckClicked() {
        if (fieldsAreValid()) {
            countTheFastest()
            countFavorable()
            countCleanest()
        }
    }

    private fun fieldsAreValid(): Boolean {
        return InputTextValidation.checkIsFieldNullOrEmpty(
            context,
            binding.edtDistance,
            binding.tilDistance
        )
                && InputTextValidation.checkIsFieldNullOrEmpty(
            context,
            binding.edtStationCount,
            binding.tilStationCount
        )
                && InputTextValidation.checkIsFieldNullOrEmpty(
            context,
            binding.edtPassengerAverageCount,
            binding.tilPassengerAverageCount
        )
                && InputTextValidation.checkIsFieldNullOrEmpty(
            context,
            binding.edtOilCost,
            binding.tilOilCost
        )

    }

    private fun countTheFastest() {

        initDataForBuses()
        vm.collectArrayForChargeTime()
        getTargetBusType(vm.getTheTypeOfTargetWay(vm.spentTimeArr), binding.txtTheFastestWay)

        binding.fastest = vm.fastest
    }

    private fun getTargetBusType(busType: BusTypes, txtNeededBusWay: TextView) {
        when (busType) {
            BusTypes.ELECTRICAL -> {
                vm.fastest.bus = vm.electricalBus
                txtNeededBusWay.text = getString(R.string.electrical_bus)
            }
            BusTypes.PETROL -> {
                vm.fastest.bus = vm.petrolBus
                txtNeededBusWay.text = getString(R.string.petrol_bus)
            }
            BusTypes.LIQUID_GAS -> {
                vm.fastest.bus = vm.liquidGasBus
                txtNeededBusWay.text = getString(R.string.liquid_gas_bus)
            }
        }
    }

    private fun initDataForBuses() {
        val distance: Int = Integer.valueOf(binding.edtDistance.text.toString())
        val stationCount: Int = Integer.valueOf(binding.edtStationCount.text.toString())
        val averagePassengerCount =
            Integer.valueOf(binding.edtPassengerAverageCount.text.toString())
        val oilCost = Integer.valueOf(binding.edtOilCost.text.toString())

        vm.electricalBus = Electrical(distance, stationCount, averagePassengerCount, oilCost)
        vm.petrolBus = Petrol(distance, stationCount, averagePassengerCount, oilCost)
        vm.liquidGasBus = LiquidGas(distance, stationCount, averagePassengerCount, oilCost)
    }

    private fun countFavorable() {

        initDataForBuses()
        vm.collectArrayForFuelCost()

        getTargetBusType(vm.getTheTypeOfTargetWay(vm.fuelCostArr), binding.txtTheFavorableWay)

        binding.favorable = vm.favorable
    }

    private fun countCleanest() {

        initDataForBuses()
        vm.collectArrayAirPollution()

        getTargetBusType(vm.getTheTypeOfTargetWay(vm.airPollutionVolumeArr), binding.txtCleanestWay)

        binding.cleanest = vm.cleanest
    }


}
