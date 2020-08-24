package cn.leomc.languageutils;

import org.bukkit.entity.Player;

import java.io.File;
import java.util.Locale;

public class Language {

    private Locale language;

    public Language(Locale language) {
        this.language = language;
    }

    public Language(String language) {
        this.language = Locale.forLanguageTag(language);
    }

    public static Language fromPlayer(Player player) {
        return new Language(player.getLocale());
    }

    public Locale getLanguage() {
        return language;
    }

    public void setLanguage(Locale language) {
        this.language = language;
    }

    public void setLanguage(String language) {
        this.language = Locale.forLanguageTag(language);
    }

    public File getLanguageFile(File languageFolder) {
        return new File(languageFolder, language.toString().toLowerCase() + ".yml");
    }



}
