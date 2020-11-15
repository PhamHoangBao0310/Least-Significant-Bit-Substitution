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
public class Decode {

    BufferedImage img;

    public Decode() {
    }

    public Decode(BufferedImage img) {
        this.img = img;
    }

    public char convertBinToChar(String binString) {
        byte r = 0;
        int len = binString.length();
        for (int i = len - 1; i >= 0; i--) {
            if (binString.charAt(i) == '1') {
                r += Math.pow(2, len - 1 - i);
            }
        }
        return (char) r;
    }

    public String convertBinaryToString(String binString) {
        String result = "";
        int length = binString.length();
        int numChar = length / 8;
        for (int i = 0; i < numChar; i++) {
            result += convertBinToChar(binString.substring(8 * i, 8 * (i + 1)));
        }
        return result;
    }

    public String getBinText() {
        String result = "";
        int x, y;
        for (x = 0; x < img.getWidth(); x++) {
            for (y = 0; y < img.getHeight(); y++) {
                int rgb = img.getRGB(x, y);
                String rgbString = Integer.toBinaryString(rgb);
                for (int i = 15; i <= 31; i = i + 8) {
                    char a = rgbString.charAt(i);
                    if (result.endsWith("00000000")) {
                        break;
                    }
                    result += a;
                }
            }
            if (result.endsWith("00000000")) {
                break;
            }
        }
        System.out.println(result);
        return convertBinaryToString(result);
    }
}
