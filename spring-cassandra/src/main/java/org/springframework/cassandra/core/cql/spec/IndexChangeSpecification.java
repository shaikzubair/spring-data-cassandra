/*
 * Copyright 2013 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.cassandra.core.cql.spec;

import static org.springframework.cassandra.core.cql.CqlStringUtils.checkIdentifier;
import static org.springframework.cassandra.core.cql.CqlStringUtils.identifize;

/**
 * Abstract builder class to support the construction of index specifications.
 * 
 * @author Alex Shvid
 * @param <T> The subtype of the {@link IndexChangeSpecification}
 */
public abstract class IndexChangeSpecification<T extends IndexChangeSpecification<T>> {

	/**
	 * The optional name of the index.
	 */
	private String name;

	/**
	 * Sets the index name.
	 * 
	 * @return this
	 */
	@SuppressWarnings("unchecked")
	public T name(String name) {
		checkIdentifier(name);
		this.name = name;
		return (T) this;
	}

	public String getName() {
		return name;
	}

	public String getNameAsIdentifier() {
		return name != null ? identifize(name) : "";
	}
}