package skygreg.Items;

import java.util.Arrays;

public class SkyGregItems {
    public static CustomItem mesh = new MeshItem();
    public static CustomItem oreChunk = new OreChunkItem();

    public SkyGregItems() {
        new ItemGenerator(Arrays.asList(mesh, oreChunk));
    }
}
