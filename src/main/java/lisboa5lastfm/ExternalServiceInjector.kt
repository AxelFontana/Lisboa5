package lisboa5lastfm

import lisboa5lastfm.artist.*
import lisboa5lastfm.artist.ArtistExternalServiceImpl
import lisboa5lastfm.artist.LastFMToArtistResolverImpl
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object ExternalServiceInjector {

    private const val RETROFIT_URL = "https://ws.audioscrobbler.com/2.0/"
    private val retrofit = createRetrofit()
    private val lastFMAPI = retrofit.create(LastFMAPI::class.java)
    private val lastFMtoArtistResolver: LastFMToArtistResolver =
        LastFMToArtistResolverImpl()

    private val artistExternalService: ArtistExternalService =
        ArtistExternalServiceImpl(
            lastFMAPI,
            lastFMtoArtistResolver
        )

    fun getLastFMService(): ArtistExternalService {
        return artistExternalService
    }


    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RETROFIT_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }
}