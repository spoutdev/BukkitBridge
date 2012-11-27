/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012, VanillaDev <http://www.spout.org/>
 * BukkitBridge is licensed under the GNU General Public License.
 *
 * BukkitBridge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BukkitBridge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spout.bridge.bukkit.help;

import java.util.Collection;
import java.util.List;

import org.bukkit.help.HelpMap;
import org.bukkit.help.HelpTopic;
import org.bukkit.help.HelpTopicFactory;

public class SimpleHelpMap implements HelpMap {
	@Override
	public HelpTopic getHelpTopic(String s) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<HelpTopic> getHelpTopics() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addTopic(HelpTopic helpTopic) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void clear() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void registerHelpTopicFactory(Class<?> aClass, HelpTopicFactory<?> helpTopicFactory) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public List<String> getIgnoredPlugins() {
		throw new UnsupportedOperationException();
	}
}
