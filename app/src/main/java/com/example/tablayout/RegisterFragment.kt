package com.example.tablayout

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.tablayout.databinding.FragmentRegisterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {

    private val binding by lazy {
        FragmentRegisterBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val name = binding.editNama.text.toString().trim()
            val email = binding.editEmail.text.toString().trim()
            val nim = binding.editNim.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()


            if (name.isEmpty() || email.isEmpty() || nim.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Masih terdapat data yang belum diisi", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
            }


            val sharedPref = requireActivity().getSharedPreferences("user_data", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("name", name)
            editor.putString("email", email)
            editor.putString("nim", nim)
            editor.putString("password", password)
            editor.apply()

            val viewPager = requireActivity().findViewById<ViewPager2>(R.id.view_pager)
            viewPager.currentItem = 0
        }
    }
}