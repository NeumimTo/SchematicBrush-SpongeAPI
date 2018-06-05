package com.mikeprimm.schematicbrush.adapter;

import com.sk89q.worldedit.entity.Player;
import com.sk89q.worldedit.sponge.SpongeWorldEdit;

import java.util.Optional;

/**
 * @author dags <dags@dags.me>
 */
public class SpongeAdapter implements Adapter {

    @Override
    public boolean isPresent() {
        return true;
    }

    @Override
    public Optional<Player> wrapPlayer(org.spongepowered.api.entity.living.player.Player player) {
        return Optional.of(SpongeWorldEdit.inst().wrapPlayer(player));
    }
}
