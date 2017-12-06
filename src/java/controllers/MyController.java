/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import api.CardAPI;
import api.CardStore;
import api.DeckAPI;
import api.DeckStore;
import api.SchoolClassAPI;
import api.SchoolClassStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import models.Card;

import models.Deck;
import models.SchoolClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author it354f715
 */
@Controller
public class MyController {

    @Autowired
    DeckStore deckStore;
    @Autowired
    CardStore cardStore;
    @Autowired
    SchoolClassStore schoolClassStore;
    @Autowired
    CardAPI cardAPI;
    @Autowired
    DeckAPI deckAPI;
    @Autowired
    SchoolClassAPI schoolClassAPI;
    List<Deck> deckList;
    List<Card> cardList;
    List<Card> cardListToAdd;
    List<SchoolClass> schoolClassList;
    Deck tempDeck;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewIndex(Model model) {

        deckList = deckStore.getAllDecks();

        model.addAttribute("deckList", deckList);

        return "index";
    }

    @RequestMapping(value = "/viewDeckDetails/{id}", method = RequestMethod.GET)
    public String viewDeckDetails(@PathVariable("id") String deckid, Model model) {

        cardList = cardStore.getCardsByDeckid(deckid);
        Iterator<Deck> it = deckList.iterator();
        Deck tempDeck;
        String deckName = null;
        while (it.hasNext()) {
            tempDeck = it.next();
            if (tempDeck.getId().equals(deckid)) {
                deckName = tempDeck.getDeckname();
            }
        }
        model.addAttribute("deckName", deckName);
        model.addAttribute("cardList", cardList);

        return "deckDetails";
    }

    @RequestMapping(value = "/addDeck", method = RequestMethod.GET)
    public String viewAddDeckPage(Model model) {

        schoolClassList = schoolClassStore.getAllSchoolClasses();
        Collections.sort(schoolClassList, new Comparator<SchoolClass>() {
            public int compare(SchoolClass sc1, SchoolClass sc2) {
                return sc1.getClassnumber().compareTo(sc2.getClassnumber());
            }
        });

        model.addAttribute("schoolClassList", schoolClassList);
        return "addDeck";
    }

    @RequestMapping(value = "/addClass", method = RequestMethod.POST)
    public String postClass(@RequestParam("classname") String classname, @RequestParam("classnumber") String classnumber, Model model) {
        String message = "";
        if (!classname.isEmpty() && !classnumber.isEmpty()) {
            classnumber = classnumber.replaceAll(",", "").toUpperCase();

            String[] tempArray = classname.split(" ");
            String classnameToSend = "";
            for (String s : tempArray) {
                classnameToSend += s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
            }
            classnameToSend = classnameToSend.trim();

            SchoolClass tempClass = new SchoolClass(classnumber, classnameToSend);
            if (schoolClassAPI.postClass(tempClass)) {
                message = "Class Added Successfully";
            } else {
                message = "There was an error in adding a class";
            }
        } else {
            message = "Fill Class number and name";
        }

        schoolClassList = schoolClassStore.getAllSchoolClasses();
        Collections.sort(schoolClassList, new Comparator<SchoolClass>() {
            public int compare(SchoolClass sc1, SchoolClass sc2) {
                return sc1.getClassnumber().compareTo(sc2.getClassnumber());
            }
        });
        model.addAttribute("message", message);
        model.addAttribute("schoolClassList", schoolClassList);
        return "addDeck";
    }

    public String showDeckCreationPage(Model model) {
        schoolClassList = schoolClassStore.getAllSchoolClasses();
        Collections.sort(schoolClassList, new Comparator<SchoolClass>() {
            public int compare(SchoolClass sc1, SchoolClass sc2) {
                return sc1.getClassnumber().compareTo(sc2.getClassnumber());
            }
        });

        model.addAttribute("schoolClassList", schoolClassList);
        return "addDeck";
    }

    @RequestMapping(value = "/doAddDeck", method = RequestMethod.POST)
    public String createTempDeck(@RequestParam("deckname") String deckname, @RequestParam("classid") String classid, Model model) {
        deckname = deckname.substring(0, 1).toUpperCase() + deckname.substring(1);
        String userid = "1";
        System.out.println("Classid: " + classid);
        if (!deckname.isEmpty()) {
            tempDeck = new Deck(deckname, classid, userid);
            if (tempDeck != null) {
                return this.showAddCardPage(model);
            } else {
                schoolClassList = schoolClassStore.getAllSchoolClasses();
                Collections.sort(schoolClassList, new Comparator<SchoolClass>() {
                    public int compare(SchoolClass sc1, SchoolClass sc2) {
                        return sc1.getClassnumber().compareTo(sc2.getClassnumber());
                    }
                });
                model.addAttribute("schoolClassList", schoolClassList);
                model.addAttribute("message", "Error in crearing a deck");
                return "addDeck";
            }
        } else {
            model.addAttribute("message", "Enter a deckname");
            schoolClassList = schoolClassStore.getAllSchoolClasses();
            Collections.sort(schoolClassList, new Comparator<SchoolClass>() {
                public int compare(SchoolClass sc1, SchoolClass sc2) {
                    return sc1.getClassnumber().compareTo(sc2.getClassnumber());
                }
            });
            model.addAttribute("schoolClassList", schoolClassList);
            return "addDeck";
        }
    }

    @RequestMapping(value = "/doAddCard", method = RequestMethod.POST)
    public String addCardToList(@RequestParam("question") String question, @RequestParam("answer") String answer, Model model) {
        int priority = cardListToAdd.size() + 1;
        if (!question.isEmpty() && !answer.isEmpty()) {
            if (tempDeck != null) {
                String deckid = tempDeck.getId();
                cardListToAdd.add(new Card(question.trim(), answer.trim(), deckid, priority));
                model.addAttribute("message", "");
                model.addAttribute("deck", tempDeck);
                String classid = tempDeck.getClassid();
                schoolClassList = schoolClassStore.getAllSchoolClasses();
                Iterator<SchoolClass> it = schoolClassList.iterator();
                SchoolClass temp = null;
                String classnumber = null;
                String classname = null;
                while (it.hasNext()) {
                    temp = it.next();
                    if (temp.getId().equals(classid)) {
                        classnumber = temp.getClassnumber();
                        classname = temp.getClassname();
                    }
                }
                model.addAttribute("classnumber", classnumber);
                model.addAttribute("classname", classname);
            } else {
                return showDeckCreationPage(model);
            }
            if (cardListToAdd.size() > 0) {
                model.addAttribute("cardList", cardListToAdd);
            }
        } else {
            model.addAttribute("message", "Fill both Question and Answer");
        }
        return "addCards";
    }

    public String showAddCardPage(Model model) {
        cardListToAdd = new ArrayList<>();
        String classid = tempDeck.getClassid();
        schoolClassList = schoolClassStore.getAllSchoolClasses();
        Iterator<SchoolClass> it = schoolClassList.iterator();
        SchoolClass temp = null;
        String classnumber = null;
        String classname = null;
        while (it.hasNext()) {
            temp = it.next();
            if (temp.getId().equals(classid)) {
                classnumber = temp.getClassnumber();
                classname = temp.getClassname();
            }
        }
        model.addAttribute("classnumber", classnumber);
        model.addAttribute("classname", classname);
        model.addAttribute("deck", tempDeck);
        model.addAttribute("cardList", cardListToAdd);
        return "addCards";
    }

    public String reloadAddCardPage(Model model) {
        String classid = tempDeck.getClassid();
        schoolClassList = schoolClassStore.getAllSchoolClasses();
        Iterator<SchoolClass> it = schoolClassList.iterator();
        SchoolClass temp = null;
        String classnumber = null;
        String classname = null;
        while (it.hasNext()) {
            temp = it.next();
            if (temp.getId().equals(classid)) {
                classnumber = temp.getClassnumber();
                classname = temp.getClassname();
            }
        }
        model.addAttribute("classnumber", classnumber);
        model.addAttribute("classname", classname);
        model.addAttribute("deck", tempDeck);
        model.addAttribute("cardList", cardListToAdd);
        return "addCards";
    }

    @RequestMapping(value = "/finalizeDeck", method = RequestMethod.POST)
    public String finalizeDeck(Model model) {
        if (cardListToAdd.size() > 0) {
            deckAPI.postDeck(tempDeck);
            List<Deck> tempList = deckStore.getDeckByUseridAndClassidAndDeckname(tempDeck.getUserid(), tempDeck.getClassid(), tempDeck.getDeckname());
            Deck temp = tempList.get(0);
            for (Card card : cardListToAdd) {
                card.setId(temp.getId());
                cardAPI.postCard(card);
            }
            return this.showDeckCreationSuccess(model);
        } else {
            model.addAttribute("message", "Need cards to finalize your deck.");
            return this.reloadAddCardPage(model);
        }
    }

    public String showDeckCreationSuccess(Model model) {
        model.addAttribute("message", tempDeck.getDeckname() + " was created!");
        return "deckCreated";
    }

    @RequestMapping(value = "/removeCard/{index}", method = RequestMethod.GET)
    public String removeCard(@PathVariable("index") int index, Model model) {
        if (cardListToAdd.size() > 0) {
            cardListToAdd.remove(index);
        }
        return this.reloadAddCardPage(model);
    }

}
