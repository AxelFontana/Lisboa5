package com.example.lisboa5lastfm.lastfm.external.artist

import com.example.lisboa5lastfm.lastfm.external.Artist


interface ArtistExternalService {

    fun getArtistFromLastFMAPI(artistName: String): Artist.ArtistData?
}