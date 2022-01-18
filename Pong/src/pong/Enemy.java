package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {

	public double x,y;
	public int HEIGHT, WIDTH;

	public Enemy(int x, int y) {
		this.x=x;
		this.y=y;
		this.WIDTH=40;
		this.HEIGHT=5;
	}
	
	public void tick() {
		x += (Game.ball.x - x - 6) *0.8;
		Rectangle rect1 = new Rectangle((int)x, (int)y, WIDTH, HEIGHT);
		
	}
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)x, (int)y, WIDTH, HEIGHT);
	}
	
}
