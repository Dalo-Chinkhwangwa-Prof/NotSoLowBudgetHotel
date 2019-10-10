package com.example.notsolowbudgethotel.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guests")
data class GuestEntity(
    @PrimaryKey(autoGenerate = true) var guestID: Int?,
    @ColumnInfo(name = "GuestName") var guestName: String,
    @ColumnInfo(name = "RoomNumber") var roomNumber: String,
    @ColumnInfo(name = "LengthOfStay") var lengthOfStay: String
) {
    constructor(
        guestName: String,
        roomNumber: String,
        lengthOfStay: String
    ) : this(null, guestName, roomNumber, lengthOfStay)
}