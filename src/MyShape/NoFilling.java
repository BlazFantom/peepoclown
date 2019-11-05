/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyShape;

import java.awt.Graphics2D;

/**
 *
 * @author Netbeans
 */
public class NoFilling implements Filler{
       
       @Override
       public void Filling(Graphics2D gr, MyShape current){
           gr.setColor(current.getColor());
           gr.draw(current.getRd());
       }

    @Override
    public Filler clone() {
        return new NoFilling();
    }
}