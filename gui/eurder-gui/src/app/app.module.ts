import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { ItemComponent } from './item/item.component';
import { OrderComponent } from './order/order.component';
import { CustomerComponent } from './customer/customer.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { CustomInterceptor } from './interceptor';

const appRoutes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'user', component: UserComponent },
  { path: 'item', component: ItemComponent },
  { path: 'order', component: OrderComponent },
  { path: 'customer', component: CustomerComponent },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    ItemComponent,
    OrderComponent,
    CustomerComponent,
    LoginComponent,
    HomeComponent,
  ],
  imports: [
      RouterModule.forRoot(
        appRoutes,
        { enableTracing: true } // <-- debugging purposes only
      ),
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: CustomInterceptor, multi: true},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
