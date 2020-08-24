package cn.leomc.languageutils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;

public enum LanguageFileType {

    YAML("yml"),
    JSON(".json"),
    LANG(".lang"),
    PROPERTIES(".properties");


    private final String extension;

    LanguageFileType(String extension){
        this.extension = extension;
    }


    public String getExtension() {
        return extension;
    }

    public HashMap<String, Object> parse(File file){
        HashMap<String, Object> map = new HashMap<>();
        LanguageFileType type = valueOf(name());
        if(type == YAML){
            YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
            map.putAll(yamlConfiguration.getValues(true));
        }
        return map;
    }

}
