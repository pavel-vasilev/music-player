package com.pvasilev.music.data.mappers

import android.database.Cursor

class CursorToListMapper<E>(private val itemMapper: Mapper<Cursor, E>) : Mapper<Cursor, List<E>> {
    override fun map(cursor: Cursor): List<E> {
        cursor.moveToFirst()
        val items = mutableListOf<E>()
        while (!cursor.isAfterLast) {
            items += itemMapper.map(cursor)
            cursor.moveToNext()
        }
        return items
    }
}