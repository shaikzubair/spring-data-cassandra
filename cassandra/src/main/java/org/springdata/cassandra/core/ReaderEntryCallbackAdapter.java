/*
 * Copyright 2014 the original author or authors.
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
package org.springdata.cassandra.core;

import org.springdata.cql.core.RowCallbackHandler;
import org.springframework.data.convert.EntityReader;
import org.springframework.util.Assert;

import com.datastax.driver.core.Row;

/**
 * 
 * @author Alex Shvid
 * 
 */
public class ReaderEntryCallbackAdapter<T> implements RowCallbackHandler {

	private final EntityReader<? super T, Object> reader;
	private final Class<T> entityClass;
	private final EntryCallbackHandler<T> delegate;

	public ReaderEntryCallbackAdapter(EntityReader<? super T, Object> reader, Class<T> entityClass,
			EntryCallbackHandler<T> ech) {
		Assert.notNull(reader);
		Assert.notNull(entityClass);
		Assert.notNull(ech);

		this.reader = reader;
		this.entityClass = entityClass;
		this.delegate = ech;
	}

	@Override
	public void processRow(Row row) {
		T entry = reader.read(entityClass, row);
		delegate.processEntry(entry);
	}

}
