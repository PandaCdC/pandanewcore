package me.zpandakst.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldSaveEvent;

public class DontRainEvent implements Listener {
    @EventHandler
    public void onWeather(WeatherChangeEvent event) {
        if (event.toWeatherState()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onWeather(WorldLoadEvent event) {
        if (event.getWorld().hasStorm()) {
            event.getWorld().setStorm(false);
        }
        event.getWorld().setWeatherDuration(999999999);
    }

    @EventHandler
    public void onWeather(WorldSaveEvent event) {
        if (event.getWorld().hasStorm()) {
            event.getWorld().setStorm(false);
        }
        event.getWorld().setWeatherDuration(999999999);
    }
}
