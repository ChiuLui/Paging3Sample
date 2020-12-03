package com.chiului.paging3sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: ManiViewModel by viewModels()
        val pagingAdapter = MainAdapter()
        recycler.adapter = pagingAdapter

        lifecycleScope.launch {
            viewModel.getMainPagingData().collectLatest { pagingData ->
                pagingAdapter.submitData(pagingData)
            }
        }

    }
}