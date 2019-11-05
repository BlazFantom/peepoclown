/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyShape;

import java.awt.Graphics2D;
import java.awt.geom.RectangularShape;

interface Filler{
    void Filling(Graphics2D g2, MyShape current);

    public Filler clone();
}