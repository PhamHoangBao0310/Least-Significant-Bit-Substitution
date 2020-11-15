/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funtions;

import java.awt.image.BufferedImage;

/**
 *
 * @author DELL
 */
public class Encode {

    BufferedImage img;

    public Encode() {
    }

    public Encode(BufferedImage img) {
        this.img = img;
    }

    public String padding(int b) {
        String bin = Integer.toBinaryString(b);
        while (bin.length() < 8) {
            bin = "0" + bin;
        }
        return bin;
    }

    public String messageToBinary(String mess) {
        String result = "";
        for (char c : mess.toCharArray()) {
            result += padding(c);
        }
        return result + "00000000";
    }

    public BufferedImage getTextHidden(String text) {
        String txt = messageToBinary(text);
        char[] binHidden = txt.toCharArray();
        int count = 0;
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int rgb = img.getRGB(x, y);
                
                rgb = (binHidden[count++] == '0') ? (rgb & 0xFFFEFFFF) : (rgb | 0x00010000); 
                if (count == binHidden.length) {
                    img.setRGB(x, y, rgb);
                    break;
                }
                
                rgb = (binHidden[count++] == '0') ? (rgb & 0xFFFFFEFF) : (rgb | 0x00000100); 
                if (count == binHidden.length) {
                    img.setRGB(x, y, rgb);
                    break;
                }
                
                rgb = (binHidden[count++] == '0') ? (rgb & 0xFFFFFFFE) : (rgb | 0x00000001);
                if (count == binHidden.length) {
                    img.setRGB(x, y, rgb);
                    break;
                }
                
                img.setRGB(x, y, rgb);
            }
            if (count == binHidden.length) {
                break;
            }
        }
        return img;
    }
}

