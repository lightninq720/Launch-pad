package com.lightninq720.listeners;

import com.lightninq720.LaunchPad;

import lombok.RequiredArgsConstructor;

import org.bukkit.entity.Player;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.util.Vector;

@RequiredArgsConstructor
public class PlayerListener implements Listener{

    private final LaunchPad plugin;
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerMove(PlayerMoveEvent event){
        if (event.getPlayer() == null) return;

        Player player = event.getPlayer();

        Location loc = player.getLocation();
        Location blockLoc = loc.subtract(0,1,0);
        Block block = blockLoc.getBlock();
        if (block == null) return;
        Material mat = block.getType();
        if (mat == null) return;

        if (mat == Material.EMERALD_BLOCK){
            Vector yVector = new Vector(0, 1, 0).normalize().multiply(1.4);
            Vector direction = player.getLocation().getDirection().multiply(new Vector(1,0,1)).normalize().multiply(0.35).add(yVector);
            player.setVelocity(direction);
        }
    }

}
