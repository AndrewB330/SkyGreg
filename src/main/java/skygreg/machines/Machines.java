package skygreg.machines;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OreDictNames;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Machines {

    public static ItemStack machineSieveBronze;
    public static ItemStack machineSieveSteel;
    public static ItemStack machineSieveLV;
    public static ItemStack machineSieveMV;
    public static ItemStack machineSieveHV;
    public static ItemStack machineSieveEV;
    public static ItemStack machineSieveIV;
    public static ItemStack machineSieveLuV;
    public static ItemStack machineSieveZPM;
    public static ItemStack machineSieveUV;

    public Machines() {
        machineSieveBronze = new MachineSieveBronze(24000, "bronzemachine.sieve", "Steam Sieve").getStackForm(1);
        machineSieveSteel = new MachineSieveSteel(24001, "steelmachine.sieve", "High Pressure Sieve").getStackForm(1);
        machineSieveLV = new MachineSieveElectric(24001, 1).getStackForm(1);
        machineSieveMV = new MachineSieveElectric(24002, 2).getStackForm(1);
        machineSieveHV = new MachineSieveElectric(24003, 3).getStackForm(1);
        machineSieveEV = new MachineSieveElectric(24004, 4).getStackForm(1);
        machineSieveIV = new MachineSieveElectric(24005, 5).getStackForm(1);
        machineSieveLuV = new MachineSieveElectric(24006, 6).getStackForm(1);
        machineSieveZPM = new MachineSieveElectric(24007, 7).getStackForm(1);
        machineSieveUV = new MachineSieveElectric(24008, 8).getStackForm(1);
    }

}
