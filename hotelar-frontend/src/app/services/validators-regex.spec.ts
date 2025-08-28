import { TestBed } from '@angular/core/testing';

import { ValidatorsRegex } from './validators-regex';

describe('ValidatorsRegex', () => {
  let service: ValidatorsRegex;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ValidatorsRegex);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
