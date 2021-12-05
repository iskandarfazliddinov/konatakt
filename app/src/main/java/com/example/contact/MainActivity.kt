package com.example.contact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contact.Adapters.UserAdapter
import com.example.contact.Data.UserData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val data = ArrayList<UserData>()
    private lateinit var adapter : UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Contact"
            subtitle = "friends"

            setDisplayShowHomeEnabled(true)
            setDisplayUseLogoEnabled(true)
        }



        val listUser = listOf<String>(
            "Iluz",
            "Can",
            "Jons",
            "Sart",
            "Jeno",
            "Jama",
            "Iluz",
            "Can",
            "Jons",
            "Sart",
            "Jeno",
            "Jama"
        )
        val listImage = listOf<Int>(
            R.drawable.person5,
            R.drawable.person2,
            R.drawable.person3,
            R.drawable.person4,
            R.drawable.person,
            R.drawable.person,
            R.drawable.person5,
            R.drawable.person2,
            R.drawable.person3,
            R.drawable.person4,
            R.drawable.person,
            R.drawable.person

        )
        val listPhoneNumber = listOf<String>(
            "+99893 226 30 66",
            "+99890 285 72 76",
            "+99890 505 15 55",
            "+99894 455 15 55",
            "+99898 888 15 55",
            "+98999 915 96 99",
            "+99893 226 30 66",
            "+99890 285 72 76",
            "+99890 505 15 55",
            "+99894 455 15 55",
            "+99898 888 15 55",
            "+98999 915 96 99"
        )
        (0..listUser.size-1).forEach{i->
            data.add(UserData(listImage[i],listUser[i],listPhoneNumber[i]))

        }
        val recyclerView: RecyclerView = findViewById(R.id.RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = UserAdapter(data)
        recyclerView.adapter = adapter

        adapter.setOnclilcListener {postion,imageId,name,phoneNumber->

            val intent = Intent(this,UserActivity::class.java)
            intent.putExtra("ImageId",imageId)
            intent.putExtra("Name",name)
            intent.putExtra("PhoneNumber",phoneNumber)
            startActivity(intent)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.chiqish->{
                Toast.makeText(this,"CHiqish",Toast.LENGTH_SHORT).show()
                System.exit(-1)
            }
            R.id.qidiruv->{
                Toast.makeText(this,"qidiruv",Toast.LENGTH_SHORT).show()
            }
            R.id.Nusxalash->{
                Toast.makeText(this,"Nusxalash",Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}