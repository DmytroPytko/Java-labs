package com.company;

public class Main {

    public static void main(String args[])
    {
        Book DarkTower = new Book();
        Book SherlockHolmes = new Book("SherlockHolmes", "detective",  468, 14);
        Book Endersgame = new Book("Endersgame", "fanatasy",  357, 16, "English");

        System.out.println(DarkTower.toString());
        System.out.println(SherlockHolmes.toString());
        System.out.println(Endersgame.toString());

        DarkTower.printSum();
        SherlockHolmes.printSum();
        Endersgame.printSum();

        SherlockHolmes.setNumberOfPages(525);

        Book.printStaticSum();

    }
}
