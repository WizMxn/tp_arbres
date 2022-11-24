package fr.istic.prg1.tree;

import java.util.Scanner;

import fr.istic.prg1.tree_util.AbstractImage;
import fr.istic.prg1.tree_util.Iterator;
import fr.istic.prg1.tree_util.Node;
import fr.istic.prg1.tree_util.NodeType;

/**
 * @author Mickaël Foursov <foursov@univ-rennes1.fr>
 * @version 5.0
 * @since 2023-09-23
 * 
 *        Classe décrivant les images en noir et blanc de 256 sur 256 pixels
 *        sous forme d'arbres binaires.
 * 
 */

public class Image extends AbstractImage {
	private static final Scanner standardInput = new Scanner(System.in);

	public Image() {
		super();
	}

	public static void closeAll() {
		standardInput.close();
	}

	/**
	 * this devient identique à image2.
	 *
	 * @param image2 image à copier
	 *
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void affect(AbstractImage image2) {
		
		Iterator<Node> itImage = image2.iterator();
		Iterator<Node> itThis = iterator();
		itThis.clear();
		prefixeAffect(itImage,itThis);
		
	}
	public void prefixeAffect(Iterator<Node> itImage,Iterator<Node> itThis) {
	    switch (itImage.nodeType()) {
	        case DOUBLE : {

	            System.out.println("AddNoeud");
	            itThis.addValue(itImage.getValue());
	            
	            itImage.goLeft();
	            itThis.goLeft();
	            System.out.println("Gauche");
	            prefixeAffect(itImage,itThis);
	            itImage.goUp();
	            itThis.goUp();
	            System.out.println("Up");
	            
	            itImage.goRight();
	            itThis.goRight();
	            System.out.println("Droite");
	            prefixeAffect(itImage,itThis);
	            itImage.goUp();
	            itThis.goUp();
	            System.out.println("Up");
	            
	            
	        }
	        default : {
	        	if(itThis.isEmpty()) {
	        		System.out.println("AddLeaf");
		        	itThis.addValue(itImage.getValue());
	        	}
	        }
	        
	    }
	}

	/**
	 * this devient rotation de image2 à 180 degrés.
	 *
	 * @param image2 image pour rotation
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void rotate180(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient inverse vidéo de this, pixel par pixel.
	 *
	 * @pre !image.isEmpty()
	 */
	@Override
	public void videoInverse() {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient image miroir verticale de image2.
	 *
	 * @param image2 image à agrandir
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void mirrorV(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient image miroir horizontale de image2.
	 *
	 * @param image2 image à agrandir
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void mirrorH(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient quart supérieur gauche de image2.
	 *
	 * @param image2 image à agrandir
	 * 
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void zoomIn(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * Le quart supérieur gauche de this devient image2, le reste de this devient
	 * éteint.
	 * 
	 * @param image2 image à réduire
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void zoomOut(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient l'intersection de image1 et image2 au sens des pixels allumés.
	 * 
	 * @pre !image1.isEmpty() && !image2.isEmpty()
	 * 
	 * @param image1 premiere image
	 * @param image2 seconde image
	 */
	@Override
	public void intersection(AbstractImage image1, AbstractImage image2) {
	    Iterator<Node> itImage1 = image1.iterator();
	    Iterator<Node> itImage2 = image2.iterator();
	    Iterator<Node> itThis = iterator();
	    itThis.clear();
	    
	    recurseIntersection(itImage1, itImage2, itThis);

	}
	public void recurseIntersection(Iterator<Node> it1, Iterator<Node> it2, Iterator<Node> itThis) {
	    if(it1.getValue().state==2) {
	        if(it2.getValue().state==2) {
	            itThis.addValue(it1.getValue());
	            itThis.goLeft();
	            it1.goLeft();
	            it2.goLeft();
	            recurseIntersection(it1,it2, itThis);
	            it1.goUp();
	            it2.goUp();
	            itThis.goUp();
	            
	            it1.goRight();
	            it2.goRight();
	            itThis.goRight();
	            recurseIntersection(it1,it2,itThis);
	            it1.goUp();
	            it2.goUp();
	            itThis.goUp();
	        }
	        if(it2.getValue().state==1){
	            prefixeAffect(it1,itThis);

	        }
	        if(it2.getValue().state==0){
	            itThis.addValue(Node.valueOf(0));
	        }
	    }
	    
	    if(it1.getValue().state==1) {
	        if(it2.getValue().state==2) {
	            prefixeAffect(it2, itThis);
	        }
	        if(it2.getValue().state==1){
	            itThis.addValue(Node.valueOf(1));
	        }
	        if(it2.getValue().state==0){
	            itThis.addValue(Node.valueOf(0));
	        }
	    }
	    
	    if(it1.getValue().state==0) {
	        itThis.addValue(Node.valueOf(0));
	        
	    }
	}

	/**
	 * this devient l'union de image1 et image2 au sens des pixels allumés.
	 * 
	 * @pre !image1.isEmpty() && !image2.isEmpty()
	 * 
	 * @param image1 premiere image
	 * @param image2 seconde image
	 */
	@Override
	public void union(AbstractImage image1, AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * Attention : cette fonction ne doit pas utiliser la commande isPixelOn
	 * 
	 * @return true si tous les points de la forme (x, x) (avec 0 <= x <= 255)
	 *         sont allumés dans this, false sinon
	 */
	@Override
	public boolean testDiagonal() {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
		return false;
	}

	/**
	 * @param x abscisse du point
	 * @param y ordonnée du point
	 * @pre !this.isEmpty()
	 * @return true, si le point (x, y) est allumé dans this, false sinon
	 */
	@Override
	public boolean isPixelOn(int x, int y) {
	    Iterator<Node> it = iterator();
	    int x1=0;
	    int y1 =0;
	    int x2 =255;
	    int y2 = 255;
	    int midH = 255/2;
	    int midV = 255/2;
	    int mid = 255/2 ;
	    //découpe vaut true pour horizontale et false pour verticale
	    Boolean decoupe = true;
	    //tant qu'on est pas sur une case complètement allumée ou éteinte
	    while(it.getValue().state!=2){
	        //si découpe horizontale
	        if(Boolean.TRUE.equals(decoupe)){
	            //si le point y est compris entre le milieu et le bas
	            
	            if(y>midH && y<y2){
	                //fils droit
	            	
	                y1=midH;
	                midH = midH + midH/2;
	                it.goRight();
	            }
	            //si le point y est compris entre le bas et le milieu
	            else if(y<midH && y>=y1 ){
	                //fils gauche
	                y2=midH;
	                midH = midH - midH/2;
	                it.goLeft();
	            }
	            decoupe=false;
	        }
	        //si découpe verticale
	        if(Boolean.FALSE.equals(decoupe)){
	            //si le point x est compris entres le milieu et la droite
	            if(x>midV && x<=x2){
	                //fils droit
	                x1=midV;
	                midV = midV + midV/2;
	                it.goRight();
	            }
	            //si le point x est compris entre la gauche et le milieu
	            else if(x<midV && x>=x1){
	                //fils gauche
	                x2=midV;
	                midH = midH - midH/2;
	                it.goLeft();
	            }
	            decoupe=true;
	        }

	    }
	    //renvois true si la valeur de la feuille est allumée(1) false sinon
	    return (it.getValue().state == 1);
	    
	}
	  

	/**
	 * @param x1 abscisse du premier point
	 * @param y1 ordonnée du premier point
	 * @param x2 abscisse du deuxième point
	 * @param y2 ordonnée du deuxième point
	 * @pre !this.isEmpty()
	 * @return true si les deux points (x1, y1) et (x2, y2) sont représentés par la
	 *         même feuille de this, false sinon
	 */
	@Override
	public boolean sameLeaf(int x1, int y1, int x2, int y2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
		return false;
	}

	/**
	 * @param image2 autre image
	 * @pre !this.isEmpty() && !image2.isEmpty()
	 * @return true si this est incluse dans image2 au sens des pixels allumés false
	 *         sinon
	 */
	@Override
	public boolean isIncludedIn(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
		return false;
	}
}