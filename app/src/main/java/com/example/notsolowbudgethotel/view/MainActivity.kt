package com.example.notsolowbudgethotel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import androidx.core.content.ContextCompat
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notsolowbudgethotel.R
import com.example.notsolowbudgethotel.database.GuestDBDAO
import com.example.notsolowbudgethotel.database.GuestDatabase
import com.example.notsolowbudgethotel.database.GuestEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var guestDAO: GuestDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
    }


    override fun onResume() {
        super.onResume()
        lockOut()
    }

    private fun lockOut() {
        val frag = LoginFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.my_fragment_holder, frag)
            .addToBackStack(frag.tag)
            .commit()
    }

    override fun onBackPressed() {
//        super.onBackPressed()
//        Do nothing
    }
    private fun setupViews() {
        guestDAO = Room.databaseBuilder(
            this,
            GuestDatabase::class.java,
            "guests.db"
        ).allowMainThreadQueries()
            .build()

        check_in_button.setOnClickListener { _ ->
            val newGuest = createGuest()
            guestDAO.guestDBDAO().insertNewGuest(newGuest)
        }

    }

    private fun createGuest():GuestEntity{
        return GuestEntity(
            guest_name_edittext.text.toString(),
            room_number_edittext.text.toString(),
            duration_edittext.text.toString().toDays()
        )
    }

    private fun String.toDays(): String{
        return "$this Days"
    }
}
