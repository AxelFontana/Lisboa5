# Lisboa5

El submodulo contiene:
-Artist, es una data class, para guardar informacion del artista
-ArtistExternalServiceImpl utiliza a LastFMtoArtistResolver para dado un string(artistName), 
retornar un ArtistData si se encuentra informacion del artista en el servicio externo, y en caso de no encontrar nada retorna null.
-ExternalServiceInjector se utiliza para inicializar el ArtistExternalService, mediante la funcion getLastFMService.


