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
package org.springdata.cassandra.convert;

import org.springdata.cassandra.mapping.CassandraPersistentProperty;

/**
 * Simple converter for values
 * 
 * @author Alex Shvid
 * 
 */

public final class CassandraValueConverter {

	private CassandraValueConverter() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object afterRead(CassandraPersistentProperty property, Object value) {

		if (value != null && property.isEnum()) {
			return Enum.valueOf((Class<? extends Enum>) property.getType(), value.toString());
		}

		return value;
	}

	public static Object beforeWrite(Object value) {

		if (value == null) {
			return value;
		}

		if (value.getClass().isEnum()) {
			return ((Enum) value).name();
		}

		return value;
	}

}
