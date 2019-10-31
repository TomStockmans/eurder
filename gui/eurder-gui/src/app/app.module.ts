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
const appRoutes: Routes = [
  { path: 'user', component: UserComponent },
  { path: 'item', component: ItemComponent },
  { path: 'order', component: OrderComponent },
  { path: 'customer', component: CustomerComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    ItemComponent,
    OrderComponent,
    CustomerComponent
  ],
  imports: [
      RouterModule.forRoot(
        appRoutes,
        { enableTracing: true } // <-- debugging purposes only
      ),
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
