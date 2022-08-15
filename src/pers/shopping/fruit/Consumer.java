package pers.shopping.fruit.consume;

import pers.shopping.fruit.goods.Apple;
import pers.shopping.fruit.goods.Fruit;
import pers.shopping.fruit.goods.Mango;
import pers.shopping.fruit.goods.Strawberry;

import java.util.concurrent.CompletionService;

public class Consumer implements Shopping{
  public static Consumer consumer = new Consumer();
  public Fruit apple = new Apple(8,1);
  public Fruit strawberry = new Strawberry(13,1);
  public Fruit mango = new Mango(20,1);

  public static void main(String[] args) {


    if (consumer.consumerA(10,10) == 210) {
      System.out.println("consumerA right");
    } else {
      System.out.println("consumerA error");
    }

    if (consumer.consumerB(10,10,10) == 410) {
      System.out.println("consumerB right");
    } else {
      System.out.println("consumerB error");
    }


    if (consumer.consumerC(10,10,10) == 384) {
      System.out.println("consumerC right");
    } else {
      System.out.println("consumerC error");
    }
    if (consumer.consumerD(10,10,10) == 354) {
      System.out.println("consumerD right");
    } else {
      System.out.println("consumerD error");
    }

  }
  public double consumerA(int appleWeight , int strawberryWeight){


    double appleCost = consumer.shopping(apple, appleWeight);
    double strawberryCost = consumer.shopping(strawberry, strawberryWeight);
    double cost = appleCost + strawberryCost;
    return cost;
  }

  public double consumerB(int appleWeight , int strawberryWeight,int mangoWeight){


    double appleCost = consumer.shopping(apple, appleWeight);
    double strawberryCost = consumer.shopping(strawberry, strawberryWeight);
    double mangoCost = consumer.shopping(mango, strawberryWeight);
    double cost = appleCost + strawberryCost + mangoCost;
    return cost;
  }

  public double consumerC(int appleWeight , int strawberryWeight,int mangoWeight){

    Fruit strawberry = new Strawberry(13,0.8);
    double appleCost = consumer.shopping(apple, appleWeight);
    double strawberryCost = consumer.shopping(strawberry, strawberryWeight);
    double mangoCost = consumer.shopping(mango, strawberryWeight);
    double cost = appleCost + strawberryCost + mangoCost;
    return cost;
  }


  public double consumerD(int appleWeight , int strawberryWeight,int mangoWeight){

    Fruit strawberry = new Strawberry(13,0.8);
    double appleCost = consumer.shopping(apple, appleWeight);
    double strawberryCost = consumer.shopping(strawberry, strawberryWeight);
    double mangoCost = consumer.shopping(mango, strawberryWeight);
    double cost = appleCost + strawberryCost + mangoCost;
    cost = cost - (int)(cost / 100) * 10;
    return cost;
  }

  @Override
  public double shopping(Fruit fruit,int weight ) {
    double cost =  fruit.getPrice() * fruit.getDiscount() * weight;
    return cost;
  }
}
