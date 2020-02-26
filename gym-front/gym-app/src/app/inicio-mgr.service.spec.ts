import { TestBed } from '@angular/core/testing';

import { InicioMgrService } from './inicio-mgr.service';

describe('InicioMgrService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: InicioMgrService = TestBed.get(InicioMgrService);
    expect(service).toBeTruthy();
  });
});
