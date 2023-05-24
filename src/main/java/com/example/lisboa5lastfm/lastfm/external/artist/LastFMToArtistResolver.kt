package com.example.lisboa5lastfm.lastfm.external.artist


import com.example.lisboa5lastfm.lastfm.external.Artist
import com.google.gson.Gson
import com.google.gson.JsonObject


private const val ARTIST = "artist"
private const val ARTIST_NAME = "name"
private const val BIO = "bio"
private const val CONTENT = "content"
private const val URL = "url"

interface LastFMToArtistResolver {
    fun getArtistFromExternalData(serviceData: String?) : Artist.ArtistData?
}

internal class LastFMToArtistResolverImpl: LastFMToArtistResolver {

    override fun getArtistFromExternalData(serviceData: String?): Artist.ArtistData? =
        try {
            serviceData?.getArtistFromCallResponse()?.let { item ->
                Artist.ArtistData(
                    item.getArtistName(), item.getArtistBioContent(), item.getArtistUrl()
                )
            }
        } catch (e: Exception) {
            null
        }


    private fun String?.getArtistFromCallResponse(): JsonObject {
        val gsonObject = Gson()
        val jObjFromGson = gsonObject.fromJson(this, JsonObject::class.java)
        return jObjFromGson[ARTIST].asJsonObject
    }

    private fun JsonObject.getArtistName() = this[com.example.lisboa5lastfm.lastfm.external.artist.ARTIST_NAME].asString

    private fun JsonObject.getArtistBioContent() = this[com.example.lisboa5lastfm.lastfm.external.artist.BIO].asJsonObject[com.example.lisboa5lastfm.lastfm.external.artist.CONTENT].asString

    private fun JsonObject.getArtistUrl() = this[com.example.lisboa5lastfm.lastfm.external.artist.URL].asString


}