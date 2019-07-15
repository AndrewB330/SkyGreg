package skygreg.Items;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TextureSet;
import gregtech.api.enums.Textures.ItemIcons.CustomIcon;
import net.minecraft.item.ItemStack;

import java.util.HashSet;

public abstract class CustomItem {

    private static int counter = 0;
    private int itemId;
    private String name;
    private String textureName;

    private final static String aTextMatIconDir = "materialicons/";

    CustomItem(String name, String textureName) {
        this.itemId = counter++;
        this.name = name;
        this.textureName = textureName;
    }

    public abstract void registerMaterial(Materials material);

    public abstract boolean doGenerateItem(Materials material);

    public abstract int getItemStackLimit();

    public ItemStack get(Materials material) {
        return ItemGenerator.get(getMetaData(material));
    }

    public ItemStack getAndMarkUsed(Materials material) {
        ItemGenerator.markAsUsed(getMetaData(material));
        return ItemGenerator.get(getMetaData(material));
    }

    private int getMetaData(Materials material) {
        return material.mMetaItemSubID + itemId * GregTech_API.sGeneratedMaterials.length;
    }

    public int getTextureId() {
        return 125 - itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public void loadTextures() {
        HashSet<TextureSet> done = new HashSet<>();
        for (int i = 0; i < GregTech_API.sGeneratedMaterials.length; i++) {
            if (!doGenerateItem(GregTech_API.sGeneratedMaterials[i])) continue;
            TextureSet textureSet = GregTech_API.sGeneratedMaterials[i].mIconSet;
            if (!done.contains(textureSet)) {
                done.add(textureSet);
                String texturePath = aTextMatIconDir + textureSet.mSetName + "/" + textureName;
                textureSet.mTextures[getTextureId()] = new CustomIcon(texturePath);
            }
        }
    }
}
