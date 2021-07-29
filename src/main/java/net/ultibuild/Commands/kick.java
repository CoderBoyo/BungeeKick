package net.ultibuild.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class kick extends Command {
    public kick() {
        super("kick");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            if(args.length >= 2) {
                try {
                    ProxiedPlayer p = ProxyServer.getInstance().getPlayer(args[0]);
                    TextComponent text = new TextComponent("");
                    for(int i = 1; i < args.length; i++) {
                        TextComponent reason = new TextComponent(ChatColor.translateAlternateColorCodes('&',args[i] + " "));
                        text.addExtra(reason);
                    }
                    text.setColor(ChatColor.RED);
                    p.disconnect(text);
                    System.out.println("Successfully kicked user " + p.getDisplayName() + " for reason: " + text.toPlainText());
                } catch (Throwable ie) {
                    System.out.println("An error occured processing kick!");
                }
            } else {
                System.out.println("Not enough args for kick! (/kick <playername> <reason>)");
            }
        }
    }
}