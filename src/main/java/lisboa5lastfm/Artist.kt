package lisboa5lastfm

sealed class Artist {
    val DEFAULT_IMAGE =
        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Lastfm_logo.svg/320px-Lastfm_logo.svg.png"
    data class ArtistData(
        val artistName: String,
        val artistBioContent: String,
        val artistURL: String,
        var isLocallyStored: Boolean = false
    ) : Artist()
    object EmptyArtist : Artist()
}