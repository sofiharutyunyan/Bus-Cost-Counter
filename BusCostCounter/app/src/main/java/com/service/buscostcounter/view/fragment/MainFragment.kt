package com.service.buscostcounter.view.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.IntegerRes
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
        val averagePassengerCount = Integer.valueOf(binding.edtPassengerAverageCount.text.toString())
        val oilCost = Integer.valueOf(binding.edtOilCost.text.toString())

        val electricalBus = Electrical(distance, stationCount, averagePassengerCount, oilCost)
        val petrolBus = Petrol(distance, stationCount, averagePassengerCount, oilCost)
        val liquidGasBus = LiquidGas(distance, stationCount, averagePassengerCount, oilCost)

        vm.spentTimeArr.add(electricalBus.getChargeTotalTime())
        vm.spentTimeArr.add(petrolBus.getChargeTotalTime())
        vm.spentTimeArr.add(liquidGasBus.getChargeTotalTime())

        when (vm.getTheTypeOfFastest()){
            BusTypes.ELECTRICAL -> {
                vm.fastest.bus = electricalBus
                binding.txtTheFastestWay.text = "Electrical"
            }
            BusTypes.PETROL -> {
                vm.fastest.bus = petrolBus
                binding.txtTheFastestWay.text = "Petrol"
            }
            BusTypes.LIQUID_GAS -> {
                vm.fastest.bus = liquidGasBus
                binding.txtTheFastestWay.text = "Liquid gas"
            }
        }

        binding.fastest = vm.fastest
    }

    private fun countFavorable() {

        val distance: Int = Integer.valueOf(binding.edtDistance.text.toString())
        val stationCount: Int = Integer.valueOf(binding.edtStationCount.text.toString())
        val averagePassengerCount = Integer.valueOf(binding.edtPassengerAverageCount.text.toString())
        val oilCost = Integer.valueOf(binding.edtOilCost.text.toString())

        val electricalBus = Electrical(distance, stationCount, averagePassengerCount, oilCost)
        val petrolBus = Petrol(distance, stationCount, averagePassengerCount, oilCost)
        val liquidGasBus = LiquidGas(distance, stationCount, averagePassengerCount, oilCost)

        vm.fuelCostArr.add(electricalBus.getTotalFuelCost())
        vm.fuelCostArr.add(petrolBus.getTotalFuelCost())
        vm.fuelCostArr.add(liquidGasBus.getTotalFuelCost())

        when (vm.getTheTypeOfFavourable()){
            BusTypes.ELECTRICAL -> {
                vm.favorable.bus = electricalBus
                binding.txtTheFavorableWay.text = "Electrical"
            }
            BusTypes.PETROL -> {
                vm.favorable.bus = petrolBus

                binding.txtTheFavorableWay.text = "Petrol"
            }
            BusTypes.LIQUID_GAS -> {
                vm.favorable.bus = liquidGasBus
                binding.txtTheFavorableWay.text = "Liquid gas"
            }
        }

        binding.favorable = vm.favorable
//        binding.busTypes = vm.getTheTypeOfFavourable()
    }

    private fun countCleanest() {

        val distance: Int = Integer.valueOf(binding.edtDistance.text.toString())
        val stationCount: Int = Integer.valueOf(binding.edtStationCount.text.toString())
        val averagePassengerCount = Integer.valueOf(binding.edtPassengerAverageCount.text.toString())
        val oilCost = Integer.valueOf(binding.edtOilCost.text.toString())

        val electricalBus = Electrical(distance, stationCount, averagePassengerCount, oilCost)
        val petrolBus = Petrol(distance, stationCount, averagePassengerCount, oilCost)
        val liquidGasBus = LiquidGas(distance, stationCount, averagePassengerCount, oilCost)

        vm.airPollutionVolumeArr.add(electricalBus.getTotalAirPollutionVolume())
        vm.airPollutionVolumeArr.add(petrolBus.getTotalAirPollutionVolume())
        vm.airPollutionVolumeArr.add(liquidGasBus.getTotalAirPollutionVolume())

        when (vm.getTheTypeOfCleanest()){
            BusTypes.ELECTRICAL -> {
                vm.cleanest.bus = electricalBus
                binding.txtCleanestWay.text = "Electrical"
            }
            BusTypes.PETROL -> {
                vm.cleanest.bus = petrolBus
                binding.txtCleanestWay.text = "Petrol"
            }
            BusTypes.LIQUID_GAS -> {
                vm.cleanest.bus = liquidGasBus
                binding.txtCleanestWay.text = "Liquid gas"
            }
        }

        binding.cleanest = vm.cleanest
    }


}
