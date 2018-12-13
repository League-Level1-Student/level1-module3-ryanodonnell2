/*
 *    Copyright (c) The League of Amazing Programmers 2013-2017
 *    Level 1
 */

public class Backpack
{
	private Pencil pencil;
	private Ruler ruler;
	private Textbook textbook;

	private void packAndCheck()
	{
		// Your mission is to go to school.
		// 1. First you need to put all your supplies into your backpack - use the putInBackpack(...) methods

		goToSchool();
	}

	public static void main(String[] args)
	{
		new Backpack().packAndCheck();
	}

	public void putInBackpack(Pencil supply)
	{
		this.pencil = supply;
		log(supply);
	}

	public void putInBackpack(Ruler supply)
	{
		this.ruler = supply;
		log(supply);
	}

	public void putInBackpack(Textbook supply)
	{
		this.textbook = supply;
		log(supply);
	}

	private void log(Supply supply)
	{
		String description;
		if (supply == null)
		{
			description = "null";
		} else
		{
			description = supply.getClass().getSimpleName().toLowerCase();
		}

		System.out.println("You put " + description + " in your Backpack");
	}

	public void goToSchool()
	{
		if (pencil == null || ruler == null || textbook == null)
		{
			System.out.println("ERROR: You are not ready for School!");
		} else
		{
			System.out.println("Congratulations! You are ready for school");
		}
	}
}

abstract class Supply
{
	protected String name;
}

class Pencil extends Supply
{
	Pencil()
	{
		this.name = "pencil";
		System.out.println("You got your pencil!");
	}

	public void write(String writing)
	{
		System.out.println(writing);
	}
}

class Ruler extends Supply
{
	Ruler()
	{
		this.name = "ruler";
		System.out.println("You found your ruler!!");
	}

	public void measure()
	{
		System.out.println("Now you can measure your mouse!");
	}
}

class Textbook extends Supply
{
	Textbook()
	{
		this.name = "textbook";
		System.out.println("You got your boring textbook");
	}

	public void read()
	{
		System.out.println("The history of Iceland is long and interesting");
	}
}




























int gravity = 2;
float v = .25;
float y = 0;
float upV = 0;
int pipeX = 600;
int lowerY;
int speed;
int gap = 175;
int upperPipeHeight = (int) random(100, 300);
int bottomPipeHeight = (int) random(500, 100);

void setup(){
  size(600, 500);
  
}
void draw(){
  if (keyPressed) {
    if (key == '1') {
      gravity = 2;
    }
    if (key == '2') {
       gravity = 4;
    }
    if (key == '3') {
       gravity = 6;
    }
  }
  speed = gravity;
  background(255, 212, 147);
  fill(163, 255, 195);
  stroke(255, 255, 255);
  ellipse(150, y, 25, 25);
  if(y<465 && upV<0.01) {
  y = y + gravity + v;
  v = v + v/16;
  }
  else if(upV>.01) {
    y = y - gravity - 2*upV;
    upV = upV - .05;
    ellipse(150, y, 25, 25);
    v = .25;
  }  
  if(y < 470){
    y = y+2;
  }
  if(y>15){
    y = y-2;
  }
  if(mousePressed){
    upV=1.15;
  }
  
  
  fill(10, 200, 10);
  
  rect(pipeX, 0, 65, upperPipeHeight);
  lowerY = upperPipeHeight + gap;
  rect(pipeX, lowerY, 65, bottomPipeHeight);
  pipeX = pipeX - speed;
  if(pipeX < -6){
    upperPipeHeight = (int) random(100, 300);
    pipeX = 600;
  }
  
  
  
  
  
  
  
  
  
  
}

