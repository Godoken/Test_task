package com.example.test_task;


import java.util.List;

public class MainActivityModel {

    List<Language> languageList = null;
    String s = "test";

    public void getLanguage(){

        LanguageTranslator languageTranslator = new LanguageTranslator();

        languageList  = languageTranslator.start();

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
