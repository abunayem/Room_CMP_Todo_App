package com.abunayem.roomcmp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */

@Entity
data class TodoItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
)