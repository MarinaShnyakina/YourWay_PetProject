package com.example.data.mappers

import com.example.data.api.BooksApiResponse
import com.example.domain.entities.Volume
import com.example.domain.entities.VolumeInfo

class BookApiResponseMapper {
    fun toVolumeList(response: BooksApiResponse): List<Volume> {
        return response.items.map {
            Volume(
                it.id, VolumeInfo(
                    it.volumeInfo.title,
                    it.volumeInfo.authors,
                    it.volumeInfo.imageLinks?.thumbnail?.replace("http", "https"))
            )
        }
    }
}