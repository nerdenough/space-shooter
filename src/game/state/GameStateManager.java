package game.state;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 * GameStateManager is designed to be in control of all the possible game
 * states, deciding which state should be updated and rendered to the screen.
 * The possible states are stored in an ArrayList and can be accessed by getting
 * their index.
 * 
 * @author Brendan Goodenough
 * @version 0.1.0
 */

public class GameStateManager {
	private List<GameState> states;
	private int currentState;

	public static final int MENU_STATE = 0;
	public static final int PLAY_STATE = 1;

	/**
	 * Constructs a new GameStateManager by adding all states to an ArrayList
	 * and initializing the current state.
	 */
	public GameStateManager() {
		currentState = 0;

		states = new ArrayList<>();
		states.add(new MenuState(this));
		states.add(new PlayState(this));
		states.get(currentState).init();
	}

	/**
	 * Updates the frame for the current state.
	 */
	public void update() {
		states.get(currentState).update();
	}

	/**
	 * Renders the frame for the current state.
	 * 
	 * @param g2 - graphics object for rendering
	 */
	public void render(Graphics2D g2) {
		states.get(currentState).render(g2);
	}

	/**
	 * Changes the current state that is being updated and rendered.
	 * 
	 * @param currentState - new state for the game to run
	 */
	public void setCurrentState(int currentState) {
		if (currentState >= 0 && currentState <= 2) {
			this.currentState = currentState;
			states.get(currentState).init();
		}
	}

	/**
	 * Handles a key press event by passing it to the current state.
	 * 
	 * @param key - keycode of the pressed key
	 */
	public void keyPressed(int key) {
		states.get(currentState).keyPressed(key);
	}

	/**
	 * Handles a key release event by passing it to the current state.
	 * 
	 * @param key - keycode of the released key
	 */
	public void keyReleased(int key) {
		states.get(currentState).keyReleased(key);
	}
}
