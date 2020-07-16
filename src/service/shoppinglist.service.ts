import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ProductDTO } from 'src/dto/shoppinglistdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })

export class ShoppingistService extends AbstractService<ShoppingListDTO>{

    constructor(http: HttpClient) {
        super(http);
        this.type = 'shoppinglist';
    }


}
