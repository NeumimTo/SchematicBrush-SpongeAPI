package com.mikeprimm.schematicbrush.adapter;

import com.sk89q.worldedit.entity.Player;

import java.util.Optional;

/**
 * @author dags <dags@dags.me>
 */
public interface Adapter {

    boolean isPresent();

    Optional<Player> wrapPlayer(org.spongepowered.api.entity.living.player.Player player);
}
