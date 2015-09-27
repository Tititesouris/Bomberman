package tools;

import org.newdawn.slick.Image;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Tool extends Image {

    public static Image getImage(String url) {
        try {
            return new Image(System.class.getResource(url).openStream(), url, false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
