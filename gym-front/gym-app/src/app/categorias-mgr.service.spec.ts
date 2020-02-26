import { TestBed } from '@angular/core/testing';

import { CategoriasMgrService } from './categorias-mgr.service';

describe('CategoriasMgrService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CategoriasMgrService = TestBed.get(CategoriasMgrService);
    expect(service).toBeTruthy();
  });
});
