package com.service.buscostcounter.view.activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.service.buscostcounter.R
import com.service.buscostcounter.databinding.ActivityMainBinding
import com.service.buscostcounter.view.activity.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var navController: NavController? = null

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }
}
