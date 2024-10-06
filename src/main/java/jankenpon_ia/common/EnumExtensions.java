package jankenpon_ia.common;

import java.util.Random;

public class EnumExtensions
{
    public static <T extends Enum<?>> T getRandomEnum(Class<T> enumClass) {
        T[] enumValues = enumClass.getEnumConstants();
        int randomIndex = new Random().nextInt(enumValues.length);
        return enumValues[randomIndex];
    }
}
