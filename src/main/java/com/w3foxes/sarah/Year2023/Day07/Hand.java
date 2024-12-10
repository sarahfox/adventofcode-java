package com.w3foxes.sarah.Year2023.Day07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hand {
    private List<Card> cardList = new ArrayList<>();
    private String data;

    Hand(String data) {
        this.data = data;

        for (int i = 0; i < data.length(); i++) {
            String cardName = "" + data.charAt(i);
            cardList.add(Card.get(cardName));
        }
    }

    public int getHandSize() {
        return cardList.size();
    }

    public Card getCardAt(int i) {
        return cardList.get(i);
    }

    public String toString() {
        return data;
    }

    public HandType getHandType() {
        Map<Card, Integer> cardCounts = new HashMap<>();
        int jokerCount = 0;
        // Figure out how many we have of each card
        for (Card card : cardList) {
            if (card == Card.JOKER) {
                jokerCount++;
            }

            if (cardCounts.get(card) == null) {
                cardCounts.put(card, 1);
            } else {
                cardCounts.put(card, cardCounts.get(card) + 1);
            }
        }

        if (jokerCount == 0 || jokerCount == 5) {
            return interpretUnjokeredCardCounts(cardCounts);
        }

        // If we have any jokers, we'll need to add them where they could do the most
        // good.
        // FOUR_OF_KIND - JJJJ? or ????J = FIVE_OF_A_KIND
        // FULL_HOUSE - JJ??? or ???JJ = FIVE_OF_A_KIND,
        // THREE_OF_A_KIND - JJJXY, XXXJ?, or XXXJJ = FOUR_OF_A_KIND or FIVE_OF_A_KIND
        // TWO_PAIR - XXYYJ, XXJJY = THREE_OF_A_KIND or FOUR_OF_A_KIND
        // ONE_PAIR - JJXYZ, XXJYZ = THREE_OF_A_KIND
        // HIGH_CARD - XYZAJ = ONE_PAIR
        // I think adding the jokers to the highest non-joker card will do the right
        // thing
        int highestNonJokerCardCount = 0;
        Card highestNonJokerCard = null;

        for (Card card : cardCounts.keySet()) {
            if (card != Card.JOKER && cardCounts.get(card) > highestNonJokerCardCount) {
                highestNonJokerCard = card;
                highestNonJokerCardCount = cardCounts.get(card);
            }
        }
        cardCounts.put(highestNonJokerCard, cardCounts.get(highestNonJokerCard) + jokerCount);
        cardCounts.remove(Card.JOKER);

        return interpretUnjokeredCardCounts(cardCounts);
    }

    public HandType interpretUnjokeredCardCounts(Map<Card, Integer> cardCounts) {
        // 1 entry means 5 of a kind, and it won't matter if there are jokers
        if (cardCounts.size() == 1) {
            return HandType.FIVE_OF_A_KIND;
        }

        // 5 entries means no 2 cards are the same
        if (cardCounts.size() == 5) {
            return HandType.HIGH_CARD;
        }
        // 4 entries means 1 pair
        if (cardCounts.size() == 4) {
            return HandType.ONE_PAIR;
        }
        // 2 entries could be 4 of a kind or full house
        if (cardCounts.size() == 2) {
            int maxFound = cardCounts.values().stream().max(Integer::compare).get();

            if (maxFound == 4) {
                return HandType.FOUR_OF_A_KIND;
            }

            return HandType.FULL_HOUSE;
        }
        // 3 entries could be 3 of a kind or 2 pair
        if (cardCounts.size() == 3) {
            int maxFound = cardCounts.values().stream().max(Integer::compare).get();

            if (maxFound == 3) {
                return HandType.THREE_OF_A_KIND;
            }

            return HandType.TWO_PAIR;
        }

        return null;
    }
}
