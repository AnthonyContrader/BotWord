import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/service/product.service';
import { ProductDTO } from 'src/dto/productdto';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  productRead = new ProductDTO;

  private product_id: number;

  constructor(private route:ActivatedRoute, private service: ProductService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.product_id=params['id'];
    });

    this.read();

  }

  read(){
    this.service.read(this.product_id).subscribe(prod => this.productRead = prod );
  }

}
