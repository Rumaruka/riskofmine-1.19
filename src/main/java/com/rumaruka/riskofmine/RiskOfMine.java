package com.rumaruka.riskofmine;


import com.mojang.brigadier.CommandDispatcher;
import com.rumaruka.riskofmine.client.ROMEntityRegister;
import com.rumaruka.riskofmine.client.render.layer.LayerMonsterTooth;
import com.rumaruka.riskofmine.client.screen.BaseScreen;
import com.rumaruka.riskofmine.client.screen.BaseShopScreen;
import com.rumaruka.riskofmine.client.screen.overlay.ROMOverlayRender;
import com.rumaruka.riskofmine.common.config.ROMConfig;
import com.rumaruka.riskofmine.init.ROMContainerTypes;
import com.rumaruka.riskofmine.init.ROMFeatures;
import com.rumaruka.riskofmine.ntw.ROMNetwork;
import com.rumaruka.riskofmine.ntw.cmd.MoneyAddCommand;
import com.rumaruka.riskofmine.ntw.cmd.MoneySetCommand;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.timeconqueror.timecore.api.TimeCoreAPI;
import ru.timeconqueror.timecore.api.client.resource.location.TextureLocation;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import static com.rumaruka.riskofmine.RiskOfMine.MODID;

@Mod(MODID)
public class RiskOfMine {
    private static RiskOfMine instance;
    public static final String MODID = "riskofmine";
    public static final Logger logger = LogManager.getLogger(MODID);

    private static final ModList MOD_LIST = ModList.get();

    public RiskOfMine() {
        instance = this;
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        TimeCoreAPI.setup(this);
        eventBus.addListener(this::setup);
        eventBus.addListener(this::enqueueIMC);
        // ROMSounds.REGISTER.register(eventBus);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            // Client setup
            eventBus.addListener(this::clientSetup);

        });
        eventBus.addListener(ROMOverlayRender::registerKeys);
        logger.info("Network Risk Of Mine setuping");
        ROMNetwork.setup();

//        ROMParticles.PARTICLES.register(eventBus);
//        ROMEffects.EFFECTS.register(eventBus);
//        ROMEffects.POTIONS.register(eventBus);
        ROMFeatures.registerFeatures();

    }


    private void setup(final FMLCommonSetupEvent event) {
//        MinecraftForge.EVENT_BUS.register(new GenerationEventHandler());
        if (MOD_LIST.isLoaded("jeresources")) {
            // ROMJerPlugin.setup(event);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void clientSetup(final FMLClientSetupEvent event) {

//
        MenuScreens.register(ROMContainerTypes.SMALL_CHEST, BaseScreen::new);
//        MenuScreens.register(ROMContainerTypes.LARGE_CHEST, BaseScreen::new);
//        MenuScreens.register(ROMContainerTypes.LEGENDARY_CHEST, BaseScreen::new);
//        MenuScreens.register(ROMContainerTypes.LUNAR_CHEST, BaseScreen::new);


        MenuScreens.register(ROMContainerTypes.MULTI_SHOP, BaseShopScreen::new);
//        MenuScreens.register(ROMContainerTypes.EQUIPMENT_TRIPLE_BARREL, BaseShopScreen::new);
//
        ROMEntityRegister.renderEntity();


    }
    @SubscribeEvent
    public static void onRegisterCommandEvent(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        MoneyAddCommand.register(dispatcher);
        MoneySetCommand.register(dispatcher);

    }

    private void enqueueIMC(InterModEnqueueEvent event) {
        for (SlotTypePreset preset : SlotTypePreset.values()) {
            InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> preset.getMessageBuilder().size(ROMConfig.GENERAL.sizeCurio.get()).build());
        }


    }

    @SubscribeEvent
    public static void renderItemHud(RenderPlayerEvent event) {
        PlayerRenderer playerRenderer = event.getRenderer();

       playerRenderer.addLayer(new LayerMonsterTooth(playerRenderer));



    }

    public static RiskOfMine instance() {
        return instance;
    }

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MODID, path);
    }

    public static TextureLocation tl(String path) {
        return new TextureLocation(RiskOfMine.MODID, path);
    }
}
