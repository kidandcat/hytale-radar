package com.radar;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.event.events.player.PlayerConnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerDisconnectEvent;

/**
 * Hytale Radar Mod
 *
 * Shows all players on the HUD compass (the top bar where portals,
 * death markers, etc. appear) with real-time position updates.
 *
 * This is always enabled for all players - no commands needed.
 */
public class RadarPlugin extends JavaPlugin {

    private static RadarPlugin instance;
    private PlayerRadarSystem radarSystem;

    public RadarPlugin(JavaPluginInit init) {
        super(init);
        instance = this;
    }

    @Override
    protected void setup() {
        System.out.println("[Radar] Setting up Hytale Radar mod...");

        // Initialize the player radar system
        radarSystem = new PlayerRadarSystem(this);

        // Register event listeners for player connect/disconnect
        getEventRegistry().register(PlayerConnectEvent.class, event -> {
            radarSystem.onPlayerConnect(event);
        });

        getEventRegistry().register(PlayerDisconnectEvent.class, event -> {
            radarSystem.onPlayerDisconnect(event);
        });

        System.out.println("[Radar] Player radar initialized");
    }

    @Override
    protected void start() {
        System.out.println("[Radar] Hytale Radar v1.0.0 loaded!");
        System.out.println("[Radar] Players now visible on HUD compass");

        // Start the radar update loop
        radarSystem.start();
    }

    @Override
    protected void shutdown() {
        System.out.println("[Radar] Shutting down...");
        if (radarSystem != null) {
            radarSystem.stop();
        }
    }

    public static RadarPlugin getInstance() {
        return instance;
    }

    public PlayerRadarSystem getRadarSystem() {
        return radarSystem;
    }
}
