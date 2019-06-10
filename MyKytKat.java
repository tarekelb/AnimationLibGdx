package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyKytKat extends ApplicationAdapter {
	final int nbCOL = 11;
	final int nbLINE = 2;
	Animation animation;
	float elapsedTime;
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("gokuui.jpg");
		TextureRegion[][] tmp = TextureRegion.split(img, 234,236);
		TextureRegion[] Frame = new TextureRegion[nbCOL * nbLINE];
		int index = 0;
		for (int i = 0; i < nbLINE; ++i) {
			for (int j = 0; j < nbCOL;  ++j)
				Frame[index++] = tmp[i][j];
		}
		animation = new Animation(0.15f, Frame);
		elapsedTime = 0;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(255, 255, 255, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		elapsedTime += Gdx.graphics.getDeltaTime();
		TextureRegion currFrame = (TextureRegion) animation.getKeyFrame(elapsedTime, true);
		batch.begin();
		batch.draw(currFrame, 200,200,600,600);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
