package lisboa5lastfm.artist

import lisboa5lastfm.Artist


interface ArtistExternalService {

    fun getArtistFromLastFMAPI(artistName: String): Artist.ArtistData?
}