package com.straightsix;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StraightSix extends Game {
	SpriteBatch batch;
	Sprite sprite;
	Texture img;
	AssetManager assetManager;

	@Override
	public void create() {

		this.assetManager = new AssetManager();
		this.assetManager.load("badlogic.jpg", Texture.class);
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sprite = new Sprite(img);
		sprite.setPosition(Gdx.graphics.getWidth() / 2 - sprite.getWidth() / 2,
				Gdx.graphics.getHeight() / 2);
	}

	@Override
	public void render() {
		if(!this.assetManager.update()){
			drawLoading();
		}
		// You know the rest...
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(sprite, sprite.getX(), sprite.getY());
		batch.end();
	}

	@Override
	public void dispose() {
		// Hey, I actually did some clean up in a code sample!
		this.img.dispose();
		this.assetManager.dispose();
	}

	// Used for when we are loading an asset
	private void drawLoading(){
		System.out.println("loading!");
	}
}