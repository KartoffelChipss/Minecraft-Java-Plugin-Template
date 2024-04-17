package org.strassburger.templateplugin.util;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomItem {
    private final ItemStack itemStack;

    public CustomItem(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public CustomItem(Material material) {
        this.itemStack = new ItemStack(material);
    }

    public CustomItem() {
        this.itemStack = new ItemStack(Material.AIR);
    }

    public CustomItem setMaterial(Material material) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        int amount = itemStack.getAmount();
        ItemStack newItemStack = new ItemStack(material, amount);
        newItemStack.setItemMeta(itemMeta);
        return this;
    }

    public CustomItem setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public CustomItem setName(String name) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(MessageUtils.formatMsg(name));
        itemStack.setItemMeta(itemMeta);

        return this;
    }

    public CustomItem setCustomModelID(int customModelID) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(customModelID);
        itemStack.setItemMeta(itemMeta);

        return this;
    }

    public CustomItem setLore(List<String> lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<Component> newLore = new ArrayList<>(lore.size());
        for (int i = 0; i < lore.size(); i++) {
            newLore.set(i, MessageUtils.formatMsg(lore.get(i)));
        }
        itemMeta.lore(newLore);
        itemStack.setItemMeta(itemMeta);

        return this;
    }

    public CustomItem addLore(String lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<Component> newLore = new ArrayList<>(Objects.requireNonNull(itemMeta.lore()));
        newLore.add(MessageUtils.formatMsg(lore));
        itemMeta.lore(newLore);
        itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
