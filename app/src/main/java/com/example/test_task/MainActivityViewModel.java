package com.example.test_task;

import android.content.Context;

import java.util.List;

import androidx.fragment.app.FragmentManager;

public class MainActivityViewModel {

    void showFragmentNewText (FragmentManager fragmentManager){

        FragmentNewText fragmentNewText = new FragmentNewText();
        fragmentManager.beginTransaction().replace(R.id.fragment, fragmentNewText).commit();

    }

    void showFragmentHistory (FragmentManager fragmentManager){

        FragmentHistory fragmentHistory = new FragmentHistory();
        fragmentManager.beginTransaction().replace(R.id.fragment, fragmentHistory).commit();

    }

    void identifyLanguage (){

        MainActivityModel mainActivityModel = new MainActivityModel();


        mainActivityModel.getLanguage(new LanguageTranslator.IdentifyCallback() {
            @Override
            public void onSuccess(List<IdentifieldLanguage> languagesList) {
                System.out.println("Ответ пришел");
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Ответ не пришел");
            }
        });

    }
}
