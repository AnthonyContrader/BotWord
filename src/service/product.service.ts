import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ProductDTO } from 'src/dto/productdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })

export class ProductService extends AbstractService<ProductDTO>{

    constructor(http: HttpClient) {
        super(http);
        this.type = 'product';
    }

    
}