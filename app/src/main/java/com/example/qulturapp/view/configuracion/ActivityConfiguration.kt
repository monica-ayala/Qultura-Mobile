package com.example.qulturapp.view.configuracion

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import com.example.qulturapp.R
import com.example.qulturapp.databinding.ActivityConfigurationBinding

class ActivityConfiguration : AppCompatActivity() {
    private lateinit var binding: ActivityConfigurationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration)

        // Dark Mode Function
        var dm_switch = binding.darkmodeSwitch
        val appSettingPrefs : SharedPreferences = getSharedPreferences("AppSettingsPrefs", 0)
        val sharedPrefEdit : SharedPreferences.Editor = appSettingPrefs.edit()
        val isNightModeOn : Boolean = appSettingPrefs.getBoolean("NightMode", false)

        if(isNightModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        dm_switch.setOnCheckedChangeListener { _, isChecked ->
            if(isNightModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPrefEdit.putBoolean("NightMode", false)
                sharedPrefEdit.apply()
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPrefEdit.putBoolean("NightMode", true)
                sharedPrefEdit.apply()
            }
        }

        binding.profileAccessButton.setOnClickListener() {
            Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show()
        }
    }
}