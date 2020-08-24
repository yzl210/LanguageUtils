package cn.leomc.languageutils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum LanguageFileType {

    YAML("yml", "yaml"),
    JSON(".json"),
    LANG(".lang"),
    PROPERTIES(".properties");


    LanguageFileType(String... extensions){

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
