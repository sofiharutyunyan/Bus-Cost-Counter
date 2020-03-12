package com.service.buscostcounter.view.fragment

import android.os.Bundle
import android.view.View
import com.service.buscostcounter.R
import com.service.buscostcounter.databinding.FragmentMainBinding
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

    }

    private fun countFavorable() {
        val distance: Int = Integer.valueOf(binding.edtDistance.text.toString())
        val stationCount: Int = Integer.valueOf(binding.edtStationCount.text.toString())

        val electricalBus = Electrical(distance, stationCount)
        val petrolBus = Petrol(distance, stationCount)
        val liquidGasBus = LiquidGas(distance, stationCount)

        var elCost = electricalBus.getTotalFuelCost()
        var petCost = petrolBus.getTotalFuelCost()
        var liqCost = liquidGasBus.getTotalFuelCost()

        vm.fuelCostArr.add(elCost);
        vm.fuelCostArr.add(petCost);
        vm.fuelCostArr.add(liqCost);

        vm.favorable.fuelCost = vm.getTheFavourableWay()!!
        binding.favourable = vm.favorable
        binding.busTypes = vm.getTheTypeOfFavourable()
    }

    private fun countCleanest() {

    }

}
