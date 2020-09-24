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
        this(Locale.forLanguageTag(language.replace("_", "-")));
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
        this.language = Locale.forLanguageTag(language.replace("_", "-"));
    }

    public File getLanguageFile(PluginLanguageProvider pluginLanguageProvider) {
        return new File(pluginLanguageProvider.getLanguageFolder(), language.toString().toLowerCase() + pluginLanguageProvider.getLanguageFileType().getExtension());
    }


}
