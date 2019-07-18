package skygreg.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.items.GT_MetaGenerated_Item;
import gregtech.api.util.GT_LanguageManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;


public class ItemGenerator extends GT_MetaGenerated_Item {

    protected static final int materialsNumber = GregTech_API.sGeneratedMaterials.length;
    protected static final int itemsNumber = 20;

    private static ItemStack[] itemStacks = new ItemStack[itemsNumber * materialsNumber];
    private static boolean[] used = new boolean[itemsNumber * materialsNumber];
    private static CustomItem[] items = new CustomItem[itemsNumber];

    public ItemGenerator(List<CustomItem> itemsList) {
        super("skygreg.item", (short) (itemsNumber * materialsNumber), (short) 0);
        for (CustomItem item : itemsList) {
            items[item.getItemId()] = item;
            for (int i = 0; i < materialsNumber; i++) {
                Materials material = GregTech_API.sGeneratedMaterials[i];
                if (material == null) continue;
                if (!item.doGenerateItem(material)) continue;
                int metaData = i + item.getItemId() * materialsNumber;
                ItemStack itemStack = new ItemStack(this, 1, metaData);
                itemStacks[metaData] = itemStack;
                used[metaData] = false;
                GT_LanguageManager.addStringLocalization(
                        getUnlocalizedName(itemStack) + ".tooltip",
                        material.getToolTip(1)
                );
            }
            item.loadTextures();
        }
    }

    public static boolean markAsUsed(int metaData) {
        if (!used[metaData]) {
            used[metaData] = true;
            int itemId = metaData / materialsNumber;
            int materialId = metaData % materialsNumber;
            items[itemId].registerMaterial(GregTech_API.sGeneratedMaterials[materialId], get(metaData));
        }
        return false;
    }

    public static ItemStack get(int metaData) {
        return itemStacks[metaData];
    }

    @Override
    public short[] getRGBa(ItemStack aStack) {
        Materials tMaterial = GregTech_API.sGeneratedMaterials[getDamage(aStack) % materialsNumber];
        return tMaterial == null ? Materials._NULL.mRGBa : tMaterial.mRGBa;
    }

    @Override
    public String getItemStackDisplayName(ItemStack aStack) {
        int metaData = getDamage(aStack);
        int itemId = metaData / materialsNumber;
        int materialId = metaData % materialsNumber;
        return GregTech_API.sGeneratedMaterials[materialId].toString() + " " + items[itemId].getName();
    }

    @Override
    public final IIconContainer getIconContainer(int aMetaData) {
        int itemId = aMetaData / materialsNumber;
        int materialId = aMetaData % materialsNumber;
        if (GregTech_API.sGeneratedMaterials[materialId] == null)
            return null;
        return GregTech_API.sGeneratedMaterials[materialId].mIconSet.mTextures[items[itemId].getTextureId()];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public final void getSubItems(Item var1, CreativeTabs aCreativeTab, List aList) {
        super.getSubItems(var1, aCreativeTab, aList);
        for (int i = 0; i < itemsNumber; i++) {
            if (items[i] == null) continue;
            for (int j = 0; j < materialsNumber; j++) {
                Materials material = GregTech_API.sGeneratedMaterials[i];
                if (material == null) continue;
                if (items[i].doGenerateItem(material) && used[i * materialsNumber + j]) {
                    aList.add(itemStacks[i * materialsNumber + j]);
                }
            }
        }
    }

    @Override
    public final IIcon getIconFromDamage(int aMetaData) {
        IIconContainer tIcon = getIconContainer(aMetaData);
        if (tIcon != null)
            return tIcon.getIcon();
        return null;
    }

    @Override
    public int getItemStackLimit(ItemStack aStack) {
        return items[getDamage(aStack) / materialsNumber].getItemStackLimit();
    }
}
