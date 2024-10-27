# Game of Life Siumation
This project is a Java-based simulation of Conway's "Game of Life".
It models cellular automaton behavior through a grid of cells, where each cell follows simple rules to *live*, *die*, or *reproduce* based on its neighbors. This fascinating concept showcases how complex patterns can emerge from basic rules.

## Project Structure
The core of this project includes:

- **AbstractCell.java:** Defines the behavior and shared attributes of cells in the simulation.
- **ConcreteCell.java:** Implements the specific states and transitions of each cell based on Conway's rules.

I developed the AbstractCell and ConcreteCell classes, while the remaining functionality was implemented by my teacher Aleksandar Travanov.

## Getting Started
1. Clone this repository to your local machine.
2. Compile and run the simulation in your preferred IDE or command line.

## How It Works
1. Grid Initialization: Set up the initial configuration of cells in a grid.
2. Cellular Evolution: Cells interact based on Conway’s rules, advancing through each generation.
3. Visualization: Observe the pattern evolution over time.

Enjoy experimenting with different initial configurations to see how life unfolds!
