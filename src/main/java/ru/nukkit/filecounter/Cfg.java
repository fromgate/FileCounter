package ru.nukkit.filecounter;

import cn.nukkit.plugin.Plugin;
import cn.nukkit.utils.SimpleConfig;

/**
 * Created by Igor on 09.06.2016.
 */
public class Cfg extends SimpleConfig {

    @Path("recheck-interval")
    public int repeat = 30;

    public Cfg(Plugin plugin) {
        super(plugin);
    }
}
