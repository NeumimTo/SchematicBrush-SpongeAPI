package com.mikeprimm.schematicbrush.adapter;

import com.sk89q.worldedit.entity.Player;

import java.util.Optional;

/**
 * @author dags <dags@dags.me>
 */
public class DummyAdapter implements Adapter {
    @Override
    public boolean isPresent() {
        return false;
    }

    @Override
    public Optional<Player> wrapPlayer(org.spongepowered.api.entity.living.player.Player player) {
        return Optional.empty();
    }
}
