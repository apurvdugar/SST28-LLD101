import java.util.*;

class RoomPrices {
    private static Map<Integer, Pricing> Rooms = Map.of(
        LegacyRoomTypes.SINGLE, new RoomPricing(new Money(14000.0)),
        LegacyRoomTypes.DOUBLE, new RoomPricing(new Money(15000.0)),
        LegacyRoomTypes.TRIPLE, new RoomPricing(new Money(12000.0)),
        LegacyRoomTypes.DELUXE, new RoomPricing(new Money(16000.0))
    );

    public static Pricing get(int roomType) {
        return Rooms.get(roomType);
    }
}