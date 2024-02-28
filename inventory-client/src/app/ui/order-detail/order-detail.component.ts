import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.css']
})
export class OrderDetailComponent implements OnInit {

  orderId!: any;
  currentOrder: any;

  constructor(private route: ActivatedRoute, private http: HttpClient) {
    this.orderId = this.route.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.http.get('http://localhost:8082/api/orders/'+ this.orderId).subscribe({
      next: order => this.currentOrder = order,
      error: err => console.log(err)
    });
  }

  getTotal(order: any) {
    let total = 0;
    order.productItems.forEach((product: any)=> {
      total+= (product.price * product.quantity);
    });
    return total;
  }

}
