package com.example.notsolowbudgethotel.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GuestEntity::class], version = 1)
abstract class GuestDatabase: RoomDatabase(){
    abstract fun guestDBDAO():  GuestDBDAO
}