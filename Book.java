package com.company;

public class Book {
    private String name = "NoName";
    private String type; //fantasy, detective, etc
    private int numberOfPages;
    private long fontSize;
    private String language = "English";


    public static int totalNumberOfPages = 0;

    public Book() {
    }

    public Book(String name, String type, int numberOfPages, int fontSize){
        setName(name);
        setType(type);
        setNumberOfPages(numberOfPages);
        setFontSize(fontSize);
        totalNumberOfPages += numberOfPages;
    }

    public Book(String name, String type, int numberOfPages, int fontSize, String language){
        setName(name);
        setType(type);
        setNumberOfPages(numberOfPages);
        setFontSize(fontSize);
        setLanguage(language);
        totalNumberOfPages += numberOfPages;
    }

    @Override
    public String toString(){
        return "Book is called " + name +", is " + type + ", reading pages: " + numberOfPages
                + ", has fontsize: " + fontSize + ", written in " + language;
    }

    static void printStaticSum(){
        System.out.println("Book have " + totalNumberOfPages + " lists");
    }
    public void printSum(){
        System.out.println("The book " + name + " can have lists " + totalNumberOfPages + " and more, total number is: "
                + totalNumberOfPages);
    }

    public void resetValues(String name, String type, int numberOfPages, int fontSize, String language){
        totalNumberOfPages -= this.numberOfPages;
        setName(name);
        setType(type);
        setNumberOfPages(numberOfPages);
        setFontSize(fontSize);
        setLanguage(language);
        totalNumberOfPages += numberOfPages;
    }

    public String getName(){
        return name;
    }

    public  void setName(String name){
        this.name = name;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    public int  getNumberOfPages(){
        return numberOfPages;
    }
    public void setNumberOfPages(int numberOfPages){
        totalNumberOfPages -= this.numberOfPages;
        this.numberOfPages = numberOfPages;
        totalNumberOfPages += this.numberOfPages;
    }
    public long getFontSize(){
        return fontSize;
    }
    public void setFontSize(long fontSize){
        this.fontSize = fontSize;
    }
    public String getLanguage(){
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
}
