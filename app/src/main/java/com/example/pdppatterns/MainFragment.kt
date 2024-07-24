package com.example.pdppatterns

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pdppatterns.base.BaseFragment
import com.example.pdppatterns.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFlyweight.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_flyweightFragment)
        }

        binding.buttonTodoList.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_todoListFragment)
        }
    }
}
