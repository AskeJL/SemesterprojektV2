package data;

/**
 * The type of asset that the data layer should look for.
 *
 * The type is associated with a path to a folder, i.e: AssetType.TEXT =
 * "assets/text/"
 * 
 * @see data.read.ReadController#getData(AssetType, String) ReadController.getData
 */
public enum AssetType {
    PICTURE,    // "assets/pictures/"
    TEXT,       // "assets/text/"
    MAP,        // "assets/maps/"
    SOUND,      // "assets/sound/"
    SCORE,      // "assets/score/"
    DESCRIPTION;// "assets/descriptions/"
}
