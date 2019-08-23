import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  productForm = new FormGroup({
    name: new FormControl('', Validators.required),
    description: new FormControl(''),
    stock: new FormControl(0, [Validators.required, Validators.min(0)]),
    price: new FormControl(0, [Validators.required, Validators.min(0)])
  });

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  saveProduct() {
    this.http.post(environment.apiUrl + '/products', this.productForm.value).subscribe(
      (success) => {
        this.productForm.reset();
        Swal.fire(
          {
            title: 'Muy bien!',
            // @ts-ignore
            text: success.message,
            type: 'success'
          }
        );
      },
      (err) => {
        Swal.fire(
          {
            title: 'Error!',
            text: err.error.message,
            type: 'error'
          }
        );
      }
    );
  }
}
