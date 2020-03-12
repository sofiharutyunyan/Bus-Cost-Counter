package com.service.buscostcounter.view.fragment

import android.os.Bundle
import android.view.View
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
        return InputTextValidation.checkIsFieldNullOrEmpty(context, binding.edtDistance, binding.tilDistance)
                && InputTextValidation.checkIsFieldNullOrEmpty(context, binding.edtStationCount, binding.tilStationCount)
                && InputTextValidation.checkIsFieldNullOrEmpty(context, binding.edtPassengerAverageCount, binding.tilPassengerAverageCount)
                && InputTextValidation.checkIsFieldNullOrEmpty(context, binding.edtOilCost, binding.tilOilCost)

    }

    private fun countTheFastest() {
        val distance: Int = Integer.valueOf(binding.edtDistance.text.toString())
        val stationCount: Int = Integer.valueOf(binding.edtStationCount.text.toString())

        val electricalBus = Electrical(distance, stationCount)
        val petrolBus = Petrol(distance, stationCount)
        val liquidGasBus = LiquidGas(distance, stationCount)

        vm.spentTimeArr.add(electricalBus.getChargeTotalTime())
        vm.spentTimeArr.add(petrolBus.getChargeTotalTime())
        vm.spentTimeArr.add(liquidGasBus.getChargeTotalTime())

        when (vm.getTheTypeOfFavourable()){
            BusTypes.ELECTRICAL -> vm.fastest.bus = electricalBus
            BusTypes.PETROL -> vm.fastest.bus = petrolBus
            BusTypes.LIQUID_GAS -> vm.fastest.bus = liquidGasBus
        }

        binding.fastest = vm.fastest
    }

    private fun countFavorable() {

        val distance: Int = Integer.valueOf(binding.edtDistance.text.toString())
        val stationCount: Int = Integer.valueOf(binding.edtStationCount.text.toString())

        val electricalBus = Electrical(distance, stationCount)
        val petrolBus = Petrol(distance, stationCount)
        val liquidGasBus = LiquidGas(distance, stationCount)

        vm.fuelCostArr.add(electricalBus.getTotalFuelCost())
        vm.fuelCostArr.add(petrolBus.getTotalFuelCost())
        vm.fuelCostArr.add(liquidGasBus.getTotalFuelCost())

        binding.favorable = vm.favorable
        binding.busTypes = vm.getTheTypeOfFavourable()
    }

    private fun countCleanest() {

        val distance: Int = Integer.valueOf(binding.edtDistance.text.toString())
        val stationCount: Int = Integer.valueOf(binding.edtStationCount.text.toString())

        val electricalBus = Electrical(distance, stationCount)
        val petrolBus = Petrol(distance, stationCount)
        val liquidGasBus = LiquidGas(distance, stationCount)

        vm.airPollutionVolumeArr.add(electricalBus.getTotalAirPollutionVolume())
        vm.airPollutionVolumeArr.add(petrolBus.getTotalAirPollutionVolume())
        vm.airPollutionVolumeArr.add(liquidGasBus.getTotalAirPollutionVolume())

        binding.cleanest = vm.cleanest
    }


}
