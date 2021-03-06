package securecraftprotect.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.model.ModelBlaze;
import net.minecraftforge.common.MinecraftForge;
import securecraftprotect.client.gui.SCPGuiBlink;
import securecraftprotect.client.model.ModelClassDMale;
import securecraftprotect.client.model.ModelSCP0023;
import securecraftprotect.client.model.ModelSCP0131;
import securecraftprotect.client.model.ModelSCP0173;
import securecraftprotect.client.renderer.entity.*;
import securecraftprotect.client.renderer.tile.RenderTileChair;
import securecraftprotect.client.renderer.tile.RenderTileDesk;
import securecraftprotect.client.renderer.tile.RenderTileLightBulb;
import securecraftprotect.client.renderer.tile.RenderTileSCP0015;
import securecraftprotect.common.CommonProxy;
import securecraftprotect.common.entity.boss.EntitySCP0015;
import securecraftprotect.common.entity.monster.EntitySCP0023;
import securecraftprotect.common.entity.monster.EntitySCP0173;
import securecraftprotect.common.entity.passive.EntityClassDMale;
import securecraftprotect.common.entity.passive.EntitySCP0131;
import securecraftprotect.common.handlers.SCPInputHandler;
import securecraftprotect.common.tileentity.TileEntityLightBulb;

import static securecraftprotect.util.Globals.RENDER_CHAIR;
import static securecraftprotect.util.Globals.RENDER_DESK;
import static securecraftprotect.util.Globals.RENDER_PIPE;

public class ClientProxy extends CommonProxy
{
    
    @Override
    public void init()
    {
        super.init();
        render();
        // MinecraftForge.EVENT_BUS.register(new SCPGuiBlink());
        // FMLCommonHandler.instance().bus().register(new SCPInputHandler());
    }
    
    private void render()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityClassDMale.class, new RenderClassDMale(new ModelClassDMale(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySCP0023.class, new RenderSCP0023(new ModelSCP0023(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySCP0131.class, new RenderSCP0131(new ModelSCP0131(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySCP0173.class, new RenderSCP0173(new ModelSCP0173(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySCP0015.class, new RenderSCP0015(new ModelBlaze(), 0.0F));
        RENDER_PIPE = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(RENDER_PIPE, new RenderTileSCP0015());
        RENDER_DESK = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(RENDER_DESK, new RenderTileDesk());
        RENDER_CHAIR = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(RENDER_CHAIR, new RenderTileChair());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLightBulb.class, new RenderTileLightBulb());  
    }
    
    public int addArmor(String armor)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
}
