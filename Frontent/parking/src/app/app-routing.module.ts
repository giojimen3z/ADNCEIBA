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
            import('./pages/addvehicle/addvehicle.module').then(
              m => m.AddvehicleModule
            )
        },
        {
          path: 'Add',
          loadChildren: () =>
            import('./pages/addvehicle/addvehicle.module').then(
              m => m.AddvehicleModule
            )
        },
        {
        path: 'vehicles',
          loadChildren: () =>
            import('./pages/vehiclelist/vehiclelist.module').then(
              m => m.VehiclelistModule
            )
        },
        {
          path: 'bill',
          loadChildren: () =>
            import('./pages/bill/bill.module').then(
              m => m.BillModule
            )
        },
        {
          path: 'pay',
          loadChildren: () =>
            import('./pages/pay/pay.module').then(
              m => m.PayModule
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
