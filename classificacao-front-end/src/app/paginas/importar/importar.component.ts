import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Service } from 'src/core/services/service.service';
import { MensagemService } from 'src/core/services/mensagem.service';
import { Empresa } from 'src/core/models/Empresa';

@Component({
  selector: 'app-importar',
  templateUrl: './importar.component.html',
  styleUrls: ['./importar.component.css']
})
export class ImportarComponent implements OnInit {

  constructor(private router: Router, private service: Service, private msg: MensagemService, private listarService: Service) { }

  resultado: File;
  empresas: Empresa[];
  empresaSelecionada: Empresa;

  ngOnInit(): void {
    this.listarService.getEmpresas()
      .subscribe(data => {
        this.empresaSelecionada = data[0];
        this.empresas = data;
      });
  }

  public uploadFile(event) {
    const arquivoSelecionado = event.target.files;
    this.resultado = arquivoSelecionado[0];
  }

  public importar() {
    this.service.postJson(this.resultado, this.empresaSelecionada.id)
      .subscribe(data => {
        this.router.navigate(['listar']);
        this.msg.successMessage('Arquivo importado com sucesso!!!');
      });
  }
}
