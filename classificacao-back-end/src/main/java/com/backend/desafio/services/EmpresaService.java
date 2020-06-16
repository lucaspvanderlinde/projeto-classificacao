package com.backend.desafio.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backend.desafio.model.Empresa;
import com.backend.desafio.repositories.EmpresaRepositorio;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepositorio eRepositorio;

	public List<Empresa> listar() {
		return eRepositorio.findAll();
	}
	
	public Optional<Empresa> procurarPorId(Integer id) {
		Optional<Empresa> obj = eRepositorio.findById(id);
		return obj;
	}

	public Empresa calcularESalvar(MultipartFile json, int id) throws Throwable {
		Empresa empresa = calcularPontuacao(json, id);
		return eRepositorio.save(empresa);
	}

	public Empresa calcularPontuacao(MultipartFile json, int id) throws Throwable {

		Map<String, Integer> map = null;

		String content = new String(json.getBytes(), StandardCharsets.UTF_8);
		map = new ObjectMapper().readValue(content, Map.class);
		
		double notas = (double) map.get("notas");
		double debitos = (double) map.get("debitos");
		double pontuacao = 0;

		Optional<Empresa> recebeEmpresa = eRepositorio.findById(id);

		if (recebeEmpresa.isPresent()) {
			pontuacao = recebeEmpresa.get().getPontuacao();
			System.out.println(pontuacao);
		} else {
			pontuacao = 0;
		}

		for (int i = 0; i < notas; i++) {
			pontuacao += Math.floor(pontuacao * 0.02);
		}

		for (int i = 0; i < debitos; i++) {
			pontuacao -= Math.ceil(pontuacao * 0.04);
			pontuacao = Math.ceil(pontuacao);
		}

		if (pontuacao < 1) {
			pontuacao = 1.00;
		} else if (pontuacao > 100) {
			pontuacao = 100.00;
		}

		Empresa empresa = new Empresa();
		empresa.setId(recebeEmpresa.get().getId());
		empresa.setNome(recebeEmpresa.get().getNome());
		empresa.setPontuacao(pontuacao);

		return empresa;
	}
}
