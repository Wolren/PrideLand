package net.wolren.land.util.config;


import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "pride_land")
public class RainbowConfig implements ConfigData {
    public boolean enableRainbowSheepSpawning = true;
    public int sheepWeight = 5;
    public int sheepMinGroupSize = 2;
    public int sheepMaxGroupSize = 3;
}
