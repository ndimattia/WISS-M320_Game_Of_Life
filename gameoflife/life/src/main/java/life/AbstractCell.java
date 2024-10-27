package life;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * Die {@code AbstractCell} Klasse ermittelt die Positionen der Benachbarten Zelle einer Zelle. Die Methoden zum ändern des Zustands einer Zelle werden auch in dieser Klasse
 * implementiert. Zudem returniert sie den aktuellen Zustand und die Koordinaten einer Zelle.
 * 
 * @author Noè Di Mattia
 * @version 1.0
 */

public abstract class AbstractCell implements Cell {
	protected int x;
	protected int y;
	protected boolean alive;
	protected List<Cell> neighbours;
	protected boolean nextState;
	
	/**
	 * Konstruktor für die Abstrakte Klasse AbstractCell.
	 * @param x
	 * @param y
	 */
	public AbstractCell(int x, int y) {
		this.x = x;
		this.y = y;
		this.alive = false;
		this.neighbours = new ArrayList<>();
	}
	
	/**
	 * Berechnet die Position der Nachbarn einer Zelle relativ zur aktuellen Zelle. Falls die benachbarte Zelle die Kriterien erfüllt, wird sie zur Liste der
	 * Nachbarn der Zelle hinzugefügt.
	 */
	@Override
	public void setupNeighbours(Cell[][] cellGrid) {
		int [] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
		int [] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < cellGrid.length && ny >= 0 && ny < cellGrid[0].length) {
				neighbours.add(cellGrid[nx][ny]);
			}
		}
	}
	
	/**
	 * Aktualisiert den Zustand der Zelle auf den berechneten nächsten Zustand.
	 */
	@Override
	public void changeState() {
		this.alive = this.nextState;
	}
	
	/**
	 * Ändert den nächsten Zustand auf true (lebendig)
	 */
	@Override
	public void beBorn() {
		this.nextState = true;
	}
	
	/**
	 * Ändert den nächsten zustand auf false (tot)
	 */
	@Override
	public void die() {
		this.nextState = false;
	}
	
	/**
	 * Returniert ob die Zelle lebendig ist.
	 */
	@Override
	public boolean isAlive() {
		return this.alive;
	}
	
	/**
	 * Getter Methode für die X Koordinate einer Zelle.
	 */
	@Override
	public int getX() {
		return this.x;
	}
	
	/**
	 * Getter Methode für die Y Koordinate einer Zelle.
	 */
	@Override
	public int getY() {
		return this.y;
	}
	
	/**
	 * Returniert die Liste der Nachbarn der Zelle.
	 */
	@Override
	public List<Cell> getNeighbours() {
		return this.neighbours;
	}
	
	/**
	 * Wird in der Subklasse 'Concrete Cell' implementiert. Berechnet den nächsten Zustand einer Zelle.
	 */
	@Override
	public abstract void calculateNextState();
}