import { Component, OnInit } from '@angular/core';

import { Service } from 'src/core/services/service.service';
import { Empresa } from 'src/core/models/Empresa';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  public empresas: Empresa[];

  public listaDeColunas: any = [
    {
      titulo: 'Name'
    },
    {
      titulo: 'Pontuação',
      sortOrder: 'descend',
      compare: (a: Empresa, b: Empresa) => a.pontuacao - b.pontuacao,
    }
  ];

  constructor(private listarService: Service) { }

  ngOnInit(): void {
    this.listarService.getEmpresas()
      .subscribe(data => {
        this.empresas = data;
      });
  }

}
