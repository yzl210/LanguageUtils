package cn.leomc.languageutils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class LanguageUtils extends JavaPlugin {

    private static final HashMap<Plugin, File> LANGUAGE_FOLDERS = new HashMap<>();

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }


    public static void register(Plugin plugin, File languageFolder) {
        LANGUAGE_FOLDERS.put(plugin, languageFolder);
    }

    public static HashMap<Plugin, File> getLanguageFolders() {
        return LANGUAGE_FOLDERS;
    }

    public static String getMessage(Plugin plugin, Language language, String key, Language fallBackLanguage) {
        if(!LANGUAGE_FOLDERS.containsKey(plugin))
            return "Plugin Not Registered! Please Register First!";
        File langFolder = LANGUAGE_FOLDERS.get(plugin);
        try {
            YamlConfiguration yamlConfiguration = new YamlConfiguration();
            yamlConfiguration.load(language.getLanguageFile(langFolder));
            if (yamlConfiguration.contains(key))
                return yamlConfiguration.getString(key);
            else
                throw new InvalidConfigurationException("Cannot find key: " + key);
        } catch (InvalidConfigurationException | IOException e) {
            YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(fallBackLanguage.getLanguageFile(langFolder));
            if (yamlConfiguration.contains(key))
                return yamlConfiguration.getString(key);
        }
        return null;
    }


}
