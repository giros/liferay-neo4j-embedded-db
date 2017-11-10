/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.neo4j.embedded.configuration;

import aQute.bnd.annotation.metatype.Meta;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

/**
 * @author Gergely Mathe
 */
@ObjectClassDefinition(
	id = "com.liferay.neo4j.embedded.configuration.EmbdeddedGraphDatabaseConfiguration", name = "Liferay Embedded Neo4j Database Configuration"
)
public @interface EmbdeddedGraphDatabaseConfiguration {

	@Meta.AD(deflt = "data/neo4j/default")
	public String embeddedDatabasePath() default "data/neo4j/default";

}
