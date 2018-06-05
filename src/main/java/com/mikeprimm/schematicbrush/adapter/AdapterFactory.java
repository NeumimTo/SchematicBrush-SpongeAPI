package com.mikeprimm.schematicbrush.adapter;

/**
 * @author dags <dags@dags.me>
 */
public class AdapterFactory {

    public static final Adapter DUMMY = new DummyAdapter();

    public static Adapter getAdapter() {
        Adapter forge = get("com.sk89q.worldedit.forge.ForgeWorldEdit", "com.mikeprimm.schematicbrush.adapter.ForgeAdapter");
        if (forge != null && forge.isPresent()) {
            return forge;
        }

        Adapter sponge = get("com.sk89q.worldedit.sponge.SpongeWorldEdit", "com.mikeprimm.schematicbrush.adapter.SpongeAdapter");
        if (sponge != null && sponge.isPresent()) {
            return sponge;
        }

        return DUMMY;
    }

    private static Adapter get(String testFor, String adapter) {
        try {
            Class.forName(testFor);
            Class<?> target = Class.forName(adapter);
            return Adapter.class.cast(target.newInstance());
        } catch (Throwable t) {
            return null;
        }
    }
}
