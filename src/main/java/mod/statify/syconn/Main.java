package mod.statify.syconn;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "statify";
    public static final String VERSION = "1.0";

    public static Config config = new Config();
    public static NECCommand commandManager = new NECCommand(new Subcommand[]{
            new Toggle(),
            new Help()
    });

    @EventHandler
    public void init(FMLInitializationEvent event) {
        config.preload();
        ClientCommandHandler.instance.registerCommand(commandManager);
        MinecraftForge.EVENT_BUS.register(new OnWorldJoin());
        MinecraftForge.EVENT_BUS.register(new ChatReceivedEvent());
    }
}
