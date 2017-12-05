package break_out.model;

import break_out.model.Vector2D;


/**
 * This object contains information about the running game
 * 
 * @author Eric Neuwald 675477
 * @author Stefan Scheunemann 674685
 * @ Gruppe 165
 */
public class Level extends Thread {
	
    Vector2D vector = new Vector2D();

    /**
     * The game to which the level belongs 
     */
    private Game game;
	 
    /**
   	 * The number of the level
   	 */
    private int levelnr;
       
    /**
	 * The score of the level
	 */
    private int score;
    
    /**
     * The current x- and y-position of the ball
     */
    private Position ballPos;
    
    
    private Vector2D direction = new Vector2D(2, -2);
    
    //direction.rescale();
    
    double invert = -1.0;
    
    
    /**
     * Flag that shows if the ball was started
     */
    private boolean ballWasStarted = true;

        
    /**
     * Der Konstruktor instanziiert einen neuen Level:
     * @param game Das zugehoerige Game-Objekt
     * @param levelnr Die Nummer des zu instanziierenden Levels
     * @param score Der bisher erreichte Scorewert
     */
    public Level(Game game, int levelnr, int score) {
    	this.game = game;
    	this.levelnr = levelnr;
    	this.score = score;
        this.ballPos = new Position(392.5, 610);
        loadLevelData(levelnr);
        this.direction = direction;
    }

    
    /**
     * Getter for the ballposition
     * @return ballPos The current position of the ball
     */
    public Position getBallPos() {
        return ballPos;
    }
    
    public Vector2D getdirection() {
    	return direction;
    }

    
    /**
     * Setzt ballWasStarted auf true, d.h. der Ball "startet", 
     * weil so die bedingten Anweisungen in der while-Schleife der run-Methode ausgefuehrt werden.
     */
    public void startBall() {
        ballWasStarted = true;
    }

    /**
     * Setzt ballWasStarted auf false, d.h. der Ball "pausiert", weil so die bedingten Anweisungen in der while-Schleife 
     * der run-Methode nicht ausgefuehrt werden.
     */
    public void stopBall() {
        ballWasStarted = false;
    }
    
    /**
     * Liefert den booleschen Wert der Variablen ballWasStarted
     * @return ballWasStarted True, wenn sich der Ball bewegt, sonst false
     */
    public boolean ballWasStarted() {
        return ballWasStarted;
    }


    /**
     * Diese Methode enthaelt die Threadlogik, d.h. hier wird festgelegt, was im Thread ablaeuft.
     */
    public void run() {	
    	
    	//Vector2D Richtung = new Vector2D();
    	
    	game.notifyObservers();
    		
    	// Endlosschleife fuer den Ablauf
    	while (true) {
    		// wenn ballWasStarted wahr ist (d.h. der Ball soll sich bewegen)
	        if (ballWasStarted) {
	                
	            // Die Posiotionen von x und y werden in einer neuen Variable des Typs double abgelegt       	
	        	double PosX = ballPos.getX();
	        	double PosY = ballPos.getY();
        	
	        	/** x und y werden auf ihre Position überpüft und falls sie einen Rand berühren, werden sie umgeleitet
	        	* Die Umleitung muss nur auf der Achse durchgeführt werden, auf der die Wand berührt wird
	        	* Die Umleitung findet statt, indem der dx bzw. dy Wert invertiert wird.
	        	*/
	            if(PosX <= 0) {
	            	double dx = vector.getDX() * invert;
	            	vector.setDX(dx);
	            }
	            
	            if(PosX >= 792.5) {
	            	double dx = vector.getDX() * invert;
	            	vector.setDX(dx);
	            }
	            
	        	          
	            if(PosY <= 0) {
	            	double dy = vector.getDY() * invert;	
	            	vector.setDY(dy);
	            }
	            
	            if(PosY >= 617.5) {
	            	double dy =  vector.getDY() * invert;
	            	vector.setDY(dy);
	            }
	            
	            	
	            // in einer Variable x bzw. y wird die alte Position des Balls addiert mit dem dx bzw. dy Wert
	            // und darauf wird die neue Position durch ballPos.set zurückgegeben
	            double x = ballPos.getX() + direction.getDX();
	            ballPos.setX(x);
	        	
	            
	            double y = ballPos.getY() + direction.getDY();
	            ballPos.setY(y);	
	                               
	            // Das als Observer angemeldete View-Objekt wird informiert, damit ein Neuzeichnen (repaint)
	        	// des Spielfeldes vorgenommen wird.
	            game.notifyObservers();    
	                
	        }
	        // Der Thread pausiert kurz
	        try {
	            Thread.sleep(4);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
    	}   
    }
    
    
    /**
    * Zugriff auf die der Levelnummer zugeordnete JSON-Datei
    * @param levelnr Die Nummer X fuer die LevelX.json Datei
    */
    private void loadLevelData(int levelnr) {
    		
    }
    
}
    


	
