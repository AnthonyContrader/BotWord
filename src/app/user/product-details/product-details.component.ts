import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/service/product.service';
import { ProductDTO } from 'src/dto/productdto';
import { ActivatedRoute } from '@angular/router';
import { ShoppingListDTO } from 'src/dto/shoppinglistdto';
import { ShoppingListService } from 'src/service/shoppinglist.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  productRead = new ProductDTO;

  private product_id: number;

  private quantity: number = 1;

  private shoppingList = new ShoppingListDTO;

  constructor(private route:ActivatedRoute, private service: ProductService,
             private slService: ShoppingListService, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.product_id=params['id'];
    });

    this.read();

  }

  read(){
    this.service.read(this.product_id).subscribe(prod => this.productRead = prod );
  }

  addToShoppingList(product: ProductDTO){
    this.shoppingList.productId = product.id;
    this.shoppingList.quantity = this.quantity;
    this.shoppingList.totalPrice = product.price * this.quantity;
    this.shoppingList.userId = JSON.parse(localStorage.getItem("currentUser")).id;

    this.slService.insert(this.shoppingList).subscribe();
    alert("Prodotto aggiunto correttamente all'ordine");
    this.slService.getAll().subscribe(listShop => this.router.navigate(['/user-dashboard/shoppinglist-details',
     listShop[listShop.length - 1 ].id ]));
   
  }

}
