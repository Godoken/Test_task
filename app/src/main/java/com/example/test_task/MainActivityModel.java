package com.example.test_task;


import java.util.List;

public class MainActivityModel {

    List<IdentifieldLanguage> languageList = null;
    String s = "test";

    public void getLanguage(LanguageTranslator.IdentifyCallback identifyCallback){

        LanguageTranslator languageTranslator = new LanguageTranslator();

        languageTranslator.start(identifyCallback);

        /*while (languageTranslator.getLanguageList() == null){

            if (languageTranslator.getLanguageList() != null){

                languageList = languageTranslator.getLanguageList();
            }
        }*/

        //List languageList = languages.getLanguages();
        //anguageList.

        //return languages;
    }



}
