package cn.leomc.languageutils;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class LanguageUtils extends JavaPlugin {

    private static final HashMap<Plugin, PluginLanguageProvider> LANGUAGE_PROVIDERS = new HashMap<>();

    public static void register(Plugin plugin, PluginLanguageProvider pluginLanguageProvider) {
        LANGUAGE_PROVIDERS.put(plugin, pluginLanguageProvider);
    }

    public static HashMap<Plugin, PluginLanguageProvider> getLanguageProviders() {
        return LANGUAGE_PROVIDERS;
    }

    public static String getMessage(Plugin plugin, Language language, String key, Language fallbackLanguage, String fallbackString) {
        String message = getMessage(plugin, language, key, fallbackLanguage);
        return message == null ? fallbackString : message;
    }

    public static String getMessage(Plugin plugin, Language language, String key, Language fallbackLanguage) {
        if (!LANGUAGE_PROVIDERS.containsKey(plugin))
            return "§cPlugin " + plugin.getName() + " is Not Registered! Please Register First!";
        PluginLanguageProvider pluginLanguageProvider = LANGUAGE_PROVIDERS.get(plugin);
        HashMap<String, Object> langMap = pluginLanguageProvider.getLanguageFileType().parse(language.getLanguageFile(pluginLanguageProvider));
        if (langMap.containsKey(key))
            return (String) langMap.get(key);

        langMap = pluginLanguageProvider.getLanguageFileType().parse(fallbackLanguage.getLanguageFile(pluginLanguageProvider));

        if (langMap.containsKey(key))
            return (String) langMap.get(key);

        return null;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }


}
