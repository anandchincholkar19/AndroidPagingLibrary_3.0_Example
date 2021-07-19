package com.example.androidpaginglibrary_30_example.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpaginglibrary_30_example.R
import com.example.androidpaginglibrary_30_example.network.data.repository.RetrofitInstance
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.passanger_fragment.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class PassangerFragment : Fragment(R.layout.passanger_fragment){

    private val passangerViewModel : PassangerViewModel by viewModels()

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var adapter: PassangerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyler_view.layoutManager = LinearLayoutManager(requireContext())
        recyler_view.setHasFixedSize(true)

        recyler_view.adapter = adapter
        recyler_view.adapter = adapter.withLoadStateHeaderAndFooter(
            header = PassangerLoadStateAdapter {
                adapter.retry()
            },
            footer = PassangerLoadStateAdapter{
                adapter.retry()
            }
        )
        lifecycleScope.launch {
            passangerViewModel.passangers.collect{
                adapter.submitData(it)
            }
        }
    }
}
