package securecraftprotect.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import securecraftprotect.SCP;
import securecraftprotect.common.item.ItemArmorClassD;
import securecraftprotect.common.item.ItemSCPDocument;
import securecraftprotect.common.item.ItemSCPKnife;
import securecraftprotect.common.item.ItemSCPPearl;

import static securecraftprotect.init.SCPItems.*;

public class SCPItem {
    public static void init() {
        initMaterials();
        registerItems();
        registerCraft();
    }

    private static void initMaterials() {
        toolMaterial1023 = EnumHelper.addToolMaterial("1023", 0, -1, 0.0F, 9996.0F, 0);
        armorMaterialClassD = EnumHelper.addArmorMaterial("CLASSD", 29, new int[] {2, 7, 5, 3}, 9);
    }

    private static void registerItems() {
        scp1023ARC  = registerItem(new ItemSCPKnife(toolMaterial1023, 0).setUnlocalizedName("scp:1023arc").setCreativeTab(SCP.scpTab));
        gasMask     = registerItem(new ItemArmorClassD(armorMaterialClassD, SCP.proxy.addArmor("CLASSD"), 0).setUnlocalizedName("scp:gas_mask"));
        classDShirt = registerItem(new ItemArmorClassD(armorMaterialClassD, SCP.proxy.addArmor("CLASSD"), 1).setUnlocalizedName("scp:classd_shirt"));
        classDPants = registerItem(new ItemArmorClassD(armorMaterialClassD, SCP.proxy.addArmor("CLASSD"), 2).setUnlocalizedName("scp:classd_pants"));
        classDBoots = registerItem(new ItemArmorClassD(armorMaterialClassD, SCP.proxy.addArmor("CLASSD"), 3).setUnlocalizedName("scp:classd_boots"));
        document    = registerItem(new ItemSCPDocument().setUnlocalizedName("scp:document"));
        pearl       = registerItem(new ItemSCPPearl().setUnlocalizedName("scp:pearl"));
        circuit     = registerItem(new Item().setUnlocalizedName("scp:circuit").setTextureName("scp:circuit"));
    }

    private static void registerCraft() {

    }
    public static Item registerItem(Item item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.scp:", ""), "scp");
        return item;
    }
}
