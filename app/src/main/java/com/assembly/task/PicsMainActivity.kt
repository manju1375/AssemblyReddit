package com.assembly.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assembly.task.ui.main.fragment.PicsMainFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Developed by Manjunath on 19,June,2022
 */

@AndroidEntryPoint
class PicsMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PicsMainFragment.newInstance())
                .commitNow()
        }
    }
}