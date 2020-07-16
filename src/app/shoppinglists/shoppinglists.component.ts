import { Component, OnInit } from '@angular/core';
import { ShoppingListService } from 'src/service/shoppinglist.service';
import { ShoppingListDTO } from 'src/dto/shoppinglistdto';

@Component({
  selector: 'app-shoppinglists',
  templateUrl: './shoppinglists.component.html',
  styleUrls: ['./shoppinglists.component.css']
})
export class ShoppingListsComponent implements OnInit {

  shoppinglists: ShoppingListDTO[];
  shoppinglisttoinsert: ShoppingListDTO = new ShoppingListDTO();



  constructor(private service: ShoppingListService) { }

  ngOnInit() {
    this.getShoppingLists();
  }

  getShoppingLists(){
    this.service.getAll().subscribe(shoppinglists => this.shoppinglists = shoppinglists);
  }

  delete(shoppinglist: ShoppingListDTO){
    this.service.delete(shoppinglist.id).subscribe( () => this.getShoppingLists());
  }

  update(shoppinglist: ShoppingListDTO){
    this.service.update(shoppinglist).subscribe( () => this.getShoppingLists());
  }

  insert(shoppinglist: ShoppingListDTO){
    this.service.insert(shoppinglist).subscribe( () => this.getShoppingLists());
  }

  clear(){
    this.shoppinglisttoinsert = new ShoppingListDTO();
  }

}
