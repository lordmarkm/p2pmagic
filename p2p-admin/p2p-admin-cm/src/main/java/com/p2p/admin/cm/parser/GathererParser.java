package com.p2p.admin.cm.parser;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.collect.Lists;
import com.p2p.commons.core.models.Card;

public class GathererParser {

    public List<Card> parsePage(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();

        List<Card> cards = Lists.newArrayList();

        Elements cardElements = doc.select(".cardItem");
        for (Iterator<Element> i = cardElements.iterator(); i.hasNext();) {
            Card card = parseCard(i.next());
            cards.add(card);
        }

        return cards;
    }

    private Card parseCard(Element e) {
        Card card = new Card();

        //name
        String name = e.select("td.name a").text();
        card.setName(name);

        //mana
        StringBuilder manaBuilder = new StringBuilder();
        Elements mana = e.select("td.mana img");
        for (Iterator<Element> i = mana.iterator(); i.hasNext();) {
            Element manaSymbol = i.next();
            String manaUrl = manaSymbol.attr("src");
            manaBuilder.append(parseMana(manaUrl));
        }
        card.setCost(manaBuilder.toString());

        //type
        String type = e.select("td.type").text();
        String[] types = type.split("—");
        card.setSupertype(types[0].trim());
        if (types.length == 2) {
            card.setSubtype(types[1].trim());
        }

        //rarity
        Elements printingImgs = e.select("td.printings img");
        String printingsStr = printingImgs.first().attr("src");
        card.setRarity(printingsStr.substring(printingsStr.length() - 1));

        return card;
    }

    private String parseMana(String str) {
        String params = str.substring(str.indexOf('?'));
        for (String param : params.split("&")) {
            if (param.startsWith("name")) {
                return param.split("=")[1];
            }
        }
        return "";
    }
}
