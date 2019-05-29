import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsersDTO } from '../models/UsersDTO';
import { PersonaDTO } from '../models/PersonaDTO';
import { UsersDTOservices } from '../services/usersDTO.service';
import {CatalinaResponseDTO}from '../models/CatalinaResponseDTO';
@Component({
    selector: 'pagos',
    templateUrl: './pagos.component.html',
    styleUrls: ['./pagos.component.sass'],
    providers: [UsersDTOservices]

})
export class PagosComponent implements OnInit {
    ngOnInit() {
    }
}