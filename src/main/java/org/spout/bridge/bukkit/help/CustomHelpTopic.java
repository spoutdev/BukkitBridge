package org.spout.bridge.bukkit.help;

import org.bukkit.command.CommandSender;
import org.bukkit.help.HelpTopic;

public class CustomHelpTopic extends HelpTopic {
	@Override
	public boolean canSee(CommandSender commandSender) {
		throw new UnsupportedOperationException();
	}
}
