package com.pvasilev.music.data.mappers

interface Mapper<F, T> {
    fun map(from: F): T
}