import { Component, OnInit } from '@angular/core';
import { ShoppingListService } from 'src/service/shoppinglist.service';
import { ShoppingListDTO } from 'src/dto/shoppinglistdto';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-shoppinglist-details',
  templateUrl: './shoppinglist-details.component.html',
  styleUrls: ['./shoppinglist-details.component.css']
})
export class ShoppingListDetailsComponent implements OnInit {

  shoppinglistRead = new ShoppingListDTO;

  private shoppinglist_id: number;

  constructor(private route:ActivatedRoute, private service: ShoppingListService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.shoppinglist_id=params['id'];
    });

    this.read();

  }

  read(){
    this.service.read(this.shoppinglist_id).subscribe(prod => this.shoppinglistRead = prod );
  }

}
