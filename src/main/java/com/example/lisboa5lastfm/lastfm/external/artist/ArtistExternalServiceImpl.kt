package com.example.lisboa5lastfm.lastfm.external.artist

import com.example.lisboa5lastfm.lastfm.external.Artist


internal class ArtistExternalServiceImpl (
    private val lastFMAPI: LastFMAPI,
    private val lastFMtoArtistResolver: LastFMToArtistResolver
        ): ArtistExternalService {

     override fun  getArtistFromLastFMAPI(artistName: String): Artist.ArtistData? {
        val callResponse = lastFMAPI.getArtistInfo(artistName).execute()
        return lastFMtoArtistResolver.getArtistFromExternalData(callResponse.body())
    }

}