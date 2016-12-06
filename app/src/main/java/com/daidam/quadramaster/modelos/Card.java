package com.daidam.quadramaster.modelos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nexo on 06/12/2016.
 */

public class Card extends View {
    public static enum colourEnum {BLANK, BLOCK, RED, BLUE};
    public static char[] charType  = new char[]{'P', 'M', 'X', 'A'};

    private ArrayList<Boolean> dirs;
    private int power;
    private char type;
    private int def;
    private int att;
    private colourEnum colour;


    private static int MAXDEF = 255;
    private static int MAXATT = 255;

    public Card(Context context, AttributeSet attr) {
        super(context, attr);
        this.setDirs(new ArrayList<Boolean>());
    }

    public static Card dummyCard(Context ctx){
        Random rand = new Random();
        Card card = new Card(ctx, null);
        for (int i = 0; i < 9; i++){
            card.getDirs().add(new Boolean(true));
            card.setDir(i, rand.nextBoolean());
        }
        card.setAtt(rand.nextInt(MAXATT));
        card.setDef(rand.nextInt(MAXDEF));
        card.setColour(colourEnum.BLANK);
        card.setType(charType[rand.nextInt(4)]);

        return card;
    }

    public static Card blankCard(Context ctx){
        Card card = new Card(ctx, null);
        card.setColour(colourEnum.BLANK);
        return card;
    }

    public boolean isBlock() {
        return colour.equals(colourEnum.BLOCK);
    }

    public static Card blockCard(Context ctx){
        Card card = new Card(ctx, null);
        card.setColour(colourEnum.BLOCK);
        return card;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public ArrayList getDirs() {
        return dirs;
    }

    public void setDirs(ArrayList<Boolean> dirs) {
        this.dirs = dirs;
    }

    public boolean getDir(int dir) {
        return this.dirs.get(dir);
    }

    public void setDir(int dir, boolean valor){
        this.dirs.set(dir, valor);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public colourEnum getColour() {
        return colour;
    }

    public void setColour(colourEnum colour) {
        this.colour = colour;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "att=" + att +
                ", dirs=" + dirs +
                ", power=" + power +
                ", type=" + type +
                ", def=" + def +
                ", colour=" + colour +
                '}';
    }
}
