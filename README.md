# Lisboa5

En la clase Artist la propiedad DEFAULT_IMAGE es un link al logo de LastFM

-ArtistExternalServiceImpl utiliza a LastFMtoArtistResolver para dado un string(artistName), 
retornar un ArtistData si se encuentra informacion del artista en el servicio externo, y en caso de no encontrar nada retorna null.
-ExternalServiceInjector se utiliza para inicializar el ArtistExternalService, mediante la funcion getLastFMService.

Pasos para usar el submodulo:
1) importar ExternalServiceInjector y ArtistExternalService

import lisboa5lastfm.ExternalServiceInjector
import lisboa5lastfm.artist.ArtistExternalService

2) Inicializar artistExternalService con la funcion getLastFMService() del injector

 val artistExternalService : ArtistExternalService = ExternalServiceInjector.getLastFMService()

3) Mediante artistExternalService se puede llamar al metodo getArtistFromLastFMAPI(artistName: String), que devolvera un
ArtistData en caso de encontrar informacion de un artista dado el nombre del artista, y nulo en caso de no encontrar nada

var artist: Artist?
artist = artistExternalService.getArtistFromLastFMAPI(artistName)