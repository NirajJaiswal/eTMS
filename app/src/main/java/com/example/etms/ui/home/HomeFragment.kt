package com.example.etms.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.etms.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setStartDate()
        setEndDate()
        return binding.root
    }

    fun setStartDate() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.DAY_OF_MONTH, 1)
        val sdf = SimpleDateFormat("d MMM, yyyy", Locale.getDefault())
         binding.startDateValueTv.text = sdf.format(cal.time)
    }

    fun setEndDate() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH))
        val sdf = SimpleDateFormat("d MMM, yyyy", Locale.getDefault())
        binding.endDateValueTv.text = sdf.format(cal.time)
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}