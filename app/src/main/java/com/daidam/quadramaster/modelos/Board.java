package com.daidam.quadramaster.modelos;

import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nexo on 06/12/2016.
 */

public class Board {
    private static final int MAXBLOCKS = 5;
    private static final int MAXPLAYERHAND = 5;

    private ArrayList<Card> player1Hand;
    private ArrayList<Card> player2Hand;
    private colourEnum turn;

    public void drawHands() {
        initiatePlayer1Hand(getDummyHand(MAXPLAYERHAND));
        initiatePlayer2Hand(getDummyHand(MAXPLAYERHAND));
    }

    private enum colourEnum {RED, BLUE};
    private ArrayList<ArrayList<Card>> board;

    private Context ctx;


    public Board(Context ctx){
        this.ctx = ctx;
    }

    public ArrayList<Card> getDummyHand(int n){
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < n; i++){
            hand.add(Card.dummyCard(ctx));
        }
        return hand;
    }

    public void initiatePlayer1Hand(ArrayList<Card> hand){
        this.player1Hand = hand;
        for (Card card : this.player1Hand){
            card.setColour(Card.colourEnum.RED);
        }
    }

    public void initiatePlayer2Hand(ArrayList<Card> hand){
        this.player2Hand = hand;
        for (Card card : this.player2Hand){
            card.setColour(Card.colourEnum.BLUE);
        }
    }

    public void startBoard(){
        ArrayList<Card> fila = new ArrayList<>();
        for (int i = 0; i<4; i++){
            fila.add(Card.dummyCard(ctx));
        }
        this.board = new ArrayList<>();
        this.board.add(fila);
        this.board.add(fila);
        this.board.add(fila);
        this.board.add(fila);
        int blanks = 0;
        int x, y;
        Random rand = new Random();
        while (blanks < MAXBLOCKS){
            x = rand.nextInt(4);
            y = rand.nextInt(4);
            if (getCard(x, y) == null){
                setCard(x, y, Card.blockCard(ctx));
                blanks++;
            } else if (!getCard(x, y).isBlock()){
                setCard(x, y, Card.blockCard(ctx));
                blanks++;
            }
        }
    }

    public void initiateTurn(){
        Random rand = new Random();
        turn = colourEnum.values()[rand.nextInt(2)];
    }

    public Card getCard(int x, int y){
        try {
            return this.getBoard().get(x).get(y);
        }catch (Exception ex){

        }finally {
            return null;
        }
    }

    /**
     * Método por el que un jugador coloca una carta en el tablero y hace que se muevan las cartas
     * según los números.
     * @param x
     * @param y
     * @param card
     */
    public void placeCard(int x, int y, Card card){
        this.getBoard().get(x).set(y, card);
    }

    public void setCard(int x, int y, Card card){
        this.getBoard().get(x).set(y, card);
    }

    public ArrayList<ArrayList<Card>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<Card>> board) {
        this.board = board;
    }

    public ArrayList<Card> getPlayer1Hand() {
        return player1Hand;
    }

    public void setPlayer1Hand(ArrayList<Card> player1Hand) {
        this.player1Hand = player1Hand;
    }

    public ArrayList<Card> getPlayer2Hand() {
        return player2Hand;
    }

    public void setPlayer2Hand(ArrayList<Card> player2Hand) {
        this.player2Hand = player2Hand;
    }

    public colourEnum getTurn() {
        return turn;
    }

    public void setTurn(colourEnum turn) {
        this.turn = turn;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + board +
                ", player1Hand=" + player1Hand +
                ", player2Hand=" + player2Hand +
                ", turn=" + turn +
                ", ctx=" + ctx +
                '}';
    }

    public String toJson() {
        return "Board : {" +
                " \" board \" : " + board +
                ", \" player1Hand \" : " + player1Hand +
                ", \" player2Hand \" : " + player2Hand +
                ", \" turn \" : " + turn +
                '}';
    }
}
