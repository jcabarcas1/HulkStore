(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./$$_lazy_route_resource lazy recursive":
/*!******************************************************!*\
  !*** ./$$_lazy_route_resource lazy namespace object ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/app.component.html":
/*!**************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/app.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-navbar></app-navbar>\n<router-outlet></router-outlet>\n"

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/components/kardex/kardex.component.html":
/*!***********************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/components/kardex/kardex.component.html ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid register\">\n  <div class=\"row\">\n    <div class=\"col-md-3 register-left\">\n      <img src=\"https://image.ibb.co/n7oTvU/logo_white.png\" alt=\"\"/>\n      <h3>Bienvenido</h3>\n      <p>Aquí puedes comprar o vender productos de la tienda.</p>\n    </div>\n    <div class=\"col-md-9 register-right\">\n      <ul class=\"nav nav-tabs nav-justified\" id=\"myTab\" role=\"tablist\">\n        <li class=\"nav-item\">\n          <a class=\"nav-link active\" id=\"home-tab\" data-toggle=\"tab\" href=\"#home\" role=\"tab\" aria-controls=\"home\"\n             aria-selected=\"true\">Comprar</a>\n        </li>\n        <li class=\"nav-item\">\n          <a class=\"nav-link\" id=\"profile-tab\" data-toggle=\"tab\" href=\"#profile\" role=\"tab\" aria-controls=\"profile\"\n             aria-selected=\"false\">Vender</a>\n        </li>\n      </ul>\n\n      <!-- Compras -->\n      <div class=\"tab-content\" id=\"myTabContent\">\n        <div class=\"tab-pane fade show active\" id=\"home\" role=\"tabpanel\" aria-labelledby=\"home-tab\">\n          <h3 class=\"register-heading\">Compras (Agregar a stock)</h3>\n          <form [formGroup]=\"buyForm\" (ngSubmit)=\"buy()\" class=\"row register-form\">\n            <div class=\"col-md-6 col-sm-12\">\n              <div class=\"form-group\" formGroupName=\"product\">\n                <label for=\"product\">Producto *</label>\n                <select id=\"product\" class=\"form-control\" formControlName=\"idProduct\" (change)=\"changeProductBuy($event)\">\n                  <option class=\"hidden\" selected disabled>Porfavor selecciona un producto</option>\n                  <option value=\"{{product.idProduct}}\" *ngFor=\"let product of listProducts\">{{product.name}}</option>\n                </select>\n              </div>\n              <div class=\"form-group\" *ngIf=\"productBuy\">\n                <span>Información del producto </span>\n                <br>\n                <ul>\n                  <li>Nombre: {{productBuy.name}}</li>\n                  <li>Stock: {{productBuy.stock}}</li>\n                  <li>Precio: $ {{productBuy.price}}</li>\n                  <li>Descripción: <br><textarea cols=\"20\" rows=\"4\" disabled>{{productBuy.description}}</textarea> </li>\n                </ul>\n              </div>\n            </div>\n\n            <div class=\"col-md-6 col-sm-12\">\n              <div class=\"form-group\">\n                <label for=\"quantity\">Cantidad *</label>\n                <input type=\"number\" class=\"form-control\" id=\"quantity\" formControlName=\"quantity\" value=\"\"/>\n              </div>\n              <div class=\"form-group\" formGroupName=\"kardexHeader\">\n                <label for=\"buyer_doc\">Documento de identificación *</label>\n                <input type=\"text\" class=\"form-control\" id=\"buyer_doc\" value=\"\" formControlName=\"documentSeller\"/>\n              </div>\n              <input type=\"submit\" [disabled]=\"!buyForm.valid\" class=\"btn btn-primary\" value=\"Enviar\"/>\n            </div>\n          </form>\n        </div>\n\n        <!-- Ventas -->\n        <div class=\"tab-pane fade show\" id=\"profile\" role=\"tabpanel\" aria-labelledby=\"profile-tab\">\n\n          <h3 class=\"register-heading\">Ventas</h3>\n          <form [formGroup]=\"sellForm\" (ngSubmit)=\"sell()\"  class=\"row register-form\">\n            <div class=\"col-md-6 col-sm-12\">\n              <div class=\"form-group\" formGroupName=\"product\">\n                <label for=\"product_sell\">Producto *</label>\n                <select id=\"product_sell\" class=\"form-control\" formControlName=\"idProduct\" (change)=\"changeProductSell($event)\">\n                  <option class=\"hidden\" selected disabled>Porfavor selecciona un producto</option>\n                  <option value=\"{{product.idProduct}}\" *ngFor=\"let product of listProducts\">{{product.name}}</option>\n                </select>\n              </div>\n\n              <div class=\"form-group\" *ngIf=\"productSell\">\n                <span>Información del producto </span>\n                <br>\n                <ul>\n                  <li>Nombre: {{productSell.name}}</li>\n                  <li>Stock: {{productSell.stock}}</li>\n                  <li>Precio: $ {{productSell.price}}</li>\n                  <li>Descripción: <br><textarea cols=\"20\" rows=\"4\" disabled>{{productSell.description}}</textarea> </li>\n                </ul>\n              </div>\n            </div>\n\n            <div class=\"col-md-6 col-sm-12\">\n              <div class=\"form-group\">\n                <label for=\"quantity_sell\">Cantidad *</label>\n                <input type=\"number\" class=\"form-control\" id=\"quantity_sell\" value=\"\" formControlName=\"quantity\"/>\n              </div>\n              <div class=\"form-group\" formGroupName=\"kardexHeader\">\n                <label for=\"buyer_doc_sell\">Documento de identificación (Vendedor) *</label>\n                <input type=\"text\" class=\"form-control\" id=\"buyer_doc_sell\"  formControlName=\"documentSeller\" value=\"\"/>\n              </div>\n              <div class=\"form-group\" formGroupName=\"kardexHeader\">\n                <label for=\"seller_doc_sell\">Documento de identificación (Comprador) *</label>\n                <input type=\"text\" class=\"form-control\" id=\"seller_doc_sell\" formControlName=\"documentBuyer\" value=\"\"/>\n              </div>\n              <input type=\"submit\" [disabled]=\"!sellForm.valid\" class=\"btn btn-primary\" value=\"Enviar\"/>\n            </div>\n          </form>\n\n        </div>\n      </div>\n    </div>\n  </div>\n\n</div>\n"

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/components/navbar/navbar.component.html":
/*!***********************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/components/navbar/navbar.component.html ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-expand-lg navbar-light bg-light fixed-top\">\n  <a class=\"navbar-brand\" href=\"#\">Hulk Store</a>\n  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n    <span class=\"navbar-toggler-icon\"></span>\n  </button>\n\n  <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n    <ul class=\"navbar-nav mr-auto\">\n      <li class=\"nav-item\" routerLinkActive=\"active\">\n        <a class=\"nav-link\" href=\"#\" routerLink=\"/products\" >Registrar producto <span class=\"sr-only\">(current)</span></a>\n      </li>\n      <li class=\"nav-item\"  routerLinkActive=\"active\">\n        <a class=\"nav-link\" href=\"#\" routerLink=\"/kardex\">Compra y venta</a>\n      </li>\n    </ul>\n  </div>\n</nav>\n"

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/components/product/product.component.html":
/*!*************************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/components/product/product.component.html ***!
  \*************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid register\">\n  <div class=\"row\">\n    <div class=\"col-md-3 register-left\">\n      <img src=\"https://image.ibb.co/n7oTvU/logo_white.png\" alt=\"\"/>\n      <h3>Bienvenido</h3>\n      <p>Aquí puedes agregar un nuevo producto.</p>\n    </div>\n    <div class=\"col-md-9 register-right\">\n      <div class=\"tab-content\" id=\"myTabContent\">\n        <div class=\"tab-pane fade show active\" id=\"home\" role=\"tabpanel\" aria-labelledby=\"home-tab\">\n          <h3 class=\"register-heading\">Registrar producto</h3>\n          <form [formGroup]=\"productForm\" (ngSubmit)=\"saveProduct()\" class=\"row register-form\">\n            <div class=\"col-md-6\">\n              <div class=\"form-group\">\n                <label for=\"name\">Nombre *</label>\n                <input type=\"text\" id=\"name\" class=\"form-control\" value=\"\" formControlName=\"name\"/>\n              </div>\n              <div class=\"form-group\">\n                <label for=\"price\">Precio *</label>\n                <input type=\"number\" id=\"price\" class=\"form-control\" value=\"\" formControlName=\"price\" />\n              </div>\n              <div class=\"form-group\">\n                <label for=\"stock\">Stock *</label>\n                <input type=\"number\" id=\"stock\" class=\"form-control\" value=\"\" formControlName=\"stock\"/>\n              </div>\n            </div>\n            <div class=\"col-md-6\">\n              <div class=\"form-group\">\n                <label for=\"description\">Descripción</label>\n                <textarea class=\"form-control\" id=\"description\" rows=\"8\"\n                          formControlName=\"description\">\n                </textarea>\n              </div>\n              <input type=\"submit\" [disabled]=\"!productForm.valid\" class=\"btn btn-primary\" value=\"Enviar\"/>\n            </div>\n          </form>\n        </div>\n      </div>\n    </div>\n  </div>\n\n</div>\n"

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _components_product_product_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./components/product/product.component */ "./src/app/components/product/product.component.ts");
/* harmony import */ var _components_kardex_kardex_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./components/kardex/kardex.component */ "./src/app/components/kardex/kardex.component.ts");





var routes = [
    { path: '', redirectTo: 'products', pathMatch: 'full' },
    { path: 'products', component: _components_product_product_component__WEBPACK_IMPORTED_MODULE_3__["ProductComponent"] },
    { path: 'kardex', component: _components_kardex_kardex_component__WEBPACK_IMPORTED_MODULE_4__["KardexComponent"] },
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FwcC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'FrontEnd-HS';
    }
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! raw-loader!./app.component.html */ "./node_modules/raw-loader/index.js!./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _components_product_product_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./components/product/product.component */ "./src/app/components/product/product.component.ts");
/* harmony import */ var _components_kardex_kardex_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./components/kardex/kardex.component */ "./src/app/components/kardex/kardex.component.ts");
/* harmony import */ var _components_navbar_navbar_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./components/navbar/navbar.component */ "./src/app/components/navbar/navbar.component.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");










var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_4__["AppComponent"],
                _components_product_product_component__WEBPACK_IMPORTED_MODULE_5__["ProductComponent"],
                _components_kardex_kardex_component__WEBPACK_IMPORTED_MODULE_6__["KardexComponent"],
                _components_navbar_navbar_component__WEBPACK_IMPORTED_MODULE_7__["NavbarComponent"],
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_3__["AppRoutingModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_8__["HttpClientModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_9__["FormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_9__["ReactiveFormsModule"]
            ],
            providers: [],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_4__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/components/kardex/kardex.component.css":
/*!********************************************************!*\
  !*** ./src/app/components/kardex/kardex.component.css ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2NvbXBvbmVudHMva2FyZGV4L2thcmRleC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/components/kardex/kardex.component.ts":
/*!*******************************************************!*\
  !*** ./src/app/components/kardex/kardex.component.ts ***!
  \*******************************************************/
/*! exports provided: KardexComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "KardexComponent", function() { return KardexComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var sweetalert2__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! sweetalert2 */ "./node_modules/sweetalert2/dist/sweetalert2.all.js");
/* harmony import */ var sweetalert2__WEBPACK_IMPORTED_MODULE_5___default = /*#__PURE__*/__webpack_require__.n(sweetalert2__WEBPACK_IMPORTED_MODULE_5__);






var KardexComponent = /** @class */ (function () {
    function KardexComponent(http) {
        this.http = http;
        this.listProducts = [];
        this.buyForm = new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormGroup"]({
            product: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormGroup"]({
                idProduct: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"]('', _angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].required)
            }),
            kardexHeader: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormGroup"]({
                documentSeller: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"]('', _angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].required)
            }),
            quantity: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"]('', [_angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].min(0)])
        });
        this.sellForm = new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormGroup"]({
            product: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormGroup"]({
                idProduct: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"]('', _angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].required)
            }),
            kardexHeader: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormGroup"]({
                documentBuyer: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"]('', _angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].required),
                documentSeller: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"]('', _angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].required)
            }),
            quantity: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"]('', [_angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].min(0)])
        });
    }
    KardexComponent.prototype.ngOnInit = function () {
        this.loadProducts();
    };
    KardexComponent.prototype.buy = function () {
        var _this = this;
        this.http.put(_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].apiUrl + '/products/buy', this.buyForm.value).subscribe(function (success) {
            _this.loadProducts();
            _this.buyForm.reset();
            sweetalert2__WEBPACK_IMPORTED_MODULE_5___default.a.fire({
                title: 'Muy bien!',
                // @ts-ignore
                text: success.message,
                type: 'success'
            });
        }, function (err) {
            sweetalert2__WEBPACK_IMPORTED_MODULE_5___default.a.fire({
                title: 'Error!',
                text: err.error.message,
                type: 'error'
            });
        });
    };
    KardexComponent.prototype.sell = function () {
        var _this = this;
        this.http.put(_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].apiUrl + '/products/sell', this.sellForm.value).subscribe(function (success) {
            _this.loadProducts();
            _this.sellForm.reset();
            sweetalert2__WEBPACK_IMPORTED_MODULE_5___default.a.fire({
                title: 'Muy bien!',
                // @ts-ignore
                text: success.message,
                type: 'success'
            });
        }, function (err) {
            sweetalert2__WEBPACK_IMPORTED_MODULE_5___default.a.fire({
                title: 'Error!',
                text: err.error.message,
                type: 'error'
            });
        });
    };
    KardexComponent.prototype.changeProductBuy = function ($event) {
        this.productBuy = this.listProducts.filter(
        // @ts-ignore
        // tslint:disable-next-line:triple-equals
        function (product) { return product.idProduct == $event.target.value; })[0];
    };
    KardexComponent.prototype.changeProductSell = function ($event) {
        this.productSell = this.listProducts.filter(
        // @ts-ignore
        // tslint:disable-next-line:triple-equals
        function (product) { return product.idProduct == $event.target.value; })[0];
    };
    KardexComponent.prototype.loadProducts = function () {
        var _this = this;
        // Load products
        this.http.get(_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].apiUrl + '/products').subscribe(function (success) {
            // @ts-ignore
            _this.listProducts = success.data;
            _this.productBuy = null;
            _this.productSell = null;
        }, function (err) { return console.log(err); });
    };
    KardexComponent.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"] }
    ]; };
    KardexComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-kardex',
            template: __webpack_require__(/*! raw-loader!./kardex.component.html */ "./node_modules/raw-loader/index.js!./src/app/components/kardex/kardex.component.html"),
            styles: [__webpack_require__(/*! ./kardex.component.css */ "./src/app/components/kardex/kardex.component.css")]
        })
    ], KardexComponent);
    return KardexComponent;
}());



/***/ }),

/***/ "./src/app/components/navbar/navbar.component.css":
/*!********************************************************!*\
  !*** ./src/app/components/navbar/navbar.component.css ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2NvbXBvbmVudHMvbmF2YmFyL25hdmJhci5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/components/navbar/navbar.component.ts":
/*!*******************************************************!*\
  !*** ./src/app/components/navbar/navbar.component.ts ***!
  \*******************************************************/
/*! exports provided: NavbarComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NavbarComponent", function() { return NavbarComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var NavbarComponent = /** @class */ (function () {
    function NavbarComponent() {
    }
    NavbarComponent.prototype.ngOnInit = function () {
    };
    NavbarComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-navbar',
            template: __webpack_require__(/*! raw-loader!./navbar.component.html */ "./node_modules/raw-loader/index.js!./src/app/components/navbar/navbar.component.html"),
            styles: [__webpack_require__(/*! ./navbar.component.css */ "./src/app/components/navbar/navbar.component.css")]
        })
    ], NavbarComponent);
    return NavbarComponent;
}());



/***/ }),

/***/ "./src/app/components/product/product.component.css":
/*!**********************************************************!*\
  !*** ./src/app/components/product/product.component.css ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2NvbXBvbmVudHMvcHJvZHVjdC9wcm9kdWN0LmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/components/product/product.component.ts":
/*!*********************************************************!*\
  !*** ./src/app/components/product/product.component.ts ***!
  \*********************************************************/
/*! exports provided: ProductComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProductComponent", function() { return ProductComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var sweetalert2__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! sweetalert2 */ "./node_modules/sweetalert2/dist/sweetalert2.all.js");
/* harmony import */ var sweetalert2__WEBPACK_IMPORTED_MODULE_5___default = /*#__PURE__*/__webpack_require__.n(sweetalert2__WEBPACK_IMPORTED_MODULE_5__);






var ProductComponent = /** @class */ (function () {
    function ProductComponent(http) {
        this.http = http;
        this.productForm = new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormGroup"]({
            name: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"]('', _angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].required),
            description: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"](''),
            stock: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"](0, [_angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].min(0)]),
            price: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"](0, [_angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].min(0)])
        });
    }
    ProductComponent.prototype.ngOnInit = function () {
    };
    ProductComponent.prototype.saveProduct = function () {
        var _this = this;
        this.http.post(_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].apiUrl + '/products', this.productForm.value).subscribe(function (success) {
            _this.productForm.reset();
            sweetalert2__WEBPACK_IMPORTED_MODULE_5___default.a.fire({
                title: 'Muy bien!',
                // @ts-ignore
                text: success.message,
                type: 'success'
            });
        }, function (err) {
            sweetalert2__WEBPACK_IMPORTED_MODULE_5___default.a.fire({
                title: 'Error!',
                text: err.error.message,
                type: 'error'
            });
        });
    };
    ProductComponent.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] }
    ]; };
    ProductComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-product',
            template: __webpack_require__(/*! raw-loader!./product.component.html */ "./node_modules/raw-loader/index.js!./src/app/components/product/product.component.html"),
            styles: [__webpack_require__(/*! ./product.component.css */ "./src/app/components/product/product.component.css")]
        })
    ], ProductComponent);
    return ProductComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false,
    apiUrl: 'http://localhost:8080'
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /home/jcabarcas/Documentos/HulkStore/FrontEnd-HS/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main-es5.js.map