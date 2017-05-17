package com.mikeprimm.schematicbrush.adapter;

import com.sk89q.worldedit.entity.Player;
import com.sk89q.worldedit.forge.ForgeWorldEdit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

/**
 * @author dags <dags@dags.me>
 */
public class ForgeAdapter implements Adapter {

    private final Method wrap;

    public ForgeAdapter() {
        Method wrap;
        try {
            wrap = ForgeWorldEdit.class.getDeclaredMethod("wrap");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            wrap = null;
        }
        this.wrap = wrap;
    }

    @Override
    public Optional<Player> wrapPlayer(org.spongepowered.api.entity.living.player.Player player) {
        if (wrap != null) {
            try {
                // Not the best, but saves having to depend on forge/minecraft source to call ForgeWorldEdit.wrap(EntityPlayerMP)
                // Sponge's Player interface is 'mixed into' EntityPlayerMP so this invocation should be valid
                Object wrapped = wrap.invoke(ForgeWorldEdit.inst, player);
                if (wrapped != null) {
                    return Optional.of(Player.class.cast(wrapped));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }
}
