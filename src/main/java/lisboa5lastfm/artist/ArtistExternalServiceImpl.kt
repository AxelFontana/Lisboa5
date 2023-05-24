package lisboa5lastfm.artist

import lisboa5lastfm.Artist


internal class ArtistExternalServiceImpl (
    private val lastFMAPI: LastFMAPI,
    private val lastFMtoArtistResolver: LastFMToArtistResolver
        ): ArtistExternalService {

     override fun  getArtistFromLastFMAPI(artistName: String): Artist.ArtistData? {
        val callResponse = lastFMAPI.getArtistInfo(artistName).execute()
        return lastFMtoArtistResolver.getArtistFromExternalData(callResponse.body())
    }

}