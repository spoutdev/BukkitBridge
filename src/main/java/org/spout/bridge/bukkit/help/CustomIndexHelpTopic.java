package org.spout.bridge.bukkit.help;

import java.util.Collection;

import org.bukkit.help.HelpTopic;
import org.bukkit.help.IndexHelpTopic;

public class CustomIndexHelpTopic extends IndexHelpTopic {
	public CustomIndexHelpTopic(String name, String shortText, String permission, Collection<HelpTopic> topics) {
		super(name, shortText, permission, topics);
	}
}
