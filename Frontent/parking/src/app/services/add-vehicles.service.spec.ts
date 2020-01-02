import { TestBed } from '@angular/core/testing';

import { AddVehiclesService } from './add-vehicles.service';

describe('AddVehiclesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddVehiclesService = TestBed.get(AddVehiclesService);
    expect(service).toBeTruthy();
  });
});
