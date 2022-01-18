package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	public double x,y;
	public int HEIGHT, WIDTH;

	public double dx,dy;
	public double speed = 1.2;
	
	public Ball(int x, int y) {
		this.x=x;
		this.y=y;
		this.WIDTH=4;
		this.HEIGHT=4;
		
		int angle = new Random().nextInt(55-30)+30;
		dx= Math.cos(Math.toRadians(angle));
		dy= Math.sin(Math.toRadians(angle));
		
	}
	
	public void tick() {
		
		if(x+(dx*speed)+ WIDTH >= Game.WIDTH) {
			dx*=-1;
		}
		else if(x+(dx*speed)<0) {
			dx*=-1;
			
		}
		if(y>= Game.HEIGHT) {
			//PONTO DO INIMIGO
			System.out.println("Ponto do inimigo!");
			new Game();
			return;
			
		}
		else if(y<0) {
			//PONTO DO JOGADOR
			System.out.println("Ponto do jogador!");
			new Game();
			return;
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)),WIDTH,HEIGHT);
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y,Game.player.WIDTH,Game.player.HEIGHT	);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x,(int)Game.enemy.y,Game.enemy.WIDTH,Game.enemy.HEIGHT);
		
		if(bounds.intersects(boundsPlayer)) {
			int angle = new Random().nextInt(55-30)+30;
			dx= Math.cos(Math.toRadians(angle));
			dy= Math.sin(Math.toRadians(angle));
			if(dy>0) {
			dy*=-1;	
			}
			
		} else if(bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt(55-30)+30;
			dx= Math.cos(Math.toRadians(angle));
			dy= Math.sin(Math.toRadians(angle));
			if(dy<0) {
			dy*=-1;
			}
		}
		
		x+=dx*speed;
		y+=dy*speed;
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, WIDTH, HEIGHT);
	}
	
}
