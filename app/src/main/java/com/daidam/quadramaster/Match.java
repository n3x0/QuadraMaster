package com.daidam.quadramaster;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import com.daidam.quadramaster.modelos.Board;

import java.util.Arrays;

/**
 * Created by Nexo on 06/12/2016.
 */

public class Match extends Activity {

    private Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        enlazar();
        startGame();
    }

    private void startGame() {
        board = new Board(this);
        board.startBoard();
        board.drawHands();

        printHand(1);
        printHand(2);
        printBoard();
    }

    private void printBoard() {
        System.out.println(board.toJson());
    }

    private void printHand(int i) {
        if (i == 1){
            System.out.println(Arrays.toString(board.getPlayer1Hand().toArray()));
        }else{
            System.out.println(Arrays.toString(board.getPlayer2Hand().toArray()));
        }
    }

    private void enlazar() {

    }

    public static void goTo(Application application, Activity activity) {
        Intent intent;
        intent = new Intent(application, Match.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }
}
