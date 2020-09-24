package cn.leomc.languageutils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public enum LanguageFileType {

    YAML("yml") {
        public HashMap<String, Object> parse(File file) {
            return new HashMap<>(YamlConfiguration.loadConfiguration(file).getValues(true));
        }
    },
    JSON("json"),
    LANG("lang") {
        public HashMap<String, Object> parse(File file) {
            List<String> lines = new LinkedList<>();
            try {
                lines = Files.readAllLines(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }

            HashMap<String, Object> map = new HashMap<>();
            for (String line : lines) {
                String[] split = line.split("=");
                map.put(split[0], split[1]);
            }
            return map;
        }
    },
    PROPERTIES("properties");


    private final String extension;

    LanguageFileType(String extension) {
        this.extension = extension;
    }


    public String getExtension() {
        return "." + extension;
    }

    public HashMap<String, Object> parse(File file) {
        throw new AbstractMethodError();
    }

}
