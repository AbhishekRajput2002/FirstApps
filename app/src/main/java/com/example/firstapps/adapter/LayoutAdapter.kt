package com.example.firstapps.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.firstapps.fragment.DemoFragment
import com.example.firstapps.fragment.SecondFragment
import com.example.firstapps.fragment.SettingFragment

class LayoutAdapter(
    var fragmentManager: FragmentManager,
    var tabCount : Int
) : FragmentPagerAdapter(fragmentManager)
{
    override fun getCount(): Int {
    return tabCount
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return DemoFragment()
            1 -> return SettingFragment()
            2 -> return SecondFragment()
            else -> return DemoFragment()
        }
    }
}