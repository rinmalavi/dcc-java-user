package com.dslplatform.test.M.repositories;

public class BRepository extends com.dslplatform.client.ClientPersistableRepository<com.dslplatform.test.M.B> {
	public BRepository(final com.dslplatform.patterns.ServiceLocator locator) {
		super(com.dslplatform.test.M.B.class, locator);
	}
}