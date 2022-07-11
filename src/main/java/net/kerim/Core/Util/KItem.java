package net.kerim.Core.Util;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class KItem {
    private final Material material;
    private final String displayName;
    private final String[] lore;
    private final int modelData;

    public KItem(Material material, String displayName, int modelData, String... lore) {
        this.material = material;
        this.displayName = displayName;
        this.modelData = modelData;
        this.lore = lore;
    }

    public KItem(Material material, String displayName, int modelData) {
        this.material = material;
        this.displayName = displayName;
        this.modelData = modelData;
        this.lore = new String[]{" "};
    }

    public KItem(Material material, String displayName, String... lore) {
        this.material = material;
        this.displayName = displayName;
        this.modelData = 0;
        this.lore = lore;
    }

    public KItem(Material material, String displayName) {
        this.material = material;
        this.displayName = displayName;
        this.modelData = 0;
        this.lore = new String[]{" "};
    }

    public KItem(boolean isFiller) {
        this.material = Material.BLACK_STAINED_GLASS_PANE;
        this.displayName = " ";
        this.modelData = 0;
        this.lore = new String[]{" "};
    }

    public ItemStack getItemStack() {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(displayName);
        if (lore!=null) meta.setLore(List.of(lore));
        if (modelData != 0) meta.setCustomModelData(modelData);
        else meta.setCustomModelData(99);

        item.setItemMeta(meta);

        return item;
    }

    public GuiItem getGuiItem() {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(displayName);
        if (lore!=null) meta.setLore(List.of(lore));
        if (modelData != 0) meta.setCustomModelData(modelData);
        else meta.setCustomModelData(99);

        item.setItemMeta(meta);

        return new GuiItem(item);
    }


}
