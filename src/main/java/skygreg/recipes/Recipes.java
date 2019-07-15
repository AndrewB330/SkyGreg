package skygreg.recipes;

import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Recipe.GT_Recipe_Map;

import java.util.HashSet;

import static gregtech.api.enums.GT_Values.E;
import static gregtech.api.enums.GT_Values.RES_PATH_GUI;

public class Recipes {
    public static final GT_Recipe_Map sSieveRecipes = new GT_Recipe_Map(new HashSet<GT_Recipe>(400), "gt.recipe.mesh", "Sieve", null, RES_PATH_GUI + "basicmachines/Sieve", 2, 9, 2, 0, 1, E, 1, E, true, true);

    public Recipes() {
        new SieveRecipeLoader();
        new MachineRecipeLoader();
    }
}
