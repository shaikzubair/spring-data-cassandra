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
package org.springdata.cql.spec;

/**
 * Builder class to construct a <code>DROP INDEX</code> specification.
 * 
 * @author Alex Shvid
 */
public class DropIndexSpecification extends WithNameSpecification<DropIndexSpecification> {

	/**
	 * Sets the default index name based on table and column name.
	 * 
	 * @return this
	 */
	public DropIndexSpecification defaultName(String table, String column) {
		StringBuilder str = new StringBuilder();
		str.append(table);
		str.append("_");
		str.append(column);
		str.append("_idx");
		return name(str.toString());
	}

}
