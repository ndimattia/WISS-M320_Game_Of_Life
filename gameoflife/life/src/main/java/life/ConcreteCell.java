package life;

import javax.swing.JPanel;

/**
 * Die {@code ConcreteCell} Klasse implementiert das Verhalten einer Zelle, basierend auf der Anzahl ihrer benachbarten Zellen.
 * 
 * @author Noè Di Mattia
 * @version 1.0
 */

public class ConcreteCell extends AbstractCell {
	public ConcreteCell(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Berechnet den nächsten zustand einer Zelle basierend auf dem aktuellen Zustand der Zelle und deren benachbarten Zellen.
	 * */
	@Override
	public void calculateNextState() {
		int liveNeighbours = 0;
		for (Cell neighbour : neighbours) {
			if (neighbour.isAlive()) {
				liveNeighbours++;
			}
		}
		
		if(this.alive) {
			if(liveNeighbours < 2 || liveNeighbours > 3) {
				this.die();
			}
			else {
				this.nextState = true;
			}
		}
		else {
			if(liveNeighbours == 3) {
				this.beBorn();
			}
			else {
				this.nextState = false;
			}
		}
	}
}
