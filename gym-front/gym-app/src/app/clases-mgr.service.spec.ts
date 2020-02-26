import { TestBed } from '@angular/core/testing';

import { ClasesMgrService } from './clases-mgr.service';

describe('ClasesMgrService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ClasesMgrService = TestBed.get(ClasesMgrService);
    expect(service).toBeTruthy();
  });
});
