package com.dslplatform.test.M.repositories;

public class ARepository extends com.dslplatform.client.ClientPersistableRepository<com.dslplatform.test.M.A> {
	public ARepository(final com.dslplatform.patterns.ServiceLocator locator) {
		super(com.dslplatform.test.M.A.class, locator);
	}
}