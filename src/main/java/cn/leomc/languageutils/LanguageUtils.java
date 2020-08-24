package cn.leomc.languageutils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class LanguageUtils extends JavaPlugin {

    private static final HashMap<Plugin, PluginLanguageProvider> LANGUAGE_FOLDERS = new HashMap<>();

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }


    public static void register(Plugin plugin, PluginLanguageProvider pluginLanguageProvider) {
        LANGUAGE_FOLDERS.put(plugin, pluginLanguageProvider);
    }

    public static HashMap<Plugin, PluginLanguageProvider> getLanguageFolders() {
        return LANGUAGE_FOLDERS;
    }

    public static String getMessage(Plugin plugin, Language language, String key, Language fallBackLanguage) {
        if(!LANGUAGE_FOLDERS.containsKey(plugin))
            return "Plugin " + plugin.getName() + " Not Registered! Please Register First!";
        PluginLanguageProvider pluginLanguageProvider = LANGUAGE_FOLDERS.get(plugin);
        HashMap<String, Object> langMap = pluginLanguageProvider.getLanguageFileType().parse(language.getLanguageFile(pluginLanguageProvider.getLanguageFolder()));
        if(langMap.containsKey(key))
            return (String) langMap.get(key);

        langMap = pluginLanguageProvider.getLanguageFileType().parse(fallBackLanguage.getLanguageFile(pluginLanguageProvider.getLanguageFolder()));

        if(langMap.containsKey(key))
            return (String) langMap.get(key);

        return null;
    }


}
