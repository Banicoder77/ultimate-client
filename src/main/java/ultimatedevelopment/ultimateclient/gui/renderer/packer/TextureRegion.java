/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.gui.renderer.packer;

public class TextureRegion {
    public double x1, y1;
    public double x2, y2;

    public double diagonal;

    public TextureRegion(double width, double height) {
        diagonal = Math.sqrt(width * width + height * height);
    }
}
