package com.dslplatform.test.M;

public class B   implements java.io.Serializable, com.dslplatform.patterns.AggregateRoot {

	public B() {

		URI = java.util.UUID.randomUUID().toString();
		this.ID = 0;
		this.i = 0;
		this.f = 0.0f;
		this.s = "";
		this.aID = 0;
	}

	private transient com.dslplatform.patterns.ServiceLocator _serviceLocator;

	private String URI;

	@com.fasterxml.jackson.annotation.JsonProperty("URI")
	public String getURI()  {

		return this.URI;
	}

	@Override
	public int hashCode() {
		return URI.hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;
		final B other = (B) obj;

		return URI.equals(other.URI);
	}

	@Override
	public String toString() {
		return "B(" + URI + ')';
	}

	private static final long serialVersionUID = 0x0097000a;

	public B(
			final int i,
			final float f,
			final String s,
			final com.dslplatform.test.M.A a) {

		setI(i);
		setF(f);
		setS(s);
		setA(a);
	}

	@com.fasterxml.jackson.annotation.JsonCreator private B(
			@com.fasterxml.jackson.annotation.JacksonInject("_serviceLocator") final com.dslplatform.patterns.ServiceLocator _serviceLocator,
			@com.fasterxml.jackson.annotation.JsonProperty("URI") final String URI ,
			@com.fasterxml.jackson.annotation.JsonProperty("ID") final int ID,
			@com.fasterxml.jackson.annotation.JsonProperty("i") final int i,
			@com.fasterxml.jackson.annotation.JsonProperty("f") final float f,
			@com.fasterxml.jackson.annotation.JsonProperty("s") final String s,
			@com.fasterxml.jackson.annotation.JsonProperty("aURI") final String aURI,
			@com.fasterxml.jackson.annotation.JsonProperty("aID") final int aID) {
		this._serviceLocator = _serviceLocator;
		this.URI = URI != null ? URI : new java.util.UUID(0L, 0L).toString();
		this.ID = ID;
		this.i = i;
		this.f = f;
		this.s = s == null ? "" : s;
		this.aURI = aURI;
		this.aID = aID;
	}

	private int ID;

	@com.fasterxml.jackson.annotation.JsonProperty("ID")
	@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
	public int getID()  {

		return ID;
	}

	private B setID(final int value) {

		this.ID = value;

		return this;
	}

	public boolean isNewAggregate() {
		return _serviceLocator == null;
	}

	public static B find(final String uri) throws java.io.IOException {
		return find(uri, com.dslplatform.client.Bootstrap.getLocator());
	}
	public static B find(final String uri, final com.dslplatform.patterns.ServiceLocator locator) throws java.io.IOException {
		try {
			return (locator != null ? locator : com.dslplatform.client.Bootstrap.getLocator()).resolve(com.dslplatform.client.CrudProxy.class).read(B.class, uri).get();
		} catch (final InterruptedException e) {
			throw new java.io.IOException(e);
		} catch (final java.util.concurrent.ExecutionException e) {
			throw new java.io.IOException(e);
		}
	}
	public static java.util.List<B> find(final Iterable<String> uris) throws java.io.IOException {
		return find(uris, com.dslplatform.client.Bootstrap.getLocator());
	}
	public static java.util.List<B> find(final Iterable<String> uris, final com.dslplatform.patterns.ServiceLocator locator) throws java.io.IOException {
		try {
			return (locator != null ? locator : com.dslplatform.client.Bootstrap.getLocator()).resolve(com.dslplatform.client.DomainProxy.class).find(B.class, uris).get();
		} catch (final InterruptedException e) {
			throw new java.io.IOException(e);
		} catch (final java.util.concurrent.ExecutionException e) {
			throw new java.io.IOException(e);
		}
	}
	public static java.util.List<B> findAll() throws java.io.IOException {
		return findAll(null, null, com.dslplatform.client.Bootstrap.getLocator());
	}
	public static java.util.List<B> findAll(final com.dslplatform.patterns.ServiceLocator locator) throws java.io.IOException {
		return findAll(null, null, locator);
	}
	public static java.util.List<B> findAll(final Integer limit, final Integer offset) throws java.io.IOException {
		return findAll(limit, offset, com.dslplatform.client.Bootstrap.getLocator());
	}
	public static java.util.List<B> findAll(final Integer limit, final Integer offset, final com.dslplatform.patterns.ServiceLocator locator) throws java.io.IOException {
		try {
			return (locator != null ? locator : com.dslplatform.client.Bootstrap.getLocator()).resolve(com.dslplatform.client.DomainProxy.class).findAll(B.class, limit, offset, null).get();
		} catch (final InterruptedException e) {
			throw new java.io.IOException(e);
		} catch (final java.util.concurrent.ExecutionException e) {
			throw new java.io.IOException(e);
		}
	}
	public static java.util.List<B> search(final com.dslplatform.patterns.Specification<B> specification) throws java.io.IOException {
		return search(specification, null, null, com.dslplatform.client.Bootstrap.getLocator());
	}
	public static java.util.List<B> search(final com.dslplatform.patterns.Specification<B> specification, final com.dslplatform.patterns.ServiceLocator locator) throws java.io.IOException {
		return search(specification, null, null, locator);
	}
	public static java.util.List<B> search(final com.dslplatform.patterns.Specification<B> specification, final Integer limit, final Integer offset) throws java.io.IOException {
		return search(specification, limit, offset, com.dslplatform.client.Bootstrap.getLocator());
	}
	public static java.util.List<B> search(final com.dslplatform.patterns.Specification<B> specification, final Integer limit, final Integer offset, final com.dslplatform.patterns.ServiceLocator locator) throws java.io.IOException {
		try {
			return (locator != null ? locator : com.dslplatform.client.Bootstrap.getLocator()).resolve(com.dslplatform.client.DomainProxy.class).search(specification, limit, offset, null).get();
		} catch (final InterruptedException e) {
			throw new java.io.IOException(e);
		} catch (final java.util.concurrent.ExecutionException e) {
			throw new java.io.IOException(e);
		}
	}
	public static long count() throws java.io.IOException {
		return count(com.dslplatform.client.Bootstrap.getLocator());
	}
	public static long count(final com.dslplatform.patterns.ServiceLocator locator) throws java.io.IOException {
		try {
			return (locator != null ? locator : com.dslplatform.client.Bootstrap.getLocator()).resolve(com.dslplatform.client.DomainProxy.class).count(B.class).get().longValue();
		} catch (final InterruptedException e) {
			throw new java.io.IOException(e);
		} catch (final java.util.concurrent.ExecutionException e) {
			throw new java.io.IOException(e);
		}
	}
	public static long count(final com.dslplatform.patterns.Specification<B> specification) throws java.io.IOException {
		return count(specification, com.dslplatform.client.Bootstrap.getLocator());
	}
	public static long count(final com.dslplatform.patterns.Specification<B> specification, final com.dslplatform.patterns.ServiceLocator locator) throws java.io.IOException {
		try {
			return (locator != null ? locator : com.dslplatform.client.Bootstrap.getLocator()).resolve(com.dslplatform.client.DomainProxy.class).count(specification).get().longValue();
		} catch (final InterruptedException e) {
			throw new java.io.IOException(e);
		} catch (final java.util.concurrent.ExecutionException e) {
			throw new java.io.IOException(e);
		}
	}

	private void updateWithAnother(final B result) {
		this.URI = result.URI;

		this.i = result.i;
		this.f = result.f;
		this.s = result.s;
		this.a = result.a;
		this.aURI = result.aURI;
		this.aID = result.aID;
		this.ID = result.ID;
	}
	public B create() throws java.io.IOException {
		return create(_serviceLocator != null ? _serviceLocator : com.dslplatform.client.Bootstrap.getLocator());
	}
	public B create(com.dslplatform.patterns.ServiceLocator locator) throws java.io.IOException {

		if (this.getAURI() == null) {
			throw new IllegalArgumentException("Cannot persist instance of 'com.dslplatform.test.M.B' because reference 'a' was not assigned");
		}
		final B result;
		try {
			com.dslplatform.client.CrudProxy proxy = (locator != null ? locator : com.dslplatform.client.Bootstrap.getLocator()).resolve(com.dslplatform.client.CrudProxy.class);
			result = proxy.create(this).get();
		} catch (final InterruptedException e) {
			throw new java.io.IOException(e);
		} catch (final java.util.concurrent.ExecutionException e) {
			throw new java.io.IOException(e);
		}
		this.updateWithAnother(result);
		this._serviceLocator = locator != null ? locator : com.dslplatform.client.Bootstrap.getLocator();
		return this;
	}
	public B update() throws java.io.IOException {

		if (this.getAURI() == null) {
			throw new IllegalArgumentException("Cannot persist instance of 'com.dslplatform.test.M.B' because reference 'a' was not assigned");
		}
		if (_serviceLocator == null) throw new java.io.IOException("Can't update newly created aggregate root");
		final B result;
		try {
			com.dslplatform.client.CrudProxy proxy = _serviceLocator.resolve(com.dslplatform.client.CrudProxy.class);
			result = proxy.update(this).get();
		} catch (final InterruptedException e) {
			throw new java.io.IOException(e);
		} catch (final java.util.concurrent.ExecutionException e) {
			throw new java.io.IOException(e);
		}
		this.updateWithAnother(result);
		return this;
	}
	public B delete() throws java.io.IOException {
		if (_serviceLocator == null) throw new java.io.IOException("Can't delete newly created aggregate root");
		try {
			com.dslplatform.client.CrudProxy proxy = _serviceLocator.resolve(com.dslplatform.client.CrudProxy.class);
			return proxy.delete(B.class, URI).get();
		} catch (final InterruptedException e) {
			throw new java.io.IOException(e);
		} catch (final java.util.concurrent.ExecutionException e) {
			throw new java.io.IOException(e);
		}
	}

	private int i;

	@com.fasterxml.jackson.annotation.JsonProperty("i")
	@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
	public int getI()  {

		return i;
	}

	public B setI(final int value) {

		this.i = value;

		return this;
	}

	private float f;

	@com.fasterxml.jackson.annotation.JsonProperty("f")
	@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
	public float getF()  {

		return f;
	}

	public B setF(final float value) {

		this.f = value;

		return this;
	}

	private String s;

	@com.fasterxml.jackson.annotation.JsonProperty("s")
	@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
	public String getS()  {

		return s;
	}

	public B setS(final String value) {

		if(value == null) throw new IllegalArgumentException("Property \"s\" cannot be null!");
		this.s = value;

		return this;
	}

	private com.dslplatform.test.M.A a;

	@com.fasterxml.jackson.annotation.JsonIgnore
	public com.dslplatform.test.M.A getA() throws java.io.IOException {

		if (a != null && !a.getURI().equals(aURI) || a == null && aURI != null)
			try {
				com.dslplatform.client.CrudProxy proxy = _serviceLocator.resolve(com.dslplatform.client.CrudProxy.class);
				a = proxy.read(com.dslplatform.test.M.A.class, aURI).get();
			} catch (final InterruptedException e) {
				throw new java.io.IOException(e);
			} catch (final java.util.concurrent.ExecutionException e) {
				throw new java.io.IOException(e);
			}
		return a;
	}

	public B setA(final com.dslplatform.test.M.A value) {

		if(value == null) throw new IllegalArgumentException("Property \"a\" cannot be null!");

		if(value != null && value.getURI() == null) throw new IllegalArgumentException("Reference \"M.A\" for property \"a\" must be persisted before it's assigned");
		this.a = value;

		this.aURI = value.getURI();

		this.aID = value.getID();
		return this;
	}

	private String aURI;

	@com.fasterxml.jackson.annotation.JsonProperty("aURI")
	public String getAURI()  {

		return this.aURI;
	}

	private int aID;

	@com.fasterxml.jackson.annotation.JsonProperty("aID")
	@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
	public int getAID()  {

		return aID;
	}

	private B setAID(final int value) {

		this.aID = value;

		return this;
	}
}
