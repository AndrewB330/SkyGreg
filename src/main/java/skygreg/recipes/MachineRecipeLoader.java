package skygreg.recipes;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OreDictNames;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import skygreg.machines.SkyGregMachines;

public class MachineRecipeLoader {
    private static final long bits = GT_ModHandler.RecipeBits.NOT_REMOVABLE |
            GT_ModHandler.RecipeBits.REVERSIBLE |
            GT_ModHandler.RecipeBits.BUFFERED;

    public MachineRecipeLoader() {
        GT_ModHandler.addCraftingRecipe(SkyGregMachines.machineSieveBronze, bits,
                new Object[]{
                        "SSS", "PMP", "XXX",
                        'M', ItemList.Hull_Bronze_Bricks,
                        'X', OrePrefixes.pipeSmall.get(Materials.Bronze),
                        'S', new ItemStack(Items.string, 1),
                        'P', OreDictNames.craftingPiston
                }
        );
        GT_ModHandler.addCraftingRecipe(SkyGregMachines.machineSieveSteel, bits,
                new Object[]{
                        "SSS", "PMP", "XXX",
                        'M', ItemList.Hull_Steel_Bricks,
                        'X', OrePrefixes.pipeSmall.get(Materials.Steel),
                        'S', new ItemStack(Items.string, 1),
                        'P', OreDictNames.craftingPiston
                }
        );

        GT_ModHandler.addCraftingRecipe(SkyGregMachines.machineWaterGeneratorLV, bits,
                new Object[]{
                        "SXS", "PMP", "XXX",
                        'M', ItemList.Hull_Steel_Bricks,
                        'X', OrePrefixes.pipeSmall.get(Materials.Steel),
                        'S', new ItemStack(Items.string, 1),
                        'P', OreDictNames.craftingPiston
                }
        );
    }
}
