package cn.leomc.languageutils;

import java.io.File;

public class PluginLanguageProvider {

    private File languageFolder;
    private LanguageFileType languageFileType;

    public PluginLanguageProvider(File languageFolder, LanguageFileType languageFileType){
        this.languageFolder = languageFolder;
        this.languageFileType = languageFileType;
    }

    public File getLanguageFolder() {
        return languageFolder;
    }

    public LanguageFileType getLanguageFileType() {
        return languageFileType;
    }

    public void setLanguageFileType(LanguageFileType languageFileType) {
        this.languageFileType = languageFileType;
    }

    public void setLanguageFolder(File languageFolder) {
        this.languageFolder = languageFolder;
    }
}
