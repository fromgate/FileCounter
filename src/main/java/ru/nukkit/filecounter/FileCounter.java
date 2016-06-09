package ru.nukkit.filecounter;

import cn.nukkit.Server;
import cn.nukkit.plugin.PluginBase;
import com.sun.management.UnixOperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class FileCounter extends PluginBase {

    private Cfg cfg;
    @Override
    public void onEnable(){
        cfg = new Cfg(this);
        cfg.load();
        cfg.save();
        Server.getInstance().getScheduler().scheduleRepeatingTask(new Runnable() {
            public void run() {
                Server.getInstance().getLogger().info("Open files: "+openFiles());
            }
        },cfg.repeat*20,true);
    }

    public long openFiles(){
        OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
        if(os instanceof UnixOperatingSystemMXBean)
            return ((UnixOperatingSystemMXBean) os).getOpenFileDescriptorCount();
        return -1;
    }

}
