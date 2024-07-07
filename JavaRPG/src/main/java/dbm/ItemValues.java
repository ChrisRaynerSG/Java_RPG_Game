package dbm;

public enum ItemValues {
    WEAK_HEALING_POTION(1),
    AVERAGE_HEALING_POTION(2),
    STRONG_HEALING_POTION(3),
    MAX_HEALING_POTION(4),
    ABILITY_POTION(5),
    ABILITY_UP_POTION(6),
    XP_POTION(7),
    ELIXIR_OF_UNDYING(8),
    LEATHER_ARMOUR(9),
    PADDED_ARMOUR(10),
    CHAIN_ARMOUR(11),
    SPLINT_ARMOUR(12),
    HALF_PLATE(13),
    FULL_PLATE(14),
    MAGIC_PLATE(15),
    DAGGER(16),
    SHORT_SWORD(17),
    RAPIER(18),
    BROADSWORD(19),
    LONGSWORD(20),
    BASTARD_SWORD(21),
    GREATSWORD(22),
    MAGICAL_GREATSWORD(23),
    HAND_AXE(24),
    BATTLE_AXE(25),
    GREAT_AXE(26),
    CLUB(27),
    MACE(28),
    HEAVY_MACE(29),
    GREAT_MACE(30),
    DAGGER_OF_MURDER(31),
    SWORD_OF_SLICING(32),
    MACE_OF_B(33),
    RUBBER_CHICKEN(34),
    DUNGEON_KEY(35),
    CASTLE_KEY(36),
    TOMB_KEY(37),
    ORB_OF_ORB(38);

    private final int itemId;

    ItemValues(int itemId){
        this.itemId = itemId;
    }

    public int getItemId(){
        return itemId;
    }

    public static int getItemId(String itemName){
        return switch(itemName){
            case "weak healing potion" -> WEAK_HEALING_POTION.getItemId();
            case "average healing potion" -> AVERAGE_HEALING_POTION.getItemId();
            case "strong healing potion" -> STRONG_HEALING_POTION.getItemId();
            case "max healing potion" -> MAX_HEALING_POTION.getItemId();
            case "ability potion" -> ABILITY_POTION.getItemId();
            case "ability up potion" -> ABILITY_UP_POTION.getItemId();
            case "xp potion" -> XP_POTION.getItemId();
            case "elixir of undying" -> ELIXIR_OF_UNDYING.getItemId();
            case "leather armour" -> LEATHER_ARMOUR.getItemId();
            case "padded armour" -> PADDED_ARMOUR.getItemId();
            case "chain armour" -> CHAIN_ARMOUR.getItemId();
            case "splint armour" -> SPLINT_ARMOUR.getItemId();
            case "half plate" -> HALF_PLATE.getItemId();
            case "full plate" -> FULL_PLATE.getItemId();
            case "magic plate" -> MAGIC_PLATE.getItemId();
            case "dagger" -> DAGGER.getItemId();
            case "short sword" -> SHORT_SWORD.getItemId();
            case "rapier" -> RAPIER.getItemId();
            case "broadsword" -> BROADSWORD.getItemId();
            case "longsword" -> LONGSWORD.getItemId();
            case "bastard sword" -> BASTARD_SWORD.getItemId();
            case "greatsword" -> GREATSWORD.getItemId();
            case "magical greatsword" -> MAGICAL_GREATSWORD.getItemId();
            case "hand axe" -> HAND_AXE.getItemId();
            case "battle axe" -> BATTLE_AXE.getItemId();
            case "great axe" -> GREAT_AXE.getItemId();
            case "club" -> CLUB.getItemId();
            case "mace" -> MACE.getItemId();
            case "heavy mace" -> HEAVY_MACE.getItemId();
            case "great mace" -> GREAT_MACE.getItemId();
            case "dagger of Murder" -> DAGGER_OF_MURDER.getItemId();
            case "dom" -> DAGGER_OF_MURDER.getItemId();
            case "sword of slicing" -> SWORD_OF_SLICING.getItemId();
            case "sos"-> SWORD_OF_SLICING.getItemId();
            case "mob" -> MACE_OF_B.getItemId();
            case "mace of Bruises" -> MACE_OF_B.getItemId();
            case "rubber chicken" -> RUBBER_CHICKEN.getItemId();
            case "dungeon key" -> DUNGEON_KEY.getItemId();
            case "castle key" -> CASTLE_KEY.getItemId();
            case "tomb key" -> TOMB_KEY.getItemId();
            case "orb" -> ORB_OF_ORB.getItemId();
            case "orb of orb" -> ORB_OF_ORB.getItemId();
            case "orb of orbing" -> ORB_OF_ORB.getItemId();
            default -> -1;
        };
    }
}
