package kr.dyoh1379.chuseok.ItemStacks;

import kr.dyoh1379.chuseok.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

public class SongPyeons {

    public static Main plugin = Main.getInstance();

    public static ItemStack WHITE() {
        ItemStack itemStack = new ItemStack(Material.WHITE_DYE, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName("§f§l하얀 송편");
        itemMeta.setCustomModelData(1);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack RED() {
        ItemStack itemStack = new ItemStack(Material.RED_DYE, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName("§c§l빨간 송편");
        itemMeta.setCustomModelData(1);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack GREEN() {
        ItemStack itemStack = new ItemStack(Material.GREEN_DYE, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName("§2§l초록 송편");
        itemMeta.setCustomModelData(1);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack YELLOW() {
        ItemStack itemStack = new ItemStack(Material.YELLOW_DYE, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName("§e§l노란 송편");
        itemMeta.setCustomModelData(1);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack SET() {
        ItemStack itemStack = new ItemStack(Material.BOWL, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName("§f§l송§c§l편 §2§l세§e§l트");
        itemMeta.setCustomModelData(1);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static void addRecipeSet() {
        NamespacedKey key = new NamespacedKey(plugin, "songpyeon_set");
        ShapelessRecipe setRecipe = new ShapelessRecipe(key, SongPyeons.SET());

        // 하얀 송편, 빨간 송편, 초록 송편, 노란 송편
        setRecipe.addIngredient(new RecipeChoice.ExactChoice(WHITE()));
        setRecipe.addIngredient(new RecipeChoice.ExactChoice(RED()));
        setRecipe.addIngredient(new RecipeChoice.ExactChoice(GREEN()));
        setRecipe.addIngredient(new RecipeChoice.ExactChoice(YELLOW()));

        Bukkit.getServer().addRecipe(setRecipe);
    }

    public static void removeRecipeSet() {
        NamespacedKey key = new NamespacedKey(plugin, "songpyeon_set");
        Bukkit.getServer().removeRecipe(key);
    }


    public static void addRecipeWhite() {
        NamespacedKey key = new NamespacedKey(plugin, "white_songpyeon");
        ShapelessRecipe whiteRecipe = new ShapelessRecipe(key, SongPyeons.WHITE());

        // 밀, 감자, 당근, 사탕무, 호박, 수박, 사과
        whiteRecipe.addIngredient(Material.WHEAT, 1);
        whiteRecipe.addIngredient(Material.POTATO, 1);
        whiteRecipe.addIngredient(Material.CARROT, 1);
        whiteRecipe.addIngredient(Material.BEETROOT, 1);
        whiteRecipe.addIngredient(Material.PUMPKIN, 1);
        whiteRecipe.addIngredient(Material.MELON_SLICE, 1);
        whiteRecipe.addIngredient(Material.APPLE, 1);

        Bukkit.getServer().addRecipe(whiteRecipe);
    }

    public static void addRecipeRed() {
        NamespacedKey key = new NamespacedKey(plugin, "red_songpyeon");
        ShapelessRecipe redRecipe = new ShapelessRecipe(key, SongPyeons.RED());

        // 빨간 버섯, 갈색 버섯, 진홍빛 균, 뒤틀린 균, 네더 사마귀
        redRecipe.addIngredient(Material.RED_MUSHROOM, 1);
        redRecipe.addIngredient(Material.BROWN_MUSHROOM, 1);
        redRecipe.addIngredient(Material.CRIMSON_FUNGUS, 1);
        redRecipe.addIngredient(Material.WARPED_FUNGUS, 1);
        redRecipe.addIngredient(Material.NETHER_WART, 1);

        Bukkit.getServer().addRecipe(redRecipe);
    }

    public static void addRecipeGreen() {
        NamespacedKey key = new NamespacedKey(plugin, "green_songpyeon");
        ShapelessRecipe greenRecipe = new ShapelessRecipe(key, SongPyeons.GREEN());

        // 코코아, 켈프, 대나무, 선인장
        greenRecipe.addIngredient(Material.COCOA_BEANS, 1);
        greenRecipe.addIngredient(Material.KELP, 1);
        greenRecipe.addIngredient(Material.BAMBOO, 1);
        greenRecipe.addIngredient(Material.CACTUS, 1);

        Bukkit.getServer().addRecipe(greenRecipe);
    }

    public static void addRecipeYellow() {
        NamespacedKey key = new NamespacedKey(plugin, "yellow_songpyeon");
        ShapelessRecipe yellowRecipe = new ShapelessRecipe(key, SongPyeons.YELLOW());

        // 발광 열매, 달콤한 열매, 후렴과
        yellowRecipe.addIngredient(Material.GLOW_BERRIES, 1);
        yellowRecipe.addIngredient(Material.SWEET_BERRIES, 1);
        yellowRecipe.addIngredient(Material.CHORUS_FRUIT, 1);

        Bukkit.getServer().addRecipe(yellowRecipe);
    }

    public static void removeRecipeWhite() {
        NamespacedKey key = new NamespacedKey(plugin, "white_songpyeon");
        Bukkit.getServer().removeRecipe(key);
    }

    public static void removeRecipeRed() {
        NamespacedKey key = new NamespacedKey(plugin, "red_songpyeon");
        Bukkit.getServer().removeRecipe(key);
    }

    public static void removeRecipeGreen() {
        NamespacedKey key = new NamespacedKey(plugin, "green_songpyeon");
        Bukkit.getServer().removeRecipe(key);
    }

    public static void removeRecipeYellow() {
        NamespacedKey key = new NamespacedKey(plugin, "yellow_songpyeon");
        Bukkit.getServer().removeRecipe(key);
    }
}
