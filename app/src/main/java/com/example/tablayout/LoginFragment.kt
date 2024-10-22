package com.example.tablayout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tablayout.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private val binding by lazy {
        FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val email = binding.editEmail.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Masih terdapat data yang belum diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sharedPref = requireActivity().getSharedPreferences("user_data", Context.MODE_PRIVATE)
            val Email = sharedPref.getString("email", "")
            val Password = sharedPref.getString("password", "")
            val Name = sharedPref.getString("name", "")
            val Nim = sharedPref.getString("nim", "")

            if (email == Email && password == Password) {
                Toast.makeText(context, "Login berhasil", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, DashboardActivity::class.java)
                intent.putExtra("name", Name)
                intent.putExtra("nim", Nim)
                startActivity(intent)
            } else {
                Toast.makeText(context, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }

        }

    }
}