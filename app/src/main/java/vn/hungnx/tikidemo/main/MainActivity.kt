package vn.hungnx.tikidemo.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import vn.hungnx.tikidemo.R
import vn.hungnx.tikidemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mBinding:ActivityMainBinding
    private val mainViewModel:MainViewModel by viewModel()
    lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mBinding.viewmodel = mainViewModel
        mBinding.lifecycleOwner = this
        setupRecyclerView()
        mainViewModel.start()
    }

    private fun setupRecyclerView(){
        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mainAdapter = MainAdapter(listOf())
        mBinding.recyclerView.adapter = mainAdapter

        mainViewModel.items.observe(this, Observer {
            mainAdapter.updateData(it)
        })
    }
}