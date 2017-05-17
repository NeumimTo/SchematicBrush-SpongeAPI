package com.mikeprimm.schematicbrush.adapter;

import java.util.Optional;

/**
 * @author dags <dags@dags.me>
 */
public class AdapterFactory {

    public static Adapter getAdapter() {
        Adapter forge = get("com.sk89q.worldedit.forge.ForgeWorldEdit", "com.mikeprimm.schematicbrush.adapter.ForgeAdapter");
        if (forge != null) {
            return forge;
        }

        Adapter sponge = get("com.sk89q.worldedit.sponge.SpongeWorldEdit", "com.mikeprimm.schematicbrush.adapter.SpongeAdapter");
        if (sponge != null) {
            return sponge;
        }

        return player -> Optional.empty();
    }

    private static Adapter get(String testFor, String adapter) {
        try {
            Class.forName(testFor);
            Class<?> target = Class.forName(adapter);
            return Adapter.class.cast(target.newInstance());
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }
}
