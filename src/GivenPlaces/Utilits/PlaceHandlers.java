package GivenPlaces.Utilits;

import GivenPlaces.Utilits.CustomExceptions.EmptyStringException;

public interface PlaceHandlers {
    // Здесь описываются возможные запросы по обработке мест, которые нельзя положить в Interaction
    public void handleHashMapChange() throws EmptyStringException;
}
