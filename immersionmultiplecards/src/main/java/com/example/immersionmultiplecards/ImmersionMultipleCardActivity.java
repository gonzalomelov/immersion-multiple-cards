package com.example.immersionmultiplecards;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;
import java.util.List;

public class ImmersionMultipleCardActivity extends Activity {

    private List<Card> mCards;
    private CardScrollView mCardScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initCards();

        mCardScrollView = new CardScrollView(this);

        ExampleCardScrollAdapter exampleCardScrollAdapter = new ExampleCardScrollAdapter();
        mCardScrollView.setAdapter(exampleCardScrollAdapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
    }

    private void initCards() {
        mCards = new ArrayList<Card>();

        Card textCard = new Card(this);
        textCard.setText("Hello world!");
        textCard.setFootnote("Proyecto");
        mCards.add(textCard);

        Card backgroundCard = new Card(this);
        backgroundCard.setText("Hello Background!");
        backgroundCard.setImageLayout(Card.ImageLayout.FULL);
        backgroundCard.addImage(R.drawable.background);
        mCards.add(backgroundCard);

        Card smallImagesCard = new Card(this);
        smallImagesCard.setText("Small Images!");
        smallImagesCard.setImageLayout(Card.ImageLayout.LEFT);
        smallImagesCard.addImage(R.drawable.small_1);
        smallImagesCard.addImage(R.drawable.small_2);
        mCards.add(smallImagesCard);
    }

    private class ExampleCardScrollAdapter extends CardScrollAdapter {
        @Override
        public int findIdPosition(Object o) {
            return -1;
        }

        @Override
        public int findItemPosition(Object o) {
            return mCards.indexOf(o);
        }

        @Override
        public int getCount() {
            return mCards.size();
        }

        @Override
        public Object getItem(int i) {
            return mCards.get(i);
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return mCards.get(i).toView();
        }
    }
}