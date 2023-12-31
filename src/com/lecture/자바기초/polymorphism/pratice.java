package com.lecture.자바기초.polymorphism;

class Car{
    Car(){}
    public void horn(){
        System.out.println("빵빵!");
    }
}

class FireTruck extends Car{
    FireTruck(){}
    public void horn(){
        System.out.println("위이잉!");
    }
}

class Ambulance extends Car{
    Ambulance(){}
    public void horn(){
        System.out.println("삐뽀삐뽀!");
    }
}

public class pratice {
    public static void main(String[] args){
        Car car = new Car();
        car.horn();

        car = new FireTruck();
        car.horn();

        car = new Ambulance();
        car.horn();

        Car car2[] = {new Car(), new FireTruck(), new Ambulance()};

        for(Car item:car2){
            item.horn();
        }
    }
}
