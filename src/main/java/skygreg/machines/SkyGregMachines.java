package skygreg.machines;

import net.minecraft.item.ItemStack;

public class SkyGregMachines {

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

    public static ItemStack machineWaterGeneratorLV;
    public static ItemStack machineWaterGeneratorMV;
    public static ItemStack machineWaterGeneratorHV;
    public static ItemStack machineWaterGeneratorEV;
    public static ItemStack machineWaterGeneratorIV;
    public static ItemStack machineWaterGeneratorLuV;
    public static ItemStack machineWaterGeneratorZPM;
    public static ItemStack machineWaterGeneratorUV;

    public static ItemStack machineLavaGeneratorLV;
    public static ItemStack machineLavaGeneratorMV;
    public static ItemStack machineLavaGeneratorHV;
    public static ItemStack machineLavaGeneratorEV;
    public static ItemStack machineLavaGeneratorIV;
    public static ItemStack machineLavaGeneratorLuV;
    public static ItemStack machineLavaGeneratorZPM;
    public static ItemStack machineLavaGeneratorUV;

    public SkyGregMachines() {

        machineSieveBronze = new MachineSieveBronze(23999, "bronzemachine.sieve", "Steam Sieve").getStackForm(1);
        machineSieveSteel = new MachineSieveSteel(24000, "steelmachine.sieve", "High Pressure Sieve").getStackForm(1);
        machineSieveLV = new MachineSieveElectric(24001, 1).getStackForm(1);
        machineSieveMV = new MachineSieveElectric(24002, 2).getStackForm(1);
        machineSieveHV = new MachineSieveElectric(24003, 3).getStackForm(1);
        machineSieveEV = new MachineSieveElectric(24004, 4).getStackForm(1);
        machineSieveIV = new MachineSieveElectric(24005, 5).getStackForm(1);
        machineSieveLuV = new MachineSieveElectric(24006, 6).getStackForm(1);
        machineSieveZPM = new MachineSieveElectric(24007, 7).getStackForm(1);
        machineSieveUV = new MachineSieveElectric(24008, 8).getStackForm(1);

        machineWaterGeneratorLV = new MachineWaterGenerator(24011, 1).getStackForm(1);
        machineWaterGeneratorMV = new MachineWaterGenerator(24012, 2).getStackForm(1);
        machineWaterGeneratorHV = new MachineWaterGenerator(24013, 3).getStackForm(1);
        machineWaterGeneratorEV = new MachineWaterGenerator(24014, 4).getStackForm(1);
        machineWaterGeneratorIV = new MachineWaterGenerator(24015, 5).getStackForm(1);
        machineWaterGeneratorLuV = new MachineWaterGenerator(24016, 6).getStackForm(1);
        machineWaterGeneratorZPM = new MachineWaterGenerator(24017, 7).getStackForm(1);
        machineWaterGeneratorUV = new MachineWaterGenerator(24018, 8).getStackForm(1);

        machineLavaGeneratorLV = new MachineLavaGenerator(24021, 1).getStackForm(1);
        machineLavaGeneratorMV = new MachineLavaGenerator(24022, 2).getStackForm(1);
        machineLavaGeneratorHV = new MachineLavaGenerator(24023, 3).getStackForm(1);
        machineLavaGeneratorEV = new MachineLavaGenerator(24024, 4).getStackForm(1);
        machineLavaGeneratorIV = new MachineLavaGenerator(24025, 5).getStackForm(1);
        machineLavaGeneratorLuV = new MachineLavaGenerator(24026, 6).getStackForm(1);
        machineLavaGeneratorZPM = new MachineLavaGenerator(24027, 7).getStackForm(1);
        machineLavaGeneratorUV = new MachineLavaGenerator(24028, 8).getStackForm(1);
    }

}
