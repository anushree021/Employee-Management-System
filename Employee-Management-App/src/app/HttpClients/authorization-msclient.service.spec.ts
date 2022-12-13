import { TestBed } from '@angular/core/testing';

import { AuthorizationMsclientService } from './authorization-msclient.service';

describe('AuthorizationMsclientService', () => {
  let service: AuthorizationMsclientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthorizationMsclientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
