# apichallenge
Repositorio para API del Challenge

Se uso para persistir la información con H2 in-memory database.

Los Servicios expuestos por el API pueden visualizarse con swagger

http://localhost:8080/swagger-ui.html#/


Flujo Funcional:
1. Almacenar los permisos 
2. Almacenar  PermisoAlbumCompartido



Los servicios del API son:
 
 /api/savePermiso
 Almacena un Permiso (tipo de permiso)
 
 
  /api/getAllPermisos
 Obtiene todos los Permisos registrados(tipos de permisos)
 
 /api/getPermisoById
 Obtiene un permiso por ID
 
 
 /api/getAlbumsByIdUser
 Obtieen los Albumes de un usuario especificando el ID.
 
 /api/getAllAlbums
 Obtiene la lista de todos Los Albums desde al API Externo.
 

 /api/getAllPhotos
  Obtiene la lista de todos Las Fotos desde al API Externo.
 
 /api/getAllPost
  Obtiene la lista de todos Los Posst desde al API Externo.
 
 
 /api/getAllUsers
   Obtiene la lista de todos Los Ususarios desde al API Externo.
 
 /api/getPhotosByIdUser
  Obtiene la lista de Las Fotos del Usuario especificado desde el API Externo.
 
 /api/getPostsByIdUser
  Obtiene la lista de todos Los Post del ID Usuario Especificado, desde al API Externo.
 
 /api/getPostsByNameUser
  Obtiene la lista de todos Los Posts del name Usuario especificado, desde al API Externo.
 
 
 /api/getUserById
  Obtiene el Usuario por ID desde el API Externo

 /api/getAllPermisosAlbumsCompartidos
  Obtiene todos los permisos a albumes compartidos 

 /api/getUsersByPermisoAlbum
 Obtiene Los Usuarios que tienen un Permiso especifico de un Album especifico.
 
 /api/savePermisoAlbumCompartido
 Almacena los Permiso a album compartido, especificando Id del Album, Id del User y los idPermiso separados por coma ,
 Por ejemplo idAlbum=1  idUser=2  idPermisos=1,2
 
 /api/updatePermisoAlbumCompartido
 Actualiza los permisos de un AlbumCompartido para un Usuario y album especifico.
  
