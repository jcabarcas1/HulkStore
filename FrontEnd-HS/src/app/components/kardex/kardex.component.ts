import {Component, OnInit} from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2';

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
    kardexHeader: new FormGroup({
      documentSeller: new FormControl('', Validators.required)
    }),
    quantity: new FormControl('', Validators.required)
  });
  sellForm = new FormGroup({
    product: new FormGroup({
      idProduct: new FormControl('', Validators.required)
    }),
    kardexHeader: new FormGroup({
      documentBuyer: new FormControl('', Validators.required),
      documentSeller: new FormControl('', Validators.required)
    }),
    quantity: new FormControl('', Validators.required)
  });

  constructor(private http: HttpClient) {
  }

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

    this.http.put(environment.apiUrl + '/products/buy', this.buyForm.value).subscribe(
      (success) => {
        this.buyForm.reset();
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

  sell() {

    this.http.put(environment.apiUrl + '/products/sell', this.sellForm.value).subscribe(
      (success) => {
        this.sellForm.reset();
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
