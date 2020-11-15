/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funtions;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author DELL
 */
public class Generator {

    public static BufferedImage setImage(File link, JLabel label) throws Exception {

        BufferedImage img = ImageIO.read(link);
        if (img != null) {
            ImageIcon icon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(label.getWidth(),
                    label.getHeight(), Image.SCALE_SMOOTH));
            label.setIcon(icon);
        }
        return img;
    }
}
