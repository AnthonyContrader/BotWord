import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/service/product.service';
import { ProductDTO } from 'src/dto/productdto';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-category',
  templateUrl: './product-category.component.html',
  styleUrls: ['./product-category.component.css']
})
export class ProductCategoryComponent implements OnInit {

  private productList: ProductDTO[];

  private productCategory: string;

  constructor(private route:ActivatedRoute, private service: ProductService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.productCategory=params['category'];
    });

    this.findByCategory();

    //console.log(this.productList);

  }

  findByCategory(){
    this.service.findByCategory(this.productCategory).subscribe(products => {this.productList = products, console.log(products)});
  }

}
