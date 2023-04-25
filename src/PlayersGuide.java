import item.sword.Gemstone;
import item.sword.Material;
import item.sword.Sword;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 37.");
        Sword defaultSword = Sword.createDefaultSword();
        System.out.println("Created default sword: " + defaultSword);
        Sword modifiedSword = defaultSword.createModifiedCopy(Material.BRONZE);
        System.out.println("Created modified sword: " + modifiedSword);
        Sword modifiedSword2 = modifiedSword.createModifiedCopy(Gemstone.DIAMOND);
        System.out.println("Modified sword further: " + modifiedSword2);
    }
}
