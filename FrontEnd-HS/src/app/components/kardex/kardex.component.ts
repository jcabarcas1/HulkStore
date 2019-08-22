import { Component, OnInit } from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-kardex',
  templateUrl: './kardex.component.html',
  styleUrls: ['./kardex.component.css']
})
export class KardexComponent implements OnInit {

  listProducts: any = [];

  buyForm = new FormGroup({
    product: new FormGroup({
      idProduct: new FormControl('', Validators.required)
    }),
    documentBuyer: new FormControl('', Validators.required),
    quantity: new FormControl(0, Validators.required)
  });

  constructor(private http: HttpClient) { }

  ngOnInit() {

    // Load products
    this.http.get(environment.apiUrl + '/products').subscribe(
      (success) => {
        // @ts-ignore
        this.listProducts = success.data;
        console.log(this.listProducts);
      },
      (err) => console.log(err)
    );

  }

  buy() {
    console.log(this.buyForm.value);

    this.http.put(environment.apiUrl + '/products/buy', this.buyForm.value).subscribe(
      (success) => {
        // @ts-ignore
        console.log(success);
      },
      (err) => console.log(err)
    );


  }
}
