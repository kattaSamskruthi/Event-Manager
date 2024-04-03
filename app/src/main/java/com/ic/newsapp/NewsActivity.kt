import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ic.newsapp.Adapter.NewsAdapter
import com.ic.newsapp.R
import com.ic.newsapp.databinding.ActivityMainBinding
import com.ic.newsapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var mainViewModel : MainViewModel
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        adapter = NewsAdapter()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initBinding()
        initObservers()
        initListener()
    }

    private fun initBinding(){
        binding.lifecycleOwner = this
        binding.recyclerView.adapter = adapter
    }

    private fun initObservers(){
        mainViewModel.newsListLive.observe(this){  list->
            adapter.setData(list)
        }
    }
    private fun initListener(){
        binding.searchButton.setOnClickListener(View.OnClickListener {
            mainViewModel.getUserSearchNews(binding.searchField.text.toString())
        })
    }
}

