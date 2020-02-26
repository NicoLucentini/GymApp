import { TestBed } from '@angular/core/testing';

import { UsuariosMgrService } from './usuarios-mgr.service';

describe('UsuariosMgrService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UsuariosMgrService = TestBed.get(UsuariosMgrService);
    expect(service).toBeTruthy();
  });
});
