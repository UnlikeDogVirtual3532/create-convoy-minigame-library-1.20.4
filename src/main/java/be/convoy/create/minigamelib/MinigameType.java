package be.convoy.create.minigamelib;

import be.convoy.create.minigamelib.registry.MinigameRegistry;
import net.minecraft.util.Identifier;

public final class MinigameType {
    private static final MinigameRegistry<MinigameType> registry = MinigameRegistry.create();

    private final Identifier identifier;

    private MinigameType(Identifier identifier) {
        this.identifier = identifier;
    }

    public static MinigameType register(Identifier identifier) {
        MinigameType minigameType = new MinigameType(identifier);
        
        CreateConvoyMinigameLibrary.LOGGER.info("New Minigame Registered: " + minigameType.getIdentifier().toString());
        registry.register(identifier, minigameType);

        return minigameType;
    }

    public static MinigameRegistry<MinigameType> getRegistry() {
        return registry;
    }

    public Identifier getIdentifier() {
        return this.identifier;
    }
}