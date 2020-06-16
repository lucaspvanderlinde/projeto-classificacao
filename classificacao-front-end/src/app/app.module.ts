import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzUploadModule } from 'ng-zorro-antd/upload';
import { NzMessageModule } from 'ng-zorro-antd/message';
import { NzNoAnimationModule } from 'ng-zorro-antd/core/no-animation';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgZorroAntdModule } from 'ng-zorro-antd';
import { CommonModule } from '@angular/common';
import { NzInputNumberModule } from 'ng-zorro-antd/input-number';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarComponent } from './paginas/listar/listar.component';
import { ImportarComponent } from './paginas/importar/importar.component';
import { Service } from 'src/core/services/service.service';

@NgModule({
  declarations: [
    AppComponent,
    ListarComponent,
    ImportarComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NzButtonModule,
    NzTableModule,
    NzUploadModule,
    NzMessageModule,
    NzNoAnimationModule,
    BrowserAnimationsModule,
    NgZorroAntdModule,
    ReactiveFormsModule,
    NzInputNumberModule
  ],
  providers: [
    Service
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
