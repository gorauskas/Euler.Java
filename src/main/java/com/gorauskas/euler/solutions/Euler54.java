package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.pow;

public class Euler54 implements Euler {

    Map<String, Integer> CARDS = Util.enumerate(2, Util.toList("23456789TJQKA"));

    @Override
    public double Solve() {
        int res = 0;

        try {
            var uri = getClass().getResource("/p054_poker.txt").toURI();
            var data = Util.getDataFromFile(uri);

            var hands = Stream.of(data.split("\n")).collect(Collectors.toList());

            for (String hand : hands) {
                int p1hv = getHandValue(hand.substring(0, 14));
                int p2hv = getHandValue(hand.substring(15, 29));

                if (p1hv > p2hv) {
                    res++;
                }
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 54\n")
                .append("\n")
                .append("    In the card game poker, a hand consists of five cards and are ranked, from\n")
                .append("    lowest to highest, in the following way:\n")
                .append("\n")
                .append("      * High Card: Highest value card.\n")
                .append("      * One Pair: Two cards of the same value.\n")
                .append("      * Two Pairs: Two different pairs.\n")
                .append("      * Three of a Kind: Three cards of the same value.\n")
                .append("      * Straight: All cards are consecutive values.\n")
                .append("      * Flush: All cards of the same suit.\n")
                .append("      * Full House: Three of a kind and a pair.\n")
                .append("      * Four of a Kind: Four cards of the same value.\n")
                .append("      * Straight Flush: All cards are consecutive values of same suit.\n")
                .append("      * Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.\n")
                .append("\n")
                .append("    The cards are valued in the order: 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen,\n")
                .append("    King, Ace.\n")
                .append("\n")
                .append("    If two players have the same ranked hands then the rank made up of the\n")
                .append("    highest value wins; for example, a pair of eights beats a pair of fives (see\n")
                .append("    example 1 below). But if two ranks tie, for example, both players have a\n")
                .append("    pair of queens, then highest cards in each hand are compared (see example 4\n")
                .append("    below); if the highest cards tie then the next highest cards are compared,\n")
                .append("    and so on.\n")
                .append("\n")
                .append("    Consider the following five hands dealt to two players:\n")
                .append("\n")
                .append("    Hand  | Player 1            | Player 2            | Winner\n")
                .append("    =============================================================\n")
                .append("     1      5H 5C 6S 7S KD        2C 3S 8S 8D TD        Player 2\n")
                .append("            Pair of Fives         Pair of Eights\n")
                .append("    -------------------------------------------------------------\n")
                .append("     2      5D 8C 9S JS AC        2C 5C 7D 8S QH        Player 1\n")
                .append("            Highest card Ace      Highest card Queen\n")
                .append("    -------------------------------------------------------------\n")
                .append("     3      2D 9C AS AH AC        3D 6D 7D TD QD        Player 2\n")
                .append("            Three Aces            Flush with Diamonds\n")
                .append("    -------------------------------------------------------------\n")
                .append("     4      4D 6S 9H QH QC        3D 6D 7H QD QS        Player 1\n")
                .append("            Pair of Queens        Pair of Queens\n")
                .append("            Highest card Nine     Highest card Seven\n")
                .append("    -------------------------------------------------------------\n")
                .append("     5      2H 2D 4C 4D 4S        3C 3D 3S 9S 9D        Player 1\n")
                .append("            Full House            Full House\n")
                .append("            With Three Fours      with Three Threes\n")
                .append("    -------------------------------------------------------------\n")
                .append("\n")
                .append("    The file, poker.txt, contains one-thousand random hands dealt to two\n")
                .append("    players. Each line of the file contains ten cards (separated by a single\n")
                .append("    space): the first five are Player 1's cards and the last five are Player 2's\n")
                .append("    cards. You can assume that all hands are valid (no invalid characters or\n")
                .append("    repeated cards), each player's hand is in no specific order, and in each\n")
                .append("    hand there is a clear winner.\n")
                .append("\n")
                .append("    How many hands does Player 1 win?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("Player One wins %s hands.", (long)this.Solve());
    }

    private enum HandRank {
        HIGHCARD      (0L),
        ONEPAIR       (1000000L),
        TWOPAIR       (2000000L),
        THREEKIND     (3000000L),
        STRAIGHT      (4000000L),
        FLUSH         (5000000L),
        FULLHOUSE     (6000000L),
        FOURKIND      (7000000L),
        STRAIGHTFLUSH (8000000L),
        ROYALFLUSH    (9000000L);

        public final long value;

        HandRank(long val) {
            value = val;
        }
    }

    /**
     * The first part to evaluating a hand of poker is to rank it e.g. Pair, 2 Pair, Flush, etc.
     * A lot of the time you can determine the winning hand solely on the rank
     * @param hand a string representation of the hand
     * @return HandRank value
     */
    private HandRank getHandRank(String hand) {
        var vals = getValues(hand);                                         // Numeric values
        var suits = getSuits(hand);                                         // Suit values
        var valsHist = histogram(getFaceValues(hand));                      // histogram of values

        // a string representation of the values distribution for comparison
        String valsDist = Util.listToString(new ArrayList<>(valsHist.values()));

        switch (valsHist.size()) {
            case 5:
                boolean isf = isFlush(suits);
                boolean iss = isStraight(vals);

                if (isf && iss) {
                    if (isRoyal(vals)) {
                        return HandRank.ROYALFLUSH;
                    }

                    return HandRank.STRAIGHTFLUSH;
                } else if (isf && !iss) {
                    return HandRank.FLUSH;
                } else if (iss && !isf) {
                    return HandRank.STRAIGHT;
                } else {
                    return HandRank.HIGHCARD;
                }
            case 4:
                return HandRank.ONEPAIR;
            case 3:
                if (valsDist.equals("[2, 2, 1]")) {
                    return HandRank.TWOPAIR;
                } else {  //if (valsDist == "[3, 1, 1]") {
                    return HandRank.THREEKIND;
                }
            case 2:
                if (valsDist.equals("[3, 2]")) {
                    return HandRank.FULLHOUSE;
                } else {  // if (valsDist == "[4, 1]") {
                    return HandRank.FOURKIND;
                }
        }

        return HandRank.HIGHCARD;
    }

    /**
     * The second part to evaluating a hand of poker is to assign it a numeric value based on the rank.
     * This is needed and 2 competing hands have the same rank
     * @param hand
     * @return
     */
    private int getHandValue(String hand) {
        List<Integer> vals = getValues(hand);  // sorted descending - highest value at index 0
        HandRank rank = getHandRank(hand);
        int val = 0;

        switch (rank) {
            // value = 14^4*highestCard + 14^3*2ndHighestCard + 14^2*3rdHighestCard + 14^1*4thHighestCard + LowestCard
            case HIGHCARD:
                val = ((int)pow(14, 4) * vals.get(0)) +
                        ((int)pow(14, 3) * vals.get(1)) +
                        ((int)pow(14, 2) * vals.get(2)) +
                        (14 * vals.get(3)) +
                        vals.get(4);
                break;

            // value = OnePair + 14^3*PairCard + 14^2*HighestCard + 14*MiddleCard + LowestCard
            case ONEPAIR:
                if (vals.get(0) == vals.get(1)) {         // a a x y z
                    val = ((int)pow(14, 3) * vals.get(0)) +
                            ((int)pow(14, 2) * vals.get(2)) +
                            (14 * vals.get(3)) +
                            vals.get(4);
                } else if (vals.get(1) == vals.get(2)) {  // x a a y z
                    val = ((int)pow(14, 3) * vals.get(1)) +
                            ((int)pow(14, 2) * vals.get(0)) +
                            (14 * vals.get(3)) +
                            vals.get(4);
                } else if (vals.get(2) == vals.get(3)) {  // x y a a z
                    val = ((int)pow(14, 3) * vals.get(2)) +
                            ((int)pow(14, 2) * vals.get(0)) +
                            (14 * vals.get(1)) +
                            vals.get(4);
                } else {                          // x y z a a
                    val = ((int)pow(14, 3) * vals.get(3)) +
                            ((int)pow(14, 2) * vals.get(0)) +
                            (14 * vals.get(1)) +
                            vals.get(2);
                }

                val = (int)HandRank.ONEPAIR.value + val;
                break;

            // value = TwoPair + 14*14*HighPairCard + 14*LowPairCard + UnmatchedCard
            case TWOPAIR:
                if (vals.get(0) == vals.get(1) && vals.get(2) == vals.get(3)) {          // a a b b x
                    val = ((int)pow(14, 2) * vals.get(0)) +
                            (14 * vals.get(2)) +
                            vals.get(4);
                } else if (vals.get(0) == vals.get(1) && vals.get(3) == vals.get(4)) {   // a a x b b
                    val = ((int)pow(14, 2) * vals.get(0)) +
                            (14 * vals.get(3)) +
                            vals.get(2);
                } else {                                                 // x a a b b
                    val = ((int)pow(14, 2) * vals.get(1)) +
                            (14 * vals.get(3)) +
                            vals.get(0);
                }

                val = (int)HandRank.TWOPAIR.value + val;
                break;

            // value = ThreeKind + SetCardRank
            case THREEKIND:
                val = (int)HandRank.THREEKIND.value + vals.get(2);
                break;

            // value = Straight + valueHighCard()
            case STRAIGHT:
                val = (int)HandRank.STRAIGHT.value + vals.get(0);
                break;

            // value = Flush + valueHighCard()
            case FLUSH:
                val = (int)HandRank.FLUSH.value + vals.get(0);
                break;

            // value = FullHouse + SetCardRank
            case FULLHOUSE:
                val = (int)HandRank.FULLHOUSE.value + vals.get(2);
                break;

            // value = FourKind + 4sCardRank
            case FOURKIND:
                val = (int)HandRank.FOURKIND.value + vals.get(2);
                break;

            // value = StraightFlush + valueHighCard()
            case STRAIGHTFLUSH:
                val = (int)HandRank.STRAIGHTFLUSH.value + vals.get(0);
                break;

            // value = RoyalFlush + valueHighCard()
            case ROYALFLUSH:
                val = (int)HandRank.ROYALFLUSH.value + vals.get(0);
                break;
        }

        return val;
    }

    /**
     * Returns the frequency occurrence of card values in a hand.
     *   e. g. this is how we tell if there are 1 pair or 2 pairs
     *
     * Histogram of face values can give us the following:
     *   - High Card:  Count = 5  (1, 1, 1, 1, 1)
     *   - One Pair:   Count = 4  (2, 1, 1, 1)
     *   - Two Pair:   Count = 3  (2, 2, 1)
     *   - 3 Kind:     Count = 3  (3, 1, 1)
     *   - Full House: Count = 2  (3, 2)
     *   - Four Kind:  Count = 2  (4, 1)
     *
     * Histogram of suits can give us the following:
     *   - Flush:      Count = 1  (5)
     *
     * @param vals   The list of the hand face values
     * @return    Map of String, Integer pairs
     */
    private Map<String, Integer> histogram(List<String> vals) {
        var m = new HashMap<String, Integer>();

        for (var item : vals) {
            if (m.containsKey(item)) {
                m.put(item, m.get(item) + 1);
            } else {
                m.put(item, 1);
            }
        }

        return Util.sortByValue(m, false);
    }

    /**
     * A hand is a flush when the histogram of the suites in the hand map one suit with a frequency of 5
     * and hence a single count on the dictionary.
     * @param handSuits    The list of the suit values
     * @return    true if it is flush and false otherwise
     */
    private boolean isFlush(List<String> handSuits) {
        var d = histogram(handSuits);
        return d.size() == 1;
    }

    /**
     * A straight occurred when the value of the highest card subtracted by the smallest card is 4
     * but you also have to account for the Ace playing low
     * @param handValues    The list of the hand values
     * @return    true if it is straight and false otherwise
     */
    private boolean isStraight(List<Integer> handValues) {
        Collections.sort(handValues);

        // check for special case
        if (handValues.get(4) == 14) {
            // wheel = a five=high straight (A-2-3-4-5), with the ace playing low
            if (handValues.get(0) == 2 &&
                    handValues.get(1) == 3 &&
                    handValues.get(2) == 4 &&
                    handValues.get(3) == 5) {

                return true;

            }
        }

        return handValues.get(4) - handValues.get(0) == 4;
    }

    /**
     * The royal flush is straight flush from 10 to Ace
     * @param handValues    The list of the hand values
     * @return    true if it is royal flush and false otherwise
     */
    private boolean isRoyal(List<Integer> handValues) {
        return (handValues.get(0) == 10 &&
                handValues.get(1) == 11 &&
                handValues.get(2) == 12 &&
                handValues.get(3) == 13 &&
                handValues.get(4) == 14);
    }

    /**
     * Get the numeric values of the cards in the hand
     *   e.g.
     *     Face  | Numeric
     *   -------------------
     *      2    |    2
     *      8    |    8
     *      T    |    10
     *      A    |    14
     * @param hand  The string representation of the hand
     * @return A List of int
     */
    private List<Integer> getValues(String hand) {
        var li = new ArrayList<Integer>();

        for (var item : Arrays.stream(hand.split(" ")).map(x -> x.substring(0, 1)).collect(Collectors.toList())) {
            li.add(CARDS.get(item));
        }

        li.sort(Collections.reverseOrder());

        return li;
    }

    /**
     * Get the face values of the cards in the hand
     * @param hand    The string representation of the hand
     * @return    A List of string
     */
    private List<String> getFaceValues(String hand) {
        return Arrays.stream(hand.split(" ")).map(x -> x.substring(0, 1)).collect(Collectors.toList());
    }


    /**
     * Get the suits in the hand
     * @param hand   The string representation of the hand
     * @return    A List of string
     */
    private List<String> getSuits(String hand) {
        return Arrays.stream(hand.split(" ")).map(x -> x.substring(1, 2)).collect(Collectors.toList());
    }
}
