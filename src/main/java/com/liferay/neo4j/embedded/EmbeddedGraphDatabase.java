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

package com.liferay.neo4j.embedded;

import aQute.bnd.annotation.metatype.Configurable;
import com.liferay.neo4j.embedded.configuration.EmbdeddedGraphDatabaseConfiguration;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.metatype.annotations.Designate;

import java.io.File;
import java.util.Map;

/**
 * @author Gergely Mathe
 */
@Component(
	configurationPid = "com.liferay.neo4j.embedded.configuration.EmbeddedGraphDatabaseConfiguration",
	configurationPolicy = ConfigurationPolicy.REQUIRE,
	immediate = true, service = EmbeddedGraphDatabase.class)
@Designate(ocd = EmbdeddedGraphDatabaseConfiguration.class)
public class EmbeddedGraphDatabase {

	@Activate
	public void activate(Map<String, Object> properties) {
		_embdeddedGraphDatabaseConfiguration = Configurable.createConfigurable(
			EmbdeddedGraphDatabaseConfiguration.class, properties);

		initialize();
	}

	public GraphDatabaseService getEmbeddedDatabaseService() {
		if (_embeddedDatabaseService == null) {
			initialize();
		}

		return _embeddedDatabaseService;
	}

	public void initialize() {
		GraphDatabaseFactory graphDatabaseFactory =
			new GraphDatabaseFactory();

		_embeddedDatabaseService = graphDatabaseFactory.newEmbeddedDatabase(
			new File(
				_embdeddedGraphDatabaseConfiguration.embeddedDatabasePath()));
	}

	private  EmbdeddedGraphDatabaseConfiguration
		_embdeddedGraphDatabaseConfiguration;
	private GraphDatabaseService _embeddedDatabaseService;

}
