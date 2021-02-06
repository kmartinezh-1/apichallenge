package com.challengue;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.challengue.entity.Permiso;
import com.challengue.repository.PermisoRepository;

@SpringBootTest
public class PermisoRepositoryTest {

	@Autowired
	private PermisoRepository repository;

	@Test
	public void save_permiso() {

		Permiso p = new Permiso("ESCRITURA");
		Permiso pr = repository.save(p);

		assertThat(p).isEqualTo(pr);
	}

	@Test
	public void find_all_permisos() {

		Permiso p = new Permiso("ESCRITURA");
		Permiso pr = repository.save(p);

		Permiso p2 = new Permiso("LECTURA");
		Permiso pr2 = repository.save(p2);

		Iterable<Permiso> permisos = repository.findAll();

		int numPermisos = 2;
		assertThat(permisos).hasSize(numPermisos);
	}

}
