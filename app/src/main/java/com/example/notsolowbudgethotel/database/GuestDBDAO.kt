package com.example.notsolowbudgethotel.database

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GuestDBDAO{
    @Query("SELECT * FROM GUESTS")
    fun getAllCurrentGuests(): Cursor

    @Insert
    fun insertNewGuest(newGuest: GuestEntity)

    @Delete
    fun checkOutGuest(checkoutGuest: GuestEntity)

}