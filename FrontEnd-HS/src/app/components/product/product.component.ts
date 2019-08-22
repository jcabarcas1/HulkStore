import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  productForm = new FormGroup({
    name: new FormControl('', Validators.required),
    description: new FormControl(''),
    stock: new FormControl(0, Validators.required),
    price: new FormControl(0, Validators.required)
  });

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  saveProduct() {
    this.http.post(environment.apiUrl + '/products', this.productForm.value).subscribe(
      (success) => alert('Producto agregado!'),
      (err) => console.log(err)
    );
  }
}
