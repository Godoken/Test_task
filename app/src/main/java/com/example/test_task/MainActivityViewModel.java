package com.example.test_task;

import android.content.Context;

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


        mainActivityModel.getLanguage();

    }
}
