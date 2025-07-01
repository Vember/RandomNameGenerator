import java.util.HashSet;
import java.util.Random;

public class NameGenerator {

    private static String[] cons = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
    private static String[] vows = {"a", "e", "i", "o", "u"};
    private static String[] dCons = {"ck", "bb", "th", "cc", "dd", "ss", "tt", "ll", "rr", "dr", "st", "nd", "gg", "ph", "br", "mb", "ch",
            "pt", "bs", "rv", "pr", "sp", "mp", "ct", "nn", "pp", "cl", "ny", "sh", "nt", "rl", "yl", "sk", "xy", "cy", "sm", "rs", "rg", "rt", "sl"};
    private static String[] dVows = {"ea", "ae", "ei", "ou", "ee", "oi", "ia", "ai", "oo", "ie", "io", "au", "ue", "oa"};
    private static String[] tCons = {"ndr"};
    private static String[] tConsEnds = {"rry", "ryl", "rth"};
    private static String[] dConsStarts = {"Sl", "Bl", "Ch", "St", "Br", "Tr", "Pl", "Cr", "Cl", "Sk", "Th"};
    private static String[] tConsStarts = {"Chr", "Thr", "Chl"};

    public static String toProperNounFormat(String text) {

        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char ch : text.toCharArray()) {

            if (Character.isWhitespace(ch)) {
                result.append(ch);
                capitalizeNext = true;

            } else if (capitalizeNext) {

                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;

            } else {

                result.append(Character.toLowerCase(ch));
            }
        }
        return result.toString();
    }

    public static String generateName(int nameLength) {

        Random random = new Random();

        if (nameLength == 0) {
            return null;
        }

        StringBuilder name = new StringBuilder();
        boolean conNext = true;
        int randomStart = random.nextInt(2);
        int doubleStart = random.nextInt(100);
        int tripleStart = random.nextInt(200);

        if (randomStart == 0 && tripleStart <= 15 && nameLength > 2) {

            name.append(tConsStarts[random.nextInt(tConsStarts.length)]);
            nameLength -= 3;
            conNext = false;

        } else if (randomStart == 0 && doubleStart <= 15 && nameLength > 1) {

            name.append(dConsStarts[random.nextInt(dConsStarts.length)]);
            nameLength -= 2;
            conNext = false;

        } else if (randomStart == 0) {

            name.append(cons[random.nextInt(cons.length)]);
            nameLength--;
            conNext = false;
            name = new StringBuilder(name.toString().toUpperCase());

        } else {

            name.append(vows[random.nextInt(vows.length)]);
            nameLength--;
            name = new StringBuilder(name.toString().toUpperCase());
        }

        for (int i = 0; i < nameLength; i++) {

            int doubleChance = random.nextInt(100);
            int tripleChance = random.nextInt(1000);

            if (nameLength - i < 2) {

                if (conNext) {

                    name.append(cons[random.nextInt(cons.length)]);
                    conNext = false;

                } else {

                    name.append(vows[random.nextInt(vows.length)]);
                    conNext = true;
                }

            } else if (nameLength - i > 3 && tripleChance < 10 && conNext) {

                name.append(tCons[random.nextInt(tCons.length)]);
                conNext = false;
                i += 2;

            } else if (nameLength - i == 3 && tripleChance < 10 && conNext) {

                name.append(tConsEnds[random.nextInt(tConsEnds.length)]);
                conNext = false;
                i += 2;

            } else {

                if (doubleChance < 10 && conNext) {

                    name.append(dCons[random.nextInt(dCons.length)]);
                    conNext = false;
                    i++;

                } else if (doubleChance < 10) {

                    name.append(dVows[random.nextInt(dVows.length)]);
                    conNext = true;
                    i++;

                } else if (conNext) {

                    name.append(cons[random.nextInt(cons.length)]);
                    conNext = false;

                } else {

                    name.append(vows[random.nextInt(vows.length)]);
                    conNext = true;
                }
            }
        }
        return name.toString();
    }

    public static String generateName() {

        Random rand = new Random();
        return generateName(rand.nextInt(3, 9));
    }

    public static void generateGivenName(String name) {

            int attempts = 0;
            name = toProperNounFormat(name);

            while (true) {

                String nameGen = generateName(name.length());
                System.out.println(nameGen);
                attempts++;

                if (nameGen.equals(name)) {
                    break;
                }
            }
            System.out.println("Took " + attempts + " attempts");
    }

    public static void generateMultiple(int nameAmount, int nameLength) {

        for (int i = 0; i < nameAmount; i++) {

            System.out.println(generateName(nameLength));
        }

    }

    public static String genNameChosenLetter(String letter) {

        Random rand = new Random();
        String name = generateName(rand.nextInt(3, 8));

        letter = letter.toLowerCase();
        boolean found = false;

        for (String con : cons) {

            if (con.equals(letter)) {
                letter = letter.toUpperCase();
                found = true;
            }
        }

        for (String vow : vows) {

            if (vow.equals(letter)) {
                letter = letter.toUpperCase();
                found = true;
            }
        }

        if (!found) {
            return null;
        }

        while (name.charAt(0) != letter.charAt(0)) {

            name = generateName(rand.nextInt(3, 8));
        }

        return (name);

    }

    public static void genUniqueNames(int nameLength) {

        HashSet<String> uniqueNames = new HashSet<>();
        String name;

        for (int i = 0; i < 1000000; i++) {

            name = generateName(nameLength);
            System.out.println(name);
            uniqueNames.add(name);
        }
        System.out.println("Unique Names in 1 Million: " + uniqueNames.size());
        uniqueNames.clear();
    }

}
