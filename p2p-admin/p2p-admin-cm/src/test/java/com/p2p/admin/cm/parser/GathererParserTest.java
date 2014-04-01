package com.p2p.admin.cm.parser;

import java.io.IOException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.p2p.commons.core.models.Card;

public class GathererParserTest {

    private GathererParser parser = new GathererParser();

    @Test @Ignore
    public void test() throws IOException {
        List<Card> cards = parser.parsePage("http://gatherer.wizards.com/Pages/Search/Default.aspx?page=1&output=compact&set=%5B%22Theros%22%5D");
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
