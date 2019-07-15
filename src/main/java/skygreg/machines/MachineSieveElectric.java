package skygreg.machines;

import gregtech.api.enums.OreDictNames;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine_GT_Recipe;
import skygreg.recipes.Recipes;

public class MachineSieveElectric extends GT_MetaTileEntity_BasicMachine_GT_Recipe {
    private static final String[] nameByTier = {
            "Empty",
            "Basic Sieve",
            "Advanced Sieve",
            "Advanced Sieve II",
            "Turbo Sieve",
            "Turbo Sieve II",
            "Sieve-O-Tron 2000",
            "Sieve-O-Tron 3000",
            "Sieve-O-Tron X"
    };

    MachineSieveElectric(int aId, int tier) {
        super(
                aId,
                "basicmachine.mesh.tier.0" + tier,
                nameByTier[tier],
                tier,
                "Produces ores",
                Recipes.sSieveRecipes,
                2, 9,
                0,
                0, 1,
                "Sieve.png", "",
                false, false,
                0,
                "SIEVE",
                new Object[]{
                        "WTW",
                        "EME",
                        "CTC",
                        'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL,
                        'E', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR,
                        'C', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CIRCUIT,
                        'W', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.WIRE,
                        'T', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR,
                        'D', OreDictNames.craftingIndustrialDiamond
                });
    }
}
