package com.uts.hoopsnews

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import android.view.View
import android.content.Intent
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.uts.hoopsnews.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)



        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.titleBar.text = getString(R.string.app_name)
        binding.logoutBtn.setOnClickListener {
            logoutUser()
        }

        val listView: ListView = findViewById(R.id.newsListView)

        val newsList = listOf(
            NewsItem("Semifinal wilayah barat", R.drawable.news1),
            NewsItem("Heat bisa mengguncang Nba jika Zion Williamson dan Cj McCollum", R.drawable.news2),
            NewsItem("Kevin Durant Claims He Never Wanted The NBA Spotlight", R.drawable.news3),
            NewsItem("Gregg Popovich: the NBA truth teller who held Trump, and the US, to account", R.drawable.news4)
        )

        val adapter = NewsAdapter(this, newsList)
        listView.adapter = adapter
    }

    private fun logoutUser() {
        firebaseAuth.signOut()
        Toast.makeText(this, "Sukses Logout", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser == null) {
            // Jika user belum login, arahkan ke LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        }
}
