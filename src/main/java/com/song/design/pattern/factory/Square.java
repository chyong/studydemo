package com.song.design.pattern.factory;

public class Square implements  Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
