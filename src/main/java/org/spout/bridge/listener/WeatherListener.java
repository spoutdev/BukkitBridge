/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012 Spout LLC <http://www.spout.org/>
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
package org.spout.bridge.listener;

import org.bukkit.Bukkit;

import org.spout.api.event.EventHandler;

import org.spout.bridge.BukkitBridgePlugin;

import org.spout.vanilla.data.Weather;
import org.spout.vanilla.event.world.WeatherChangeEvent;

public class WeatherListener extends AbstractListener {
	public WeatherListener(BukkitBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler
	public void onLightningStrike() {
		// TODO: Implement onLightningStrike
		throw new UnsupportedOperationException();
	}

	@EventHandler
	public void onWeatherChange(WeatherChangeEvent event) {
		org.bukkit.World world = Bukkit.getWorld(event.getWorld().getName());
		// Rain
		org.bukkit.event.weather.WeatherChangeEvent weatherChange = null;
		if ((event.getCurrentWeather() == Weather.RAIN || event.getCurrentWeather() == Weather.THUNDERSTORM) && event.getNewWeather() == Weather.CLEAR) {
			weatherChange = new org.bukkit.event.weather.WeatherChangeEvent(world, false);
		}
		if (event.getCurrentWeather() == Weather.CLEAR && (event.getNewWeather() == Weather.RAIN || event.getNewWeather() == Weather.THUNDERSTORM)) {
			weatherChange = new org.bukkit.event.weather.WeatherChangeEvent(world, true);
		}
		if (weatherChange != null) {
			weatherChange.setCancelled(event.isCancelled());
			Bukkit.getPluginManager().callEvent(weatherChange);
			event.setCancelled(weatherChange.isCancelled());
		}
		// Thunderstorm
		org.bukkit.event.weather.ThunderChangeEvent thunderChange = null;
		if (event.getCurrentWeather() == Weather.THUNDERSTORM && (event.getNewWeather() == Weather.CLEAR || event.getNewWeather() == Weather.RAIN)) {
			thunderChange = new org.bukkit.event.weather.ThunderChangeEvent(world, false);
		}
		if ((event.getCurrentWeather() == Weather.CLEAR || event.getCurrentWeather() == Weather.RAIN) && event.getNewWeather() == Weather.THUNDERSTORM) {
			thunderChange = new org.bukkit.event.weather.ThunderChangeEvent(world, true);
		}
		if (thunderChange != null) {
			thunderChange.setCancelled(event.isCancelled());
			Bukkit.getPluginManager().callEvent(thunderChange);
			event.setCancelled(thunderChange.isCancelled());
		}
	}
}
