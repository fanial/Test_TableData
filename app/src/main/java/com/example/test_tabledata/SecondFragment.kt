package com.example.test_tabledata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.test_tabledata.adapter.MenuAdapter
import com.example.test_tabledata.data.MenuDataClass
import com.example.test_tabledata.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var menuList: List<MenuDataClass>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menuList = ArrayList<MenuDataClass>()
        menuList = menuList + MenuDataClass("Lucky Draw", R.drawable.lucky_draw)
        menuList = menuList + MenuDataClass("Book Test Drive", R.drawable.book_test_drive)
        menuList = menuList + MenuDataClass("Book Service", R.drawable.book_service)
        menuList = menuList + MenuDataClass("THS", R.drawable.ths)
        menuList = menuList + MenuDataClass("Catalog", R.drawable.catalog)
        menuList = menuList + MenuDataClass("Calculator", R.drawable.calculator)
        menuList = menuList + MenuDataClass("Claim Insurance", R.drawable.claim_insurance)
        menuList = menuList + MenuDataClass("Service Berkala", R.drawable.service_berkala)
        menuList = menuList + MenuDataClass("Tips & Trick", R.drawable.tips_and_trick)
        menuList = menuList + MenuDataClass("Trade in", R.drawable.trade_in)
        menuList = menuList + MenuDataClass("Dealer Location", R.drawable.dealer_location)

        val menuAdapter = MenuAdapter(menuList, requireContext())
        binding.gridView.adapter = menuAdapter
        binding.gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(requireContext(), menuList[position].name + " selected", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}