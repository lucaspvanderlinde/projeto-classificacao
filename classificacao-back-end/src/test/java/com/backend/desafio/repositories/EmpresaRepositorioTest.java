package com.backend.desafio.repositories;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.backend.desafio.model.Empresa;
import com.backend.desafio.repositories.EmpresaRepositorio;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmpresaRepositorioTest {

	@Autowired
	private EmpresaRepositorio eRepositorio;
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void persistirDados() {	
		Empresa empresa = new Empresa();
		empresa.setNome("Empresa");
		empresa.setPontuacao(10.0);
		this.eRepositorio.save(empresa);
		Assertions.assertThat(empresa.getId()).isNotNull();
		Assertions.assertThat(empresa.getNome()).isEqualTo("Empresa");
		Assertions.assertThat(empresa.getPontuacao()).isEqualTo(10.0);	
	}
	
	@Test
	public void deletarDados() {
		Empresa empresa = new Empresa();
		empresa.setNome("Empresa");
		empresa.setPontuacao(10.0);
		this.eRepositorio.save(empresa);
		eRepositorio.delete(empresa);
		Assertions.assertThat(eRepositorio.findById(empresa.getId()));
	}
	
	@Test
	public void atualizarDados() {
		Empresa empresa = new Empresa();
		empresa.setNome("Empresa");
		empresa.setPontuacao(10.0);
		this.eRepositorio.save(empresa);
		empresa = this.eRepositorio.save(empresa);
		Assertions.assertThat(empresa.getNome()).isEqualTo("Empresa");
		Assertions.assertThat(empresa.getPontuacao()).isEqualTo(10.0);
	}
	
	@Test
	public void verificarEmpresaPeloNome() {
		Empresa empresa1 = new Empresa();
		Empresa empresa2 = new Empresa();
		empresa1.setNome("Empresa");
		empresa1.setPontuacao(10.0);

		empresa2.setNome("Empresa");
		empresa2.setPontuacao(10.0);
		this.eRepositorio.save(empresa1);
		this.eRepositorio.save(empresa2);
		List<Empresa> empresaList = eRepositorio.findAll();
		Assertions.assertThat(empresaList.size()).isEqualTo(2);
	}
}
