package com.challengue.controller;

import java.util.ArrayList;

import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/api")
public class APIFotosController {

	private final String URI_PHOTOS = "/photos";
	private final String URI_ALBUMS = "/albums";
	private final static String URI_USERS = "/users";
	private final String URI_COMENTARIOS = "/posts";

	static RestTemplate restTemplate = new RestTemplate();
	public static final String uriServicioExterno = "https://jsonplaceholder.typicode.com";

	@RequestMapping(value = "/getPhotosByIdUser", method = RequestMethod.GET, params = { "id" })
	public List<ArrayList<LinkedHashMap>> getPhotosByIdUser(@RequestParam(value = "id") Long id) {
		List<ArrayList<LinkedHashMap>> photos = new ArrayList<ArrayList<LinkedHashMap>>();
		List<LinkedHashMap> albumsList = getAlbumsByIdUser(id);

		for (LinkedHashMap album : albumsList) {
			String idAlbum = String.valueOf(album.get("id"));

			photos.add((ArrayList<LinkedHashMap>) restTemplate
					.getForObject(uriServicioExterno + URI_PHOTOS + "?albumId=" + idAlbum, List.class));

		}

		return photos;
	}

	@RequestMapping(value = "/getPostsByNameUser", method = RequestMethod.GET, params = { "name" })
	public List<LinkedHashMap> getPostsByNameUser(@RequestParam(value = "name") String name) {

		List<LinkedHashMap> user = restTemplate.getForObject(uriServicioExterno + URI_USERS + "?name=" + name,
				List.class);

		if (user.size() > 0) {
			Long idUser = Long.parseLong(String.valueOf(user.get(0).get("id")));
			List<LinkedHashMap> posts = restTemplate
					.getForObject(uriServicioExterno + URI_COMENTARIOS + "?userId=" + idUser, List.class);
			return posts;
		}

		return null;

	}

	@RequestMapping(value = "/getPostsByIdUser", method = RequestMethod.GET, params = { "id" })
	public List<LinkedHashMap> getPostsByIdUser(@RequestParam(value = "id") Long id) {

		List<LinkedHashMap> posts = restTemplate.getForObject(uriServicioExterno + URI_COMENTARIOS + "?userId=" + id,
				List.class);

		return posts;
	}

	@RequestMapping(value = "/getAlbumsByIdUser", method = RequestMethod.GET, params = { "id" })
	public List<LinkedHashMap> getAlbumsByIdUser(@RequestParam(value = "id") Long id) {

		List<LinkedHashMap> albumes = restTemplate.getForObject(uriServicioExterno + URI_ALBUMS + "?userId=" + id,
				List.class);

		return albumes;
	}

	@RequestMapping(value = "/getAllAlbums", method = RequestMethod.GET)
	public List<LinkedHashMap> getAllAlbums() {
		List<LinkedHashMap> albumes = restTemplate.getForObject(uriServicioExterno + URI_ALBUMS, ArrayList.class);

		return albumes;
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<LinkedHashMap> getAllUsers() {
		List<LinkedHashMap> users = restTemplate.getForObject(uriServicioExterno + URI_USERS, ArrayList.class);

		return users;
	}

	@RequestMapping(value = "/getAllPhotos", method = RequestMethod.GET)
	public List<LinkedHashMap> getAllPhotos() {
		List<LinkedHashMap> photos = restTemplate.getForObject(uriServicioExterno + URI_PHOTOS, ArrayList.class);

		return photos;
	}

	@RequestMapping(value = "/getAllPost", method = RequestMethod.GET)
	public List<LinkedHashMap> getAllPost() {
		List<LinkedHashMap> photos = restTemplate.getForObject(uriServicioExterno + URI_COMENTARIOS, ArrayList.class);

		return photos;
	}

	@RequestMapping(value = "/getUserById", method = RequestMethod.GET, params = { "idUser" })
	public static LinkedHashMap getUserById(@RequestParam(value = "idUser") Long idUser) {
		LinkedHashMap users = restTemplate.getForObject(uriServicioExterno + URI_USERS +"/" + idUser,
				LinkedHashMap.class);
		return users;
	}
}
