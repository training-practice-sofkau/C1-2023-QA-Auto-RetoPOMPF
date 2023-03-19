package com.sofkau.setup;

import io.restassured.http.ContentType;

import static com.sofkau.setup.SetUpConsts.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;

public class MarvelCon {

    protected void getToBaseURL() {
        given().contentType(ContentType.JSON).get(URL);
    }

    protected String eventsURL() {
        return String.format(URL, EVENTS_SLUG);
    }

    protected String charactersByEventIdURL(String eventId) {
        return eventsURL() + "/" + eventId + CHARACTERS_SLUG;
    }

    protected String addParams(String url) {
        return url + PARAMS + TS + PARAM_CON + API_KEY + PARAM_CON + HASH;
    }

    protected void whenGet(String url) {
        when().get(url);
    }

    protected void validateEventsId(String url) {
        get(url).then().assertThat().body(EVENT_ROUTE, hasItems(EVENT_ID.get(0), EVENT_ID.get(1), EVENT_ID.get(2),
                                                                EVENT_ID.get(3), EVENT_ID.get(4), EVENT_ID.get(5),
                                                                EVENT_ID.get(6), EVENT_ID.get(7), EVENT_ID.get(8),
                                                                EVENT_ID.get(9), EVENT_ID.get(10), EVENT_ID.get(11),
                                                                EVENT_ID.get(12), EVENT_ID.get(13), EVENT_ID.get(14),
                                                                EVENT_ID.get(15), EVENT_ID.get(16), EVENT_ID.get(17),
                                                                EVENT_ID.get(18), EVENT_ID.get(19)));
    }

    protected void validateCharactersIdByEventId(String url) {
        get(url).then().assertThat().body(CHARACTER_ROUTE, hasItems(CHARACTER_ID.get(0), CHARACTER_ID.get(1),
                                                                    CHARACTER_ID.get(2), CHARACTER_ID.get(3),
                                                                    CHARACTER_ID.get(4), CHARACTER_ID.get(5),
                                                                    CHARACTER_ID.get(6), CHARACTER_ID.get(7),
                                                                    CHARACTER_ID.get(8), CHARACTER_ID.get(9),
                                                                    CHARACTER_ID.get(10), CHARACTER_ID.get(11),
                                                                    CHARACTER_ID.get(12), CHARACTER_ID.get(13),
                                                                    CHARACTER_ID.get(14), CHARACTER_ID.get(15),
                                                                    CHARACTER_ID.get(16), CHARACTER_ID.get(17),
                                                                    CHARACTER_ID.get(18), CHARACTER_ID.get(19)));
    }
}