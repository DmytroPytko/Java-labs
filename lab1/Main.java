package com.company;

public class Main {

    public static void main(String args[])
    {
        Book darkTower = new Book();
        Book sherlockHolmes = new Book("SherlockHolmes", "detective",  468, 14);
        Book endersgame = new Book("Endersgame", "fanatasy",  357, 16, "English");

        System.out.println(darkTower.toString());
        System.out.println(sherlockHolmes.toString());
        System.out.println(endersgame.toString());

        darkTower.printSum();
        sherlockHolmes.printSum();
        endersgame.printSum();

        sherlockHolmes.setNumberOfPages(525);

        Book.printStaticSum();

    }
}
