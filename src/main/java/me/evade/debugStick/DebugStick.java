package me.evade.debugStick;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.SmithingTransformRecipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.plugin.java.JavaPlugin;

public final class DebugStick extends JavaPlugin {
    @Override
    public void onEnable() {
        registerDebugStickSmithingRecipe();
    }

    private void registerDebugStickSmithingRecipe() {
        NamespacedKey key = new NamespacedKey(this, "debug_stick");
        ItemStack debugStick = new ItemStack(Material.DEBUG_STICK);
        RecipeChoice.MaterialChoice template = new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        RecipeChoice.MaterialChoice baseItem = new RecipeChoice.MaterialChoice(Material.STICK);
        RecipeChoice.MaterialChoice addition = new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT);
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(
                key,
                debugStick,
                template,
                baseItem,
                addition
        );
        Bukkit.addRecipe(recipe);
        getLogger().warning("Registered Debug Stick recipe.");
    }
    @Override
    public void onDisable() {
        getLogger().warning("Debug Stick recipe has been disabled.");
    }
}