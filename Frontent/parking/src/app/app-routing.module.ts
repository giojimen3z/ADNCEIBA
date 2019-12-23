import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MenuComponent } from './components/menu/menu.component';
import { MenuModule } from './components/menu/menu.module';

const routes: Routes = [{
    path: '',
    loadChildren: () =>
      import('./pages/login/login.module').then(
        m => m.LoginModule
      )
    },
    {
      path: 'register',
      loadChildren: () =>
        import('./pages/register/register.module').then(
          m => m.RegisterModule
        )
    },
    {
      path: 'menu',
      component: MenuComponent,
      children: [
        {
        path: '',
          loadChildren: () =>
            import('./pages/products/products.module').then(
              m => m.ProductsModule
            )
        },
        {
        path: 'products',
          loadChildren: () =>
            import('./pages/products/products.module').then(
              m => m.ProductsModule
            )
        },
        {
          path: 'page-one',
          loadChildren: () =>
            import('./pages/page-one/page-one.module').then(
              m => m.PageOneModule
            )
        },
        {
          path: 'to-shell',
          loadChildren: () =>
            import('./pages/market/market.module').then(
              m => m.MarketModule
            )
        },
        {
          path: 'my-products',
          loadChildren: () =>
            import('./pages/myproducts/myproducts.module').then(
              m => m.MyproductsModule
            )
        }
      ]
    }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes), MenuModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
