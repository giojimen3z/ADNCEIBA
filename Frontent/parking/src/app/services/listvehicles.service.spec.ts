import { TestBed } from '@angular/core/testing';

import { ListvehiclesService } from './listvehicles.service';

describe('ListvehiclesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ListvehiclesService = TestBed.get(ListvehiclesService);
    expect(service).toBeTruthy();
  });
});
