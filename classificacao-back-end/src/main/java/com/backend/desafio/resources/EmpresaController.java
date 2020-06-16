package com.backend.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.desafio.model.Empresa;
import com.backend.desafio.services.EmpresaService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	private EmpresaService eService;

	@GetMapping
	public List<Empresa> listar() {
		return eService.listar();
	}

	@PostMapping(value = "/{id}")
	public ResponseEntity<?> importarEmpresa(@PathVariable int id, @RequestParam MultipartFile json) {

		return ResponseEntity.ok().body(eService.calcularESalvar(json, id));

	}
}
