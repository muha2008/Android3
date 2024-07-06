package com.example.android3iesson1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android3iesson1.R
import com.example.android3iesson1.databinding.FragmentEditBinding
import com.example.android3iesson1.ui.viewmodel.SignModel

class EditFragment : Fragment() {

    private lateinit var viewModel: SignModel
    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SignModel::class.java)

        viewModel.user.observe(viewLifecycleOwner, Observer { user ->
            binding.tvName.setText(user.username)
            binding.tvAge.setText(user.age.toString())
            binding.tvEmail.setText(user.email)
            binding.tvPassword.setText(user.password)
        })

        binding.btnEditSign.setOnClickListener {
            val username = binding.tvName.text.toString()
            val age = binding.tvAge.text.toString().toInt()
            val email = binding.tvEmail.text.toString()
            val password = binding.tvPassword.text.toString()

            viewModel.updateUser(username, age, email, password)
            findNavController().navigate(R.id.action_editFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}